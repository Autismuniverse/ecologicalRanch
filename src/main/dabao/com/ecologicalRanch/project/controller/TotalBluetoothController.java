package com.ecologicalRanch.project.controller;


import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.TotalBluetooth;
import com.ecologicalRanch.project.service.TotalBluetoothService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-06-26 19:40:07'
 */
@Api(tags = "查询入库设备mac地址")
@Controller
@RequestMapping("/app/totalBluetooth")
public class TotalBluetoothController {

    @Autowired
    private TotalBluetoothService totalBluetoothService;

    /**
     * 查询Bluetooth列表
     */
    @ApiOperation(" 查询Bluetooth列表")
    @PostMapping("/selectTotalBluetoothList")
    @ResponseBody
    public CommonResult selectBluetoothList(TotalBluetooth totalBluetooth,
                                            @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                            @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize){
        return CommonResult.success(CommonPage.restPage(totalBluetoothService.selectTotalBluetoothList(totalBluetooth,pageNum,pageSize)));
    }

    /**
     * 查询Bluetooth列表无分页
     */
    @ApiOperation(" 查询Bluetooth列表无分页")
    @PostMapping("/selectTotalBluetoothListNoPageHelper")
    @ResponseBody
    public CommonResult selectBluetoothList(TotalBluetooth totalBluetooth){
        return CommonResult.success(totalBluetoothService.selectTotalBluetoothListNoPageHelper(totalBluetooth));
    }

    /**
     * 通过Id查询Bluetooth
     */
    @ApiOperation("通过Id查询Bluetooth")
    @GetMapping("/selectBluetoothById/{totalBluetoothId}")
    @ResponseBody
    public CommonResult selectBluetoothById(@PathVariable String totalBluetoothId){
        return CommonResult.success(totalBluetoothService.selectTotalBluetoothById(totalBluetoothId));
    }

    /**
     * 新增Bluetooth
     */
    @ApiOperation("新增Bluetooth")
    @PostMapping("/insertBluetooth")
    @ResponseBody
    public CommonResult insertBluetooth(@RequestBody TotalBluetooth totalBluetooth){
        return CommonResult.success(totalBluetoothService.insertTotalBluetooth(totalBluetooth));
    }

    /**
     * 修改Bluetooth信息
     */
    @ApiOperation("修改Bluetooth信息")
    @PostMapping("/updateBluetooth")
    @ResponseBody
    public CommonResult updateBluetooth(@RequestBody TotalBluetooth totalbluetooth){
        return CommonResult.success(totalBluetoothService.updateTotalBluetooth(totalbluetooth));
    }

    /**
     * 通过id删除Bluetooth
     */
    @ApiOperation("通过id删除Bluetooth")
    @PostMapping("/deleteBluetoothById/{bluetoothId}")
    @ResponseBody
    public CommonResult deleteBluetoothById(@PathVariable("bluetoothId") String bluetoothId){
        return CommonResult.success(totalBluetoothService.deleteTotalBluetoothById(bluetoothId));
    }

    /**
     * 通过id批量删除Bluetooth
     */
    @ApiOperation("通过id批量删除Bluetooth")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteBluetoothByIds(@RequestBody String bluetoothIds){
        return CommonResult.success(totalBluetoothService.deleteTotalBluetoothByIds(bluetoothIds));
    }
}

