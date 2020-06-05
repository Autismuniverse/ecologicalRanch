package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.Livestock;
import com.ecologicalRanch.project.service.LivestockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-31 15:23:10'
 */
@Api(tags = "牲畜")
@Controller
@RequestMapping("/app/livestock")
public class LivestockController {

    @Autowired
    private LivestockService livestockService;

    /**
     * 查询Livestock列表
     */
    @ApiOperation(" 查询Livestock列表")
    @PostMapping("/selectLivestockList")
    @ResponseBody
    public CommonResult selectLivestockList(@RequestBody Livestock livestock,
                                            @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                            @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize){
        return CommonResult.success(CommonPage.restPage(livestockService.selectLivestockList(livestock,pageNum,pageSize)));
    }

    /**
     * 通过Id查询Livestock
     */
    @ApiOperation("通过Id查询Livestock")

    @GetMapping("/selectLivestockById/{livestockId}")
    @ResponseBody
    public CommonResult selectLivestockById(@PathVariable("livestockId") Long livestockId){
        return CommonResult.success(livestockService.selectLivestockById(livestockId));
    }


    /**
     * 查询Livestock列表
     */
    @ApiOperation(" 查询Livestock列表无分页")
    @PostMapping("/selectLivestockListNoPageHelper")
    @ResponseBody
    public CommonResult selectLivestockList(@RequestBody Livestock livestock){
        return CommonResult.success(livestockService.selectLivestockListNoPageHelper(livestock));
    }

    /**
     * 新增Livestock
     */
    @ApiOperation("新增Livestock")
    @PostMapping("/insertLivestock")
    @ResponseBody
    public CommonResult insertLivestock(@RequestBody Livestock livestock){
        return CommonResult.success(livestockService.insertLivestock(livestock));
    }

    /**
     * 修改Livestock信息
     */
    @ApiOperation("修改Livestock信息")
    @PostMapping("/updateLivestock")
    @ResponseBody
    public CommonResult updateLivestock(@RequestBody Livestock livestock){
        return CommonResult.success(livestockService.updateLivestock(livestock));
    }

    /**
     * 通过id删除Livestock
     */
    @ApiOperation("通过id删除Livestock")
    @PostMapping("/deleteLivestockById/{livestockId}")
    @ResponseBody
    public CommonResult deleteLivestockById(@PathVariable("livestockId") Long livestockId){
        return CommonResult.success(livestockService.deleteLivestockById(livestockId));
    }

    /**
     * 通过id批量删除Livestock
     */
    @ApiOperation("通过id批量删除Livestock")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteLivestockByIds(String livestockIds){
        return CommonResult.success(livestockService.deleteLivestockByIds(livestockIds));
    }

    /**
     * 模糊查询Livestock列表
     */
    @ApiOperation(" 模糊查询Livestock列表")
    @PostMapping("/fuzzyLivestockList")
    @ResponseBody
    public CommonResult fuzzyLivestockList(@RequestBody Livestock livestock,
                                           @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                           @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize){

        return CommonResult.success(CommonPage.restPage(livestockService.fuzzyLivestockList(livestock,pageNum,pageSize)));

    }

    /**
     * 查询Livestock列表
     */
//    @ApiOperation(" 查询Livestock以及步数列表")
//    @PostMapping("/selectStep")
//    @ResponseBody
//    public CommonResult selectStep(@RequestBody Livestock livestock,
//                                            @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
//                                            @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize){
//        return CommonResult.success(CommonPage.restPage(livestockService.selectStep(livestock,pageNum,pageSize)));
//    }

    /**
     * 查询Livestock列表
     */
    @ApiOperation(" 查询Livestockc出售时间去重")
    @PostMapping("/selectOutTime")
    @ResponseBody
    public CommonResult selectPrice(@RequestBody Livestock livestock){
        return CommonResult.success(livestockService.selectOutTime(livestock));
    }
}
