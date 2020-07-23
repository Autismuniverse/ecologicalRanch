package com.ecologicalRanch.project.service;

import com.ecologicalRanch.project.entity.TotalBluetooth;

import java.util.List;

public interface TotalBluetoothService {
    /**
     * 查询TotalBluetooth列表
     */
    List<TotalBluetooth> selectTotalBluetoothList(TotalBluetooth TotalBluetooth, int pageNum, int pageSize);

    /**
     * 通过Id查询 TotalBluetooth
     */
    TotalBluetooth selectTotalBluetoothById(String TotalBluetoothId);

    /**
     * 新增TotalBluetooth
     */
    int insertTotalBluetooth(TotalBluetooth TotalBluetooth);

    /**
     * 通过id删除TotalBluetooth
     */
    int deleteTotalBluetoothById(String TotalBluetoothId);

    /**
     * 通过id批量删除TotalBluetooth
     */
    int deleteTotalBluetoothByIds(String TotalBluetoothIds);

    /**
     * 修改TotalBluetooth信息
     */
    int updateTotalBluetooth(TotalBluetooth TotalBluetooth);
}
