package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.Surroundings;
import com.ecologicalRanch.project.service.SurroundingsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author xxxFredYang
 * @date '2020-07-29 15:43:26'
 */
@Api(tags = "养殖场环境图片")
@Controller
@RequestMapping("/app/surroundings")
@Slf4j
public class SurroundingsController {

    @Autowired
    private SurroundingsService surroundingsService;

    /**
     * 查询Surroundings列表
     */

    @ApiOperation(" 查询Surroundings列表")
    @PostMapping("/selectSurroundingsList")
    @ResponseBody
    public CommonResult selectSurroundingsList(Surroundings surroundings,
                                               @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                               @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize){
        return CommonResult.success(CommonPage.restPage(surroundingsService.selectSurroundingsList(surroundings,pageNum,pageSize)));
    }

    /**
     * 通过Id查询Surroundings
     */
    @ApiOperation("通过Id查询Surroundings")
    @GetMapping("/selectSurroundingsByFieldId/{fieldId}")
    @ResponseBody
    public CommonResult selectSurroundingsById(@PathVariable("fieldId") Integer fieldId){
        return CommonResult.success(surroundingsService.selectSurroundingsByFieldId(fieldId));
    }

    /**
     * 新增Surroundings
     */
    @ApiOperation("新增Surroundings")
    @PostMapping("/insertSurroundings")
    @ResponseBody
    public CommonResult insertSurroundings(Surroundings surroundings){
        return CommonResult.success(surroundingsService.insertSurroundings(surroundings));
    }

    /**
     * 修改Surroundings信息
     */
    @ApiOperation("修改Surroundings信息")
    @PostMapping("/updateSurroundings")
    @ResponseBody
    public CommonResult updateSurroundings(Surroundings surroundings){
        return CommonResult.success(surroundingsService.updateSurroundings(surroundings));
    }

    /**
     * 通过id删除Surroundings
     */
    @ApiOperation("通过id删除Surroundings")
    @PostMapping("/deleteSurroundingsById/{surroundingsId}")
    @ResponseBody
    public CommonResult deleteSurroundingsById(@PathVariable("surroundingsId") Long surroundingsId){
        return CommonResult.success(surroundingsService.deleteSurroundingsById(surroundingsId));
    }

    /**
     * 通过id批量删除Surroundings
     */
    @ApiOperation("通过id批量删除Surroundings")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteSurroundingsByIds(String surroundingsIds){
        return CommonResult.success(surroundingsService.deleteSurroundingsByIds(surroundingsIds));
    }
}
