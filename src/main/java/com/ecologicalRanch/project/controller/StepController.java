package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.Step;
import com.ecologicalRanch.project.service.StepService;
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
 * @date '2020-05-29 17:18:07'
 */
@Api(tags = "步数")
@Controller
@RequestMapping("/app/step")
@Slf4j
public class StepController {

    @Autowired
    private StepService stepService;

    /**
     * 查询Step列表
     */
    @ApiOperation(" 查询Step列表")
    @PostMapping("/selectStepList")
    @ResponseBody
    public CommonResult selectStepList(Step step,
                                       @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                       @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize){
        return CommonResult.success(CommonPage.restPage(stepService.selectStepList(step,pageNum,pageSize)));
    }

    /**
     * 查询Step列表
     */
    @ApiOperation(" 根据指定时间段查询时间段内的步数")
    @GetMapping ("/bySpecifying")
    @ResponseBody
    public CommonResult bySpecifying(Long livestockId, Long startTime, Long endTime){
        return CommonResult.success(stepService.bySpecifying(livestockId,startTime,endTime));
    }

    /**
     * 查询Step列表
     */
    @ApiOperation("根据指定时间段查询时间段内的所有鸡的平均步数")
    @GetMapping ("/average")
    @ResponseBody
    public CommonResult average(Long startTime, Long endTime){

        return CommonResult.success(stepService.average(startTime,endTime));
    }

    /**
     * 查询Step列表
     */
    @ApiOperation("根据指定时间以及指定格式段查询时间段内的所有鸡的平均步数")
    @GetMapping ("/appoint")
    @ResponseBody
    public CommonResult appoint(Long startTime,Long endTime,int appoint,Integer livestockId){
        return CommonResult.success(stepService.appoint(startTime,endTime,appoint,livestockId));
    }

    /**
     * 通过Id查询Step
     */
    @ApiOperation("通过Id查询Step")
    @PostMapping("/selectStepById")
    @ResponseBody
    public CommonResult selectStepById(@RequestBody Step step){
        return CommonResult.success(stepService.selectStepById(step.getStepNumId()));
    }

    /**
     * 新增Step
     */
    @ApiOperation("新增Step")
    @PostMapping("/insertStep")
    @ResponseBody
    public CommonResult insertStep(@RequestBody Step step){
        return CommonResult.success(stepService.insertStep(step));
    }

    /**
     * 修改Step信息
     */
    @ApiOperation("修改Step信息")
    @PostMapping("/updateStep")
    @ResponseBody
    public CommonResult updateStep(@RequestBody Step step){
        return CommonResult.success(stepService.updateStep(step));
    }

    /**
     * 通过id删除Step
     */
    @ApiOperation("通过id删除Step")
    @PostMapping("/deleteStepById")
    @ResponseBody
    public CommonResult deleteStepById(@RequestBody Long stepNumId){
        return CommonResult.success(stepService.deleteStepById(stepNumId));
    }

    /**
     * 通过id批量删除Step
     */
    @ApiOperation("通过id批量删除Step")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteStepByIds(@RequestBody String stepNumIds){
        return CommonResult.success(stepService.deleteStepByIds(stepNumIds));
    }
}
