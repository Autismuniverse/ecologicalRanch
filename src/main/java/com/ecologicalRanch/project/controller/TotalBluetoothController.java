package com.ecologicalRanch.project.controller;


import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.TotalBluetooth;
import com.ecologicalRanch.project.service.TotalBluetoothService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
        try{
            return CommonResult.success(CommonPage.restPage(totalBluetoothService.selectTotalBluetoothList(totalBluetooth,pageNum,pageSize)));
        }catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 查询Bluetooth列表无分页
     */
    @ApiOperation(" 查询Bluetooth列表无分页")
    @PostMapping("/selectTotalBluetoothListNoPageHelper")
    @ResponseBody
    public CommonResult selectBluetoothList(TotalBluetooth totalBluetooth){
        try{
            return CommonResult.success(totalBluetoothService.selectTotalBluetoothListNoPageHelper(totalBluetooth));
        }catch (Exception e) {
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 通过Id查询Bluetooth
     */
    @ApiOperation("通过Id查询Bluetooth")
    @GetMapping("/selectBluetoothById/{totalBluetoothId}")
    @ResponseBody
    public CommonResult selectBluetoothById(@PathVariable String totalBluetoothId){
        try{
            return CommonResult.success(totalBluetoothService.selectTotalBluetoothById(totalBluetoothId));
        }catch (Exception e) {
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 新增Bluetooth
     */
    @ApiOperation("新增Bluetooth")
    @PostMapping("/insertBluetooth")
    @ResponseBody
    public CommonResult insertBluetooth(@RequestBody TotalBluetooth totalBluetooth){
        try{
            return CommonResult.success(totalBluetoothService.insertTotalBluetooth(totalBluetooth));
        }catch (Exception e) {
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 修改Bluetooth信息
     */
    @ApiOperation("修改Bluetooth信息")
    @PostMapping("/updateBluetooth")
    @ResponseBody
    public CommonResult updateBluetooth(@RequestBody TotalBluetooth totalbluetooth){
        try{
            return CommonResult.success(totalBluetoothService.updateTotalBluetooth(totalbluetooth));
        }catch (Exception e) {
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 通过id删除Bluetooth
     */
    @ApiOperation("通过id删除Bluetooth")
    @PostMapping("/deleteBluetoothById/{bluetoothId}")
    @ResponseBody
    public CommonResult deleteBluetoothById(@PathVariable("bluetoothId") String bluetoothId){
        try{
            return CommonResult.success(totalBluetoothService.deleteTotalBluetoothById(bluetoothId));
        }catch (Exception e) {
            return CommonResult.failed("未知错误");
        }
    }


    /**
     * 通过id批量删除Bluetooth
     */
    @ApiOperation("通过id批量删除Bluetooth")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteBluetoothByIds(@RequestBody String bluetoothIds){
        try{
            return CommonResult.success(totalBluetoothService.deleteTotalBluetoothByIds(bluetoothIds));
        }catch (Exception e) {
            return CommonResult.failed("未知错误");
        }
    }
}

