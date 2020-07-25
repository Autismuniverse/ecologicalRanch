package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.Coordinates;
import com.ecologicalRanch.project.service.CoordinatesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-28 14:32:02'
 */
@Api(tags = "蓝牙位置数据")
@Controller
@RequestMapping("/app/coordinates")
@Validated
public class CoordinatesController {

    @Autowired
    private CoordinatesService coordinatesService;

    /**
     * 查询Coordinates列表
     */
    @ApiOperation(" 查询Coordinates列表")
    @PostMapping("/selectCoordinatesList")
    @ResponseBody
    public CommonResult selectCoordinatesList(@RequestBody Coordinates coordinates,
                                              @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                              @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize){
        return CommonResult.success(CommonPage.restPage(coordinatesService.selectCoordinatesList(coordinates,pageNum,pageSize)));
    }

    /**
     * 查询Coordinates列表无分页
     */
    @ApiOperation(" 查询Coordinates列表无分页")
    @PostMapping("/selectCoordinatesListNoPageHelper")
    @ResponseBody
    public CommonResult selectCoordinatesListNoPageHelper(@RequestBody Coordinates coordinates){
        return CommonResult.success(coordinatesService.selectCoordinatesListNoPageHelper(coordinates));
    }

    /**
     * 通过Id查询Coordinates
     */
    @ApiOperation("通过Id查询Coordinates")
    @PostMapping("/selectCoordinatesById")
    @ResponseBody
    public CommonResult selectCoordinatesById(@RequestBody Coordinates coordinates){
        return CommonResult.success(coordinatesService.selectCoordinatesById(coordinates.getBluetoothId()));
    }

    /**
     * 通过Id查询Coordinates
     */
    @ApiOperation("通过Mac查询Coordinates")
    @PostMapping("/selectCoordinatesByMac")
    @ResponseBody
    public CommonResult selectCoordinatesByMac(@RequestBody @Validated Coordinates coordinates){
        return CommonResult.success(coordinatesService.selectCoordinatesByMac(coordinates.getBluetoothMac()));
    }

    /**
     * 新增Coordinates
     */
    @ApiOperation("新增Coordinates")
    @PostMapping("/insertCoordinates")
    @ResponseBody
    public CommonResult insertCoordinates(@RequestBody @Validated Coordinates coordinates){
        return CommonResult.success(coordinatesService.insertCoordinates(coordinates));
    }

    /**
     * 修改Coordinates信息
     */
    @ApiOperation("修改Coordinates信息")
    @PostMapping("/updateCoordinates")
    @ResponseBody
    public CommonResult updateCoordinates(@RequestBody @Validated Coordinates coordinates){
        return CommonResult.success(coordinatesService.updateCoordinates(coordinates));
    }

    /**
     * 通过id删除Coordinates
     */
    @ApiOperation("通过id删除Coordinates")
    @PostMapping("/deleteCoordinatesById/{bluetoothId}")
    @ResponseBody
    public CommonResult deleteCoordinatesById(@PathVariable("bluetoothId") String bluetoothId){
        return CommonResult.success(coordinatesService.deleteCoordinatesById(bluetoothId));
    }

    /**
     * 通过id批量删除Coordinates
     */
    @ApiOperation("通过id批量删除Coordinates")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteCoordinatesByIds(String bluetoothIds){
        return CommonResult.success(coordinatesService.deleteCoordinatesByIds(bluetoothIds));
    }
}
