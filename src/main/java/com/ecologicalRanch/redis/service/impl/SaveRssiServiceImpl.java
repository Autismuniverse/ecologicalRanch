package com.ecologicalRanch.redis.service.impl;

import com.ecologicalRanch.config.ApplicationContextProvider;
import com.ecologicalRanch.project.entity.Coordinates;
import com.ecologicalRanch.project.entity.Gateway;
import com.ecologicalRanch.project.service.CoordinatesService;
import com.ecologicalRanch.project.service.GatewayService;
import com.ecologicalRanch.redis.entity.BluetoothRssiInfo;
import com.ecologicalRanch.redis.entity.RedisRssiKey;
import com.ecologicalRanch.redis.service.ISaveRssiService;
import com.ecologicalRanch.redis.utils.PointUtil;
import com.ecologicalRanch.redis.utils.RedisUtil;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class SaveRssiServiceImpl implements ISaveRssiService {

    private GatewayService gatewayService;

    private CoordinatesService coordinatesService;

    private RedisUtil redisUtil;

    public SaveRssiServiceImpl() {
        this.gatewayService = ApplicationContextProvider.getBean(GatewayService.class);
        this.coordinatesService = ApplicationContextProvider.getBean(CoordinatesService.class);
        this.redisUtil = ApplicationContextProvider.getBean(RedisUtil.class);
    }

    /**
     * 存储 牲畜的 rssi
     *
     * @param bluetoothMac 蓝牙Mac
     * @param gatewayMac   网关Mac
     * @param rssi         RSSI值
     */
    @Override
    public void saveRssi(String bluetoothMac, String gatewayMac, String rssi) {

        Gateway gateway = new Gateway();
        gateway.setMac(gatewayMac);
        String g = gatewayService.selectGatewayByMac(gateway);
        Coordinates coordinates = coordinatesService.selectCoordinatesByMac(bluetoothMac);

        if (!g.equals("") && coordinates != null) {
            Point gatewayPoint = PointUtil.stringToPoint(g);
            RedisRssiKey redisRssiKey = new RedisRssiKey(coordinates.getBluetoothId(), PointUtil.toString(gatewayPoint));

            if (redisUtil.get(redisRssiKey.creatKey(), 0) == null) {
                redisUtil.set(redisRssiKey.creatKey(), rssi + ",", 0);
            }
            else {
//                System.out.println("网关：" + g + "Key" + redisRssiKey.creatKey());
                redisUtil.append(redisRssiKey.creatKey(), rssi + ",");
            }
        }
    }

    /**
     * 通过 牲畜标签 获取 Rssi 值
     *
     * @param bluetoothId 牲畜id
     * @return HashMap
     */
    @Override
    public HashMap<String, String> getRssiWithHashMap(String bluetoothId) {
        HashMap<String, String> gatewayInfo = new HashMap<>();
        RedisRssiKey rssiKey;
        for (String s : redisUtil.keys(bluetoothId + "*")) {
            rssiKey = new RedisRssiKey(s);
            if (!gatewayInfo.containsKey(rssiKey.getGatewayPoint())) {
                String r = redisUtil.get(s, 0);
                if (r.split(",").length > 80)
                    gatewayInfo.put(rssiKey.getGatewayPoint(), r);
            }
        }
        if (gatewayInfo.size() <= 2)
            return null;
        if (gatewayInfo.size() > 3)
        {

        }
        return gatewayInfo;
    }

    /**
     * 获取redis中数据量大于 80 所有的蓝牙信息
     *
     * @return List
     */
    @Override
    public List<BluetoothRssiInfo> getRssiList() {

        List<BluetoothRssiInfo> list = new ArrayList<>();
        List<Coordinates> coordinatesList = coordinatesService.selectCoordinatesListNoPageHelper(new Coordinates());
        HashMap<String, String> gatewayInfo;

        for (Coordinates coordinates : coordinatesList) {
            gatewayInfo = getRssiWithHashMap(coordinates.getBluetoothId());
            if (gatewayInfo != null) {
                BluetoothRssiInfo bluetoothRssiInfo = new BluetoothRssiInfo();
                bluetoothRssiInfo.setBluetoothId(coordinates.getBluetoothId());
                bluetoothRssiInfo.setLastPoint(new Point(coordinates.getCoordinateX(), coordinates.getCoordinateY()));
                bluetoothRssiInfo.setGatewayInfo(gatewayInfo);

                list.add(bluetoothRssiInfo);
            }
        }

        return list;
    }

    /**
     * 通过蓝牙id 删除 数据
     *
     * @param bluetoothId
     */
    @Override
    public void delByBluetoothId(String bluetoothId) {
        for (String s : redisUtil.keys(bluetoothId +"*")) {
            redisUtil.del(s);
        }
    }

    /**
     * 清空数据库
     *
     * @return 状态码
     */
    @Override
    public String flushAll() {
        return redisUtil.flushDB();
    }


    @Override
    public String getByKey(String key, int indexDB) {
        return redisUtil.get(key, indexDB);
    }
}
