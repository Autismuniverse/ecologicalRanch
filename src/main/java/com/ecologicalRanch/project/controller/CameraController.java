package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.Camera;
import com.ecologicalRanch.project.service.CameraService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 *
 *
 * @author xxxFredYang
 * @date '2020-07-20 16:11:14'
 */
@Api(tags = "摄像头")
@Controller
@RequestMapping("/app/camera")
@Validated
public class CameraController {

    @Autowired
    private CameraService cameraService;

    /**
     * 查询Camera列表
     */
    @ApiOperation(" 查询Camera列表")
    @PostMapping("/selectCameraList")
    @ResponseBody
    public CommonResult selectCameraList(Camera camera,
                                         @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                         @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize){
        return CommonResult.success(CommonPage.restPage(cameraService.selectCameraList(camera,pageNum,pageSize)));
    }

    /**
     * 通过Id查询Camera
     */
    @ApiOperation("通过Id查询Camera")
    @GetMapping("/selectCameraById/{cameraId}")
    @ResponseBody

    public CommonResult selectCameraById(@PathVariable("cameraId") Integer cameraId){
        return CommonResult.success(cameraService.selectCameraById(cameraId));
    }

    /**
     * 新增Camera
     */
    @ApiOperation("新增Camera")
    @PostMapping("/insertCamera")
    @ResponseBody
    public CommonResult insertCamera(@RequestBody @Validated Camera camera){
        return CommonResult.success(cameraService.insertCamera(camera));
    }

    /**
     * 修改Camera信息
     */
    @ApiOperation("修改Camera信息")
    @PostMapping("/updateCamera")
    @ResponseBody
    public CommonResult updateCamera(@Validated Camera camera){
        return CommonResult.success(cameraService.updateCamera(camera));
    }

    /**
     * 通过id删除Camera
     */
    @ApiOperation("通过id删除Camera")
    @PostMapping("/deleteCameraById/{cameraId}")
    @ResponseBody
    public CommonResult deleteCameraById(@PathVariable("cameraId") Integer cameraId){
        return CommonResult.success(cameraService.deleteCameraById(cameraId));
    }

    /**
     * 通过id批量删除Camera
     */
    @ApiOperation("通过id批量删除Camera")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteCameraByIds(String cameraIds){
        return CommonResult.success(cameraService.deleteCameraByIds(cameraIds));
    }
}
