package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.common.utils.text.Convert;
import com.ecologicalRanch.project.entity.Device;
import com.ecologicalRanch.project.mapper.DeviceMapper;
import com.ecologicalRanch.project.service.DeviceService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-26 16:01:07'
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    /**
     * 通过Id查询 Device
     */
    @Override
    public Device selectDeviceById(Device device) {
        return deviceMapper.selectDeviceById(device);
    }

    /**
     * 查询Device列表
     */

    @Override
    public List<Device> selectDeviceList(Device device,int pageNum,int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->deviceMapper.selectDeviceList(device));
    }

    /**
     * 查询Device列表无分页
     */

    @Override
    public List<Device> selectDeviceListNoPageHelper(Device device){
        return  deviceMapper.selectDeviceList(device);
    }

    /**
     * 新增Device
     */
    @Override
    public int insertDevice(Device device) {
        return deviceMapper.insertDevice(device);
    }

    /**
     * 通过id删除Device
     */
    @Override
    public int deleteDeviceById(Long bluetoothId) {
        return deviceMapper.deleteDeviceById(bluetoothId);
    }

    /**
     * 通过id批量删除Device
     */
    @Override
    public int deleteDeviceByIds(String bluetoothIds){
        return deviceMapper.deleteDeviceByIds(Convert.toStrArray(bluetoothIds));
    }

    /**
     * 修改Device信息
     */
    @Override
    public int updateDevice(Device device) {
        return deviceMapper.updateDevice(device);
    }

}

