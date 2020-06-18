package com.ecologicalRanch.redis.entity;

import java.awt.*;
import java.io.Serializable;
import java.util.HashMap;

public class BluetoothRssiInfo implements Serializable {

    //牲畜id
    private String BluetoothId;

    //上次位置信息
    private Point lastPoint;

    //网关信息
    private HashMap<String,String> gatewayInfo;

    public BluetoothRssiInfo() {
        gatewayInfo = new HashMap<>();
    }

    public BluetoothRssiInfo(String BluetoothId, Point lastPoint, HashMap<String,String> gatewayInfo ) {
        this.BluetoothId = BluetoothId;
        this.lastPoint = lastPoint;
        this.gatewayInfo = gatewayInfo;
    }

    public Point getLastPoint() {
        return lastPoint;
    }

    public void setLastPoint(Point lastPoint) {
        this.lastPoint = lastPoint;
    }

    public HashMap<String, String> getGatewayInfo() {
        return gatewayInfo;
    }

    public void setGatewayInfo(HashMap<String, String> gatewayInfo) {
        this.gatewayInfo = gatewayInfo;
    }

    public void addGatewayInfo(String gateway, String rssi) {
        gatewayInfo.put(gateway,rssi);
    }

    public String getBluetoothId() {
        return BluetoothId;
    }

    public void setBluetoothId(String BluetoothId) {
        this.BluetoothId = BluetoothId;
    }
}
