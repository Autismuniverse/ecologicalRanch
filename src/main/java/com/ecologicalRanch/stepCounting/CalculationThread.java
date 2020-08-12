package com.ecologicalRanch.stepCounting;

import com.ecologicalRanch.config.ApplicationContextProvider;
import com.ecologicalRanch.project.entity.Coordinates;
import com.ecologicalRanch.project.entity.Livestock;
import com.ecologicalRanch.project.entity.RssiSave;
import com.ecologicalRanch.project.service.CoordinatesService;
import com.ecologicalRanch.project.service.GatewayService;
import com.ecologicalRanch.project.service.LivestockService;
import com.ecologicalRanch.project.service.MongoDBService;
import com.ecologicalRanch.redis.entity.BluetoothRssiInfo;
import com.ecologicalRanch.redis.service.ISaveRssiService;
import com.ecologicalRanch.redis.utils.PointUtil;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.sql.Timestamp;
import java.util.HashMap;

/**
 * 用于计算的线程
 */
@Slf4j

public class CalculationThread extends Thread {

    private ISaveRssiService saveRssiService;
    private CoordinatesService coordinatesService;
    private GatewayService gatewayService;
    private LivestockService livestockService;
    private String bluetoothId;
    private HashMap<String, String> bluetoothInfo;
    private MongoDBService mongoDBService;
    private  Calculation datasourcePro;
    private double Side;
/*

 */
    public CalculationThread(BluetoothRssiInfo bluetoothRssiInfo) {//  String bluetoothId
        this.mongoDBService=ApplicationContextProvider.getBean(MongoDBService.class);
        this.datasourcePro=ApplicationContextProvider.getBean(Calculation.class);
        this.saveRssiService = ApplicationContextProvider.getBean(ISaveRssiService.class);
        this.coordinatesService = ApplicationContextProvider.getBean(CoordinatesService.class);
        this.gatewayService = ApplicationContextProvider.getBean(GatewayService.class);
        this.livestockService = ApplicationContextProvider.getBean(LivestockService.class);
        this.bluetoothId = bluetoothRssiInfo.getBluetoothId();
        this.bluetoothInfo = bluetoothRssiInfo.getGatewayInfo();//saveRssiService.getRssiWithHashMap(bluetoothId);

    }

    @Override
    public void run() {
        int[] rssi = new int[3];
        int[][] data = new int[3][100];
        Point[] gatewayPoint = new Point[3];
        if (bluetoothInfo != null) {
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
                GetSide(gatewayPoint);
                for(int i=0;i<3;i++)
                {
                    rssi[i] = (new Double(new Optimization(data[i]).data() * 100)).intValue();
                }
                rssi=LongDouble(rssi);
                Point point = threePoints(rssi, gatewayPoint);//������ı�ǩλ��
                coordinates.setCoordinateX(point.x);
                coordinates.setCoordinateY(point.y);
                coordinates.setBluetoothId(bluetoothId);
    //            System.out.println(bluetoothId+"计算结果："+point.x+","+point.y);
                coordinatesService.updateCoordinates(coordinates);
                int Steps = (int) count_distance(point, po) / 5;
                if(Steps>datasourcePro.getError()) {
                    Livestock livestock = new Livestock();
                    livestock.setStepNum(Steps);
                    livestock.setBluetoothId(bluetoothId);
                    livestockService.updateLivestockStep(livestock);
                }

                RssiSave rssiSave = new RssiSave();
                rssiSave.setMacA(data[0]);
                rssiSave.setMacB(data[1]);
                rssiSave.setMacC(data[2]);
                rssiSave.setMacAFromBlue(rssi[0]);
                rssiSave.setMacBFromBlue(rssi[1]);
                rssiSave.setMacCFromBlue(rssi[2]);
                rssiSave.setBlueToothId(bluetoothId);
                rssiSave.setPoint(point);
                rssiSave.setTimestamp(new Timestamp(System.currentTimeMillis()));
                mongoDBService.insertRssiDB(rssiSave);
            }
            catch (Exception e)
            {
                log.error(e.getMessage());
    //            System.out.println("计算出错"+e.getMessage());
            }
        }
    }
    public double GetSide(Point[] p)
    {
        double x = 0, y = 0;
        double x1 = 0, y1 = 0;
        for (Point point : p)
        {
            if (x < point.x)
                x = point.y;
            else if (point.x < x1)
                x1 = point.x;
            if (y < point.y)
                y = point.y;
            else if (point.y < y1)
                y1 = point.y;
        }
        Side = x + y + Math.abs(y1 + x1);
        return Side;
    }
    private int[] LongDouble(int[] s)
    {
        int n = 0,m=0;
        for (int i = 0; i < s.length; i++) {
            n += s[i];
            if(s[i]<100)
                m+=100;
        }
        if (n < Side)
            for (int i = 0; i < s.length; i++)
            {
                if(s[i]<100)
                    s[i] -= 100;
                s[i] = (int)(s[i] * ((Side - m) / n));
                if(s[i]<100)
                    s[i] += 100;
            }
        return s;

    }



    /**
     * 计算标签位置
     *
     * @param dis 标签离网关距离
     * @param gateway_coordinate  网关位置
     * @return
     */
    private Point threePoints(int[] dis, Point[] gateway_coordinate) {
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
    private  double count_distance(Point a, Point b) {
        double m = Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
        return m;
    }

}
