package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.RssiSave;
import com.ecologicalRanch.project.entity.User;
import com.ecologicalRanch.project.service.MongoDBService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Slf4j
@Api(tags = "MongoDB")
@Controller
@RequestMapping("/app/MongoDB")
public class MongoDBController {
    @Autowired
    MongoDBService mongoDBService;

    @ApiOperation("添加一个user")
    @PostMapping("/test")
    @ResponseBody
    public CommonResult MongoDB(@RequestBody User user){
        try{
            return CommonResult.success(mongoDBService.insert(user));
        }catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }

    @ApiOperation("添加一个rssi")
    @PostMapping("/rssi")
    @ResponseBody
    public CommonResult MongoDB(@RequestBody RssiSave rssiSave){
        try{
            return CommonResult.success(mongoDBService.insertRssiDB(rssiSave));
        }catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }
}
