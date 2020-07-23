package com.ecologicalRanch.stepCounting;

import com.ecologicalRanch.config.ApplicationContextProvider;
import com.ecologicalRanch.project.entity.Coordinates;
import com.ecologicalRanch.project.entity.Livestock;
import com.ecologicalRanch.project.service.CoordinatesService;
import com.ecologicalRanch.project.service.GatewayService;
import com.ecologicalRanch.project.service.LivestockService;
import com.ecologicalRanch.redis.entity.BluetoothRssiInfo;
import com.ecologicalRanch.redis.service.ISaveRssiService;
import com.ecologicalRanch.redis.utils.PointUtil;

import java.awt.*;
import java.util.HashMap;

/**
 * 用于计算的线程
 */
public class CalculationThread extends Thread {

    private ISaveRssiService saveRssiService;
    private CoordinatesService coordinatesService;
    private GatewayService gatewayService;
    private LivestockService livestockService;

    private String bluetoothId;
    private HashMap<String, String> bluetoothInfo;

    private static Calculation datasourcePro;
    private static Kalman kalman_1 ;
    private static Kalman kalman_2 ;
    private static Kalman kalman_3 ;
/*

 */
    public CalculationThread(BluetoothRssiInfo bluetoothRssiInfo) {//  String bluetoothId
        this.datasourcePro=ApplicationContextProvider.getBean(Calculation.class);
        this.saveRssiService = ApplicationContextProvider.getBean(ISaveRssiService.class);
        this.coordinatesService = ApplicationContextProvider.getBean(CoordinatesService.class);
        this.gatewayService = ApplicationContextProvider.getBean(GatewayService.class);
        this.livestockService = ApplicationContextProvider.getBean(LivestockService.class);
        this.bluetoothId = bluetoothRssiInfo.getBluetoothId();
        this.bluetoothInfo = bluetoothRssiInfo.getGatewayInfo();//saveRssiService.getRssiWithHashMap(bluetoothId);
        kalman_1 = new Kalman(datasourcePro.getVarianc(), datasourcePro.getNoiseVariance());
        kalman_2 = new Kalman(datasourcePro.getVarianc(), datasourcePro.getNoiseVariance());
        kalman_3 = new Kalman(datasourcePro.getVarianc(), datasourcePro.getNoiseVariance());
    }

    @Override
    public void run() {
        int[] rssi = new int[3];
        int[][] data = new int[3][100];
        Point[] gatewayPoint = new Point[3];
        if (bluetoothInfo != null)
        try {
            Coordinates coordinates = new Coordinates();
            int count = 0;
            for (Object key : bluetoothInfo.keySet()) {
                gatewayPoint[count] = PointUtil.stringToPoint(key.toString());
                String[] r = bluetoothInfo.get(key).split(",");
                for (int i = 0; i < 100 && i < r.length; i++) {
                    data[count][i] = Integer.parseInt(r[i]);
                }
                count++;
            }
            coordinates = coordinatesService.selectCoordinatesById(bluetoothId);
            Point po = new Point(coordinates.getCoordinateX(), coordinates.getCoordinateY());
            rssi[0] = (new Double(kalman_count(kalman_1, data[0]) * 100)).intValue();
            rssi[1] = (new Double(kalman_count(kalman_2, data[1]) * 100)).intValue();
            rssi[2] = (new Double(kalman_count(kalman_3, data[2]) * 100)).intValue();
            Point point = threePoints(rssi, gatewayPoint);//������ı�ǩλ��
            coordinates.setCoordinateX(point.x);
            coordinates.setCoordinateY(point.y);
            coordinates.setBluetoothId(bluetoothId);
            System.out.println(bluetoothId+"计算结果："+point.x+","+point.y);
            coordinatesService.updateCoordinates(coordinates);
            int Steps = (int) count_distance(point, po) / 5;
            if(Steps>datasourcePro.getError()) {
                Livestock livestock = new Livestock();
                livestock.setStepNum(Steps);
                livestock.setBluetoothId(bluetoothId);
                livestockService.updateLivestockStep(livestock);
            }
        }
        catch (Exception e)
        {
            System.out.println("计算出错"+e.getMessage());
        }
    }

    /**
     * 通过滤波计算距离
     * @param kalman
     * @param rssi
     * @return
     */
    private static double kalman_count(Kalman kalman, int[] rssi) {
        double gap = 0;
        int d=0;
        for (int i = 0; i < rssi.length && rssi[i] != 0; i++) {
            gap = kalman.KalmanFilter(rssi[i]);
        }
        d=rssi[0];
        for (int i = 1; i < rssi.length && rssi[i] != 0; i++)
        {
            if(d!=Limiting(d,rssi[i])) {
                d=Limiting(d,rssi[i]);
                gap = kalman.KalmanFilter(d);
            }
        }
        return Count(gap);
    }

    /**
     * 通过偏差筛选
     * @param d
     * @param b
     * @return
     */
    private  static int Limiting(int d,int b)
    {
        if((b-d)<=datasourcePro.getDeviation())//(((d-b)<=deviation)||((b-d)<=deviation))
            return b;
        else
            return d;
    }

    /**
     * 通过RSSI计算距离
     * @param rssi
     * @return 距离
     */
    private static double Count(double rssi) {
        double n;
        n = Math.abs(rssi);
        n = ((n - datasourcePro.getCalibration()) / (10 * datasourcePro.getEnvironmentalFactor()));
        n =  Math.pow(10, n);
        n += 0.005;
        n *= 100;
        n = (int) n;
        n = n / 100;
        return n;
    }

    /**
     * 计算标签位置
     *
     * @param dis 标签离网关距离
     * @param gateway_coordinate  网关位置
     * @return
     */
    private static Point threePoints(int[] dis, Point[] gateway_coordinate) {
        double x = 0, y = 0;
        double x2,y2;
        if (dis == null || gateway_coordinate == null)
            return null;

        for (int i = 0; i < 2; i++) {
            if (dis[i] < 0)
                return null;

            for (int j = i + 1; j < 3; j++) {
                x2=Math.pow((gateway_coordinate[i].x - gateway_coordinate[j].x) , 2 );
                y2=Math.pow((gateway_coordinate[i].y - gateway_coordinate[j].y) , 2 );
                double p2p = Math.sqrt(x2+y2);
                if (dis[i] + dis[j] <= p2p) {
                    x += gateway_coordinate[i].x + (gateway_coordinate[j].x - gateway_coordinate[i].x) * dis[i] / (dis[i] + dis[j]);
                    y += gateway_coordinate[i].y + (gateway_coordinate[j].y - gateway_coordinate[i].y) * dis[i] / (dis[i] + dis[j]);
                } else {
                    double dr = p2p / 2 + (dis[i] * dis[i] - dis[j] * dis[j]) / (2 * p2p);
                    x += gateway_coordinate[i].x + (gateway_coordinate[j].x - gateway_coordinate[i].x) * dr / p2p;
                    y += gateway_coordinate[i].y + (gateway_coordinate[j].y - gateway_coordinate[i].y) * dr / p2p;
                }
            }
        }
        x /= 3;
        y /= 3;
        return new Point((new Double(x).intValue()), (new Double(y).intValue()));
    }

    /**
     *通过坐标位置计算距离
     * @param a
     * @param b
     */
    private static double count_distance(Point a, Point b) {
        double m = Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
        return m;
    }

}
