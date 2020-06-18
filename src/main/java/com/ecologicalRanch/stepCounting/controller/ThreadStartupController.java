package com.ecologicalRanch.stepCounting.controller;

import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.stepCounting.ProgramStart;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ScheduledFuture;

//import com.ecologicalRanch.stepCounting.ProgramStart;

@RestController
@Api("线程控制")
@RequestMapping("/thread")
@Slf4j
public class ThreadStartupController {

//    @Autowired
//    private IScheduledFutureService scheduledFutureService;

    private ProgramStart programStart = new ProgramStart();
    private ScheduledFuture future1;
    /**
     * 启动线程
     * @return string
     */
    @GetMapping("/start")
    @ApiOperation("启动线程")
    public CommonResult start () {
        try{
            programStart.start();
//            scheduledFutureService.scheduledStart();
            return CommonResult.success("OK");
        }catch (Exception e) {
            return CommonResult.failed("失败");
        }
    }

    /**
     * 关闭线程
     * @return string
     */
    @GetMapping("/close")
    @ApiOperation("关闭线程")
    public CommonResult close () {
        try{
            programStart.close();
//            scheduledFutureService.scheduledClose(future1);
            return CommonResult.success("OK");
        }catch (Exception e) {
            log.error("出错信息;" + e.getMessage());
            return CommonResult.failed("失败");
        }
    }
}
