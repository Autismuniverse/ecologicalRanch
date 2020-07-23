package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.project.entity.Localtioninfo;
import com.ecologicalRanch.project.result.CommonResult;
import com.ecologicalRanch.project.service.LocaltioninfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-20 14:21:52'
 */
@Api(tags = "位置信息")
@Controller
@RequestMapping("/app/localtioninfo")
public class LocaltioninfoController {

    @Autowired
    private LocaltioninfoService localtioninfoService;

    /**
     * 查询Localtioninfo列表
     */
    @ApiOperation(" 查询Localtioninfo列表")

    @PostMapping("/selectLocaltioninfoList")
    @ResponseBody
    public CommonResult selectLocaltioninfoList(Localtioninfo localtioninfo,
                                                @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                                @RequestParam(value = "pageNum",defaultValue = "10",required = false)int pageSize){
        return CommonResult.success(CommonPage.restPage(localtioninfoService.selectLocaltioninfoList(localtioninfo,pageNum,pageSize)));
    }

    /**
     * 通过Id查询Localtioninfo
     */
    @ApiOperation("通过Id查询Localtioninfo")
    @GetMapping("/selectLocaltioninfoById/{bluetoothId}")
    @ResponseBody
    public CommonResult selectLocaltioninfoById(@PathVariable("bluetoothId") Long bluetoothId){
        return CommonResult.success(localtioninfoService.selectLocaltioninfoById(bluetoothId));
    }

    /**
     * 新增Localtioninfo
     */
    @ApiOperation("新增Localtioninfo")
    @PostMapping("/insertLocaltioninfo")
    @ResponseBody
    public CommonResult insertLocaltioninfo(Localtioninfo localtioninfo){
        return CommonResult.success(localtioninfoService.insertLocaltioninfo(localtioninfo));
    }

    /**
     * 修改Localtioninfo信息
     */
    @ApiOperation("修改Localtioninfo信息")
    @PostMapping("/updateLocaltioninfo")
    @ResponseBody
    public CommonResult updateLocaltioninfo(Localtioninfo localtioninfo){
        return CommonResult.success(localtioninfoService.updateLocaltioninfo(localtioninfo));
    }

    /**
     * 通过id删除Localtioninfo
     */
    @ApiOperation("通过id删除Localtioninfo")
    @PostMapping("/deleteLocaltioninfoById/{bluetoothId}")
    @ResponseBody
    public CommonResult deleteLocaltioninfoById(@PathVariable("bluetoothId") Long bluetoothId){
        return CommonResult.success(localtioninfoService.deleteLocaltioninfoById(bluetoothId));
    }

    /**
     * 通过id批量删除Localtioninfo
     */
    @ApiOperation("通过id批量删除Localtioninfo")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteLocaltioninfoByIds(String bluetoothIds){
        return CommonResult.success(localtioninfoService.deleteLocaltioninfoByIds(bluetoothIds));
    }
}