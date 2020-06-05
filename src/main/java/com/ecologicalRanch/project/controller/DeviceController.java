package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.Device;
import com.ecologicalRanch.project.service.DeviceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-31 18:15:45'
 */
@RestController
@RequestMapping("/app/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    /**
     * 查询Device列表
     */
    @ApiOperation(" 查询Device列表")
    @PostMapping("/selectDeviceList")
    @ResponseBody
    public CommonResult selectDeviceList(@RequestBody Device device,
                                         @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                         @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize){
        return CommonResult.success(CommonPage.restPage(deviceService.selectDeviceList(device,pageNum,pageSize)));
    }

    /**
     * 查询Device列表
     */
    @ApiOperation(" 查询Device列表")
    @PostMapping("/selectDeviceListNoPageHelper")
    @ResponseBody
    public CommonResult selectDeviceListNoPageHelper(@RequestBody Device device){
        return CommonResult.success(deviceService.selectDeviceListNoPageHelper(device));
    }

    /**
     * 通过Id查询Device
     */
    @ApiOperation("通过Id查询Device")
    @PostMapping("/selectDeviceById")
    @ResponseBody
    public CommonResult selectDeviceById(@RequestBody Long deviceId){
        return CommonResult.success(deviceService.selectDeviceById(deviceId));
    }

    /**
     * 新增Device
     */
    @ApiOperation("新增Device")
    @PostMapping("/insertDevice")
    @ResponseBody
    public CommonResult insertDevice(@RequestBody Device device){
        return CommonResult.success(deviceService.insertDevice(device));
    }

    /**
     * 修改Device信息
     */
    @ApiOperation("修改Device信息")
    @PostMapping("/updateDevice")
    @ResponseBody
    public CommonResult updateDevice(@RequestBody Device device){
        return CommonResult.success(deviceService.updateDevice(device));
    }

    /**
     * 通过id删除Device
     */
    @ApiOperation("通过id删除Device")
    @PostMapping("/deleteDeviceById")
    @ResponseBody
    public CommonResult deleteDeviceById(Long deviceId){
        return CommonResult.success(deviceService.deleteDeviceById(deviceId));
    }

    /**
     * 通过id批量删除Device
     */
    @ApiOperation("通过id批量删除Device")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteDeviceByIds(@RequestBody String deviceIds){
        return CommonResult.success(deviceService.deleteDeviceByIds(deviceIds));
    }
}
