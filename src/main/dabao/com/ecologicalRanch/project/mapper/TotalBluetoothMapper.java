package com.ecologicalRanch.project.mapper;

import com.ecologicalRanch.project.entity.TotalBluetooth;

import java.util.List;

public interface TotalBluetoothMapper {

    /**
     * 查询TotalBluetooth列表
     * @param TotalBluetooth 查询对象
     * @return 查询列表
     */
    List<TotalBluetooth> selectTotalBluetoothList(TotalBluetooth TotalBluetooth);

    /**
     * 通过Id查询 TotalBluetooth
     * @param TotalBluetoothId 查询Id
     * @return 查询对象
     */
    TotalBluetooth selectTotalBluetoothById(String TotalBluetoothId);

    /**
     * 新增TotalBluetooth
     * @param TotalBluetooth 新增对象
     * @return 插入行数
     */
    int insertTotalBluetooth(TotalBluetooth TotalBluetooth);

    /**
     * 修改TotalBluetooth信息
     * @param  TotalBluetooth 用户对象
     * @return 更新行数
     */
    int updateTotalBluetooth(TotalBluetooth TotalBluetooth);

    /**
     * 通过id删除TotalBluetooth
     * @param TotalBluetoothId 删除id
     * @return 删除行数
     */
    int deleteTotalBluetoothById(String TotalBluetoothId);

    /**
     * 通过id批量删除TotalBluetooth
     * @param TotalBluetoothIds 删除ids
     * @return 删除行数
     */
    int deleteTotalBluetoothByIds(String[] TotalBluetoothIds);

}
