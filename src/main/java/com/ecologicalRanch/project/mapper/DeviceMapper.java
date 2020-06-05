package com.ecologicalRanch.project.mapper;

import com.ecologicalRanch.project.entity.Device;

import java.util.List;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-31 18:15:45'
 */
public interface DeviceMapper {

    /**
     * 查询Device列表
     * @param device 查询对象
     * @return 查询列表
     */
    List<Device> selectDeviceList(Device device);

    /**
     * 通过Id查询 Device
     * @param deviceId 查询Id
     * @return 查询对象
     */
    Device selectDeviceById(Long deviceId);

    /**
     * 新增Device
     * @param device 新增对象
     * @return 插入行数
     */
    int insertDevice(Device device);

    /**
     * 修改Device信息
     * @param  device 用户对象
     * @return 更新行数
     */
    int updateDevice(Device device);

    /**
     * 通过id删除Device
     * @param deviceId 删除id
     * @return 删除行数
     */
    int deleteDeviceById(Long deviceId);

    /**
     * 通过id批量删除Device
     * @param deviceIds 删除ids
     * @return 删除行数
     */
    int deleteDeviceByIds(String[] deviceIds);

}
