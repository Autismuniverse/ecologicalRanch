package com.ecologicalRanch.redis.service.impl;

import com.ecologicalRanch.config.ApplicationContextProvider;
import com.ecologicalRanch.project.entity.Coordinates;
import com.ecologicalRanch.project.entity.Gateway;
import com.ecologicalRanch.project.service.CoordinatesService;
import com.ecologicalRanch.project.service.GatewayService;
import com.ecologicalRanch.redis.entity.BluetoothRssiInfo;
import com.ecologicalRanch.redis.entity.RedisRssiKey;
import com.ecologicalRanch.redis.service.ISaveRssiService;
import com.ecologicalRanch.redis.utils.JedisUtil;
import com.ecologicalRanch.redis.utils.PointUtil;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



@Service
public class SaveRssiServiceImpl implements ISaveRssiService {

    private GatewayService gatewayService;

    private CoordinatesService coordinatesService;

    private JedisUtil jedisUtil = new JedisUtil();

    public SaveRssiServiceImpl(){
        this.gatewayService = ApplicationContextProvider.getBean(GatewayService.class);
        this.coordinatesService = ApplicationContextProvider.getBean(CoordinatesService.class);
    }

    /**
     * 存储 牲畜的 rssi
     * @param bluetoothMac 蓝牙Mac
     * @param gatewayMac 网关Mac
     * @param rssi RSSI值
     */
    @Override
    public void saveRssi(String bluetoothMac,String gatewayMac, String rssi){

        Gateway gateway = new Gateway();
        gateway.setMac(gatewayMac);
        String g = gatewayService.selectGatewayByMac(gateway);
        Coordinates coordinates = coordinatesService.selectCoordinatesByMac(bluetoothMac);

//        if(!g.equals("") && coordinates != null) {
            Point gatewayPoint = PointUtil.stringToPoint(g);
            RedisRssiKey redisRssiKey = new RedisRssiKey(coordinates.getBluetoothId().toString(), PointUtil.toString(gatewayPoint));

//            System.out.println(redisRssiKey.toString());
            jedisUtil.append(redisRssiKey.creatKey(), rssi + ",");
//        }
    }

    /**
     * 通过 牲畜标签 获取 Rssi 值
     * @param bluetoothId 牲畜id
     * @return HashMap
     */
    @Override
    public HashMap<String,String> getRssiWithHashMap(String bluetoothId){
        HashMap<String,String> gatewayInfo = new HashMap<>();
        RedisRssiKey rssiKey;
        for(String s : jedisUtil.Keys(bluetoothId)) {
             rssiKey = new RedisRssiKey(s);
             if(!gatewayInfo.containsKey(rssiKey.getGatewayPoint())) {
                 String r = jedisUtil.get(s);
                 if (r.split(",").length > 50)
                     gatewayInfo.put(rssiKey.getGatewayPoint(), r);
             }
             if (gatewayInfo.size() > 2)
                 break;
        }
        if (gatewayInfo.size() <= 2)
            return null;
        return gatewayInfo;
    }

    /**
     * 获取redis中数据量大于 80 所有的蓝牙信息
     * @return List
     */
    @Override
    public List<BluetoothRssiInfo> getRssiList(){

        List<BluetoothRssiInfo> list = new ArrayList<>();
        List<Coordinates> coordinatesList = coordinatesService.selectCoordinatesListNoPageHelper(new Coordinates());
        HashMap<String,String> gatewayInfo;

        for(Coordinates coordinates : coordinatesList){
            gatewayInfo = getRssiWithHashMap(coordinates.getBluetoothId().toString());
            if(gatewayInfo != null){
                BluetoothRssiInfo bluetoothRssiInfo = new BluetoothRssiInfo();
                bluetoothRssiInfo.setBluetoothId(coordinates.getBluetoothId().toString());
                bluetoothRssiInfo.setLastPoint(new Point(coordinates.getCoordinateX() , coordinates.getCoordinateY()));
                bluetoothRssiInfo.setGatewayInfo(gatewayInfo);

                list.add(bluetoothRssiInfo);
            }
        }

        return list;
    }

    /**
     * 通过蓝牙id 删除 数据
     * @param bluetoothId
     */
    @Override
    public void delByBluetoothId(String bluetoothId){
        for(String s : jedisUtil.Keys(bluetoothId)) {
            jedisUtil.del(s);
        }
    }

    /**
     * 清空数据库
     * @return 状态码
     */
    @Override
    public String flushAll(){
        return jedisUtil.flushAll();
    }
}
