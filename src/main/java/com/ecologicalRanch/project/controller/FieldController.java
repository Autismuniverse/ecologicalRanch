package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.project.entity.Field;
import com.ecologicalRanch.project.result.CommonResult;
import com.ecologicalRanch.project.service.FieldService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-30 14:31:08'
 */
@Api(tags = "养殖场")
@Controller
@RequestMapping("/app/field")
public class FieldController {

    @Autowired
    private FieldService fieldService;


    /**
     * 查询Field列表
     */
    @ApiOperation(" 查询Field列表")
    @PostMapping("/selectFieldList")
    @ResponseBody
    public CommonResult selectFieldList(Field field,
                                        @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                        @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize){
        return CommonResult.success(CommonPage.restPage(fieldService.selectFieldList(field,pageNum,pageSize)));
    }

    /**
     * 通过Id查询Field
     */
    @ApiOperation("通过Id查询Field")
    @PostMapping("/selectFieldById/{fieldId}")
    @ResponseBody
    public CommonResult selectFieldById(@PathVariable("fieldId") Long fieldId){
        return CommonResult.success(fieldService.selectFieldById(fieldId));
    }

    /**
     * 新增Field
     */
    @ApiOperation("新增Field")
    @PostMapping("/insertField")
    @ResponseBody
    public CommonResult insertField(Field field){
        return CommonResult.success(fieldService.insertField(field));
    }

    /**
     * 修改Field信息
     */
    @ApiOperation("修改Field信息")
    @PostMapping("/updateField")
    @ResponseBody
    public CommonResult updateField(Field field){
        return CommonResult.success(fieldService.updateField(field));
    }

    /**
     * 通过id删除Field
     */
    @ApiOperation("通过id删除Field")
    @PostMapping("/deleteFieldById/{fieldId}")
    @ResponseBody
    public CommonResult deleteFieldById(@PathVariable("fieldId") Long fieldId){
        return CommonResult.success(fieldService.deleteFieldById(fieldId));
    }

    /**
     * 通过id批量删除Field
     */
    @ApiOperation("通过id批量删除Field")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteFieldByIds(String fieldIds){
        return CommonResult.success(fieldService.deleteFieldByIds(fieldIds));
    }
}

