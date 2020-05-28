package com.ecologicalRanch.project.service;

import com.ecologicalRanch.project.entity.Device;

import java.util.List;


/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-26 16:01:07'
 */
public interface DeviceService {

    /**
     * 查询Device列表
     */
    List<Device> selectDeviceList(Device device, int pageNum, int pageSize);

    /**
     * 查询Device列表无分页
     */
    List<Device> selectDeviceListNoPageHelper(Device device);

    /**
     * 通过Id查询 Device
     */
    Device selectDeviceById(Device device);

    /**
     * 新增Device
     */
    int insertDevice(Device device);

    /**
     * 通过id删除Device
     */
    int deleteDeviceById(Long bluetoothId);

    /**
     * 通过id批量删除Device
     */
    int deleteDeviceByIds(String bluetoothIds);

    /**
     * 修改Device信息
     */
    int updateDevice(Device device);

}
