package com.ecologicalRanch.redis.entity;

import java.io.Serializable;

public class RedisRssiKey implements Serializable {
    //蓝牙Id
    private String BluetoothId;

    //网关位置
    private String gatewayPoint;

    public RedisRssiKey(String BluetoothId, String gatewayPoint) {
        this.BluetoothId = BluetoothId;
        this.gatewayPoint = gatewayPoint;
    }

    public RedisRssiKey(String key) {
        String[] s = key.split(",");
        this.BluetoothId = s[0];
        this.gatewayPoint = s[1] +","+ s[2];
    }

    public String getBluetoothId() {
        return BluetoothId;
    }

    public void setBluetoothId(String BluetoothId) {
        this.BluetoothId = BluetoothId;
    }

    public String getGatewayPoint() {
        return gatewayPoint;
    }

    public void setGatewayPoint(String gatewayPoint) {
        this.gatewayPoint = gatewayPoint;
    }

    public String creatKey(){
        return BluetoothId + "," + gatewayPoint;
    }

    @Override
    public String toString() {
        return "RedisRssiKey{" +
                "BluetoothId='" + BluetoothId + '\'' +
                ", gatewayPoint='" + gatewayPoint + '\'' +
                '}';
    }
}
