package com.ecologicalRanch.redis.controller;

import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.redis.service.ISaveRssiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("RSSI信息")
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    ISaveRssiService saveRssiService;

    /**
     * 储存RSSI值
     * @param bluetoothMac 蓝牙MAC
     * @param gatewayMac 网关MAC
     * @param rssi  RSSI值
     * @return String
     */
    @PostMapping("/saveRSSI")
    @ApiOperation(value = "储存RSSI值",notes = "bluetoothMac,gatewayMac,RSSI")
    public CommonResult saveRSSI (String bluetoothMac,String gatewayMac, String rssi) {
        System.out.println(bluetoothMac + "网关：" + gatewayMac + "RSSI" + rssi);
        try {
            saveRssiService.saveRssi(bluetoothMac, gatewayMac, rssi);
            return CommonResult.success("OK");
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.failed();
        }
    }

    /**
     * 获取所有蓝牙标签的RSSI值
     * @return List
     */
    @PostMapping("/getRssi")
    @ApiOperation("获取RSSI值")
    public CommonResult getRssi () {
        return CommonResult.success(saveRssiService.getRssiList());
    }

    /**
     * 清空REDIS数据库
     * @return
     */
    @PostMapping("/delByBluetoothId")
    @ApiOperation("通过蓝牙id删除数据")
    public CommonResult delByBluetoothId (@RequestParam String bluetoothId) {
        saveRssiService.delByBluetoothId(bluetoothId);
        return CommonResult.success("删除成功");
    }

    /**
     * 清空REDIS数据库
     * @return
     */
    @GetMapping("/flushAll")
    @ApiOperation("清空REDIS数据库")
    public CommonResult flushAll () {
        return CommonResult.success(saveRssiService.flushAll());
    }
}