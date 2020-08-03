package com.ecologicalRanch.stepCounting.controller;//package com.ecologicalRanch.stepCounting.controller;
//
//import com.ecologicalRanch.common.result.CommonResult;
//import com.ecologicalRanch.stepCounting.service.IScheduledFutureService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.concurrent.ScheduledFuture;
//
//@Slf4j
//@RestController
//@Api(description = "定时任务")
//@RequestMapping("/Scheduled ")
//public class DynamicTaskController {
//
//    @Autowired
//    private IScheduledFutureService scheduledFutureService;
//    private ScheduledFuture future1;
//
//    @GetMapping("/startCron1")
//    @ApiOperation("启动定时器（间隔5）")
//    public CommonResult<String> startCronAt5S() {
//        future1 = scheduledFutureService.scheduledStart();
//        return CommonResult.success("已启动");
//    }
//
//    @GetMapping("/stopCron1")
//    @ApiOperation("关闭定时任务1")
//    public CommonResult<String> stopCron1() {
//        scheduledFutureService.scheduledClose(future1);
//        return CommonResult.success("已关闭");
//    }
//}