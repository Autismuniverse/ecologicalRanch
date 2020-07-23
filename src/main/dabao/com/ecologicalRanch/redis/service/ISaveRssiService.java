package com.ecologicalRanch.redis.service;

import com.ecologicalRanch.redis.entity.BluetoothRssiInfo;

import java.util.HashMap;
import java.util.List;

public interface ISaveRssiService {

    void saveRssi(String livestockId, String gatewayMac, String rssi);

    List<BluetoothRssiInfo> getRssiList();

    HashMap<String,String> getRssiWithHashMap(String livestockId);

    void delByBluetoothId(String bluetoothId);

    String flushAll();
}
