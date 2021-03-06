package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.project.entity.Field;
import com.ecologicalRanch.project.result.CommonResult;
import com.ecologicalRanch.project.service.FieldService;
import com.ecologicalRanch.project.service.PriceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author u-fun
 * @date '2019-12-30 14:31:08'
 */
@Api(tags = "养殖场")
@Controller
@RequestMapping("/app/field")
@Slf4j
public class FieldController {

    @Autowired
    private FieldService fieldService;
    @Autowired
    private PriceService priceService;


    /**
     * 查询Field列表
     */
    @ApiOperation(" 查询Field列表")
    @PostMapping("/selectFieldList")
    @ResponseBody
    public CommonResult selectFieldList(@RequestBody Field field,
                                        @RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum,
                                        @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        try {
            return CommonResult.success(CommonPage.restPage(fieldService.selectFieldList(field, pageNum, pageSize)));
        } catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 通过Id查询Field
     * <p>
     * {
     * "fieldId":1
     * }
     */
    @ApiOperation("通过Id查询Field")
    @PostMapping("/selectFieldById/")
    @ResponseBody
    public CommonResult selectFieldById(@RequestBody Field field) {
        try {
            return CommonResult.success(fieldService.selectFieldById(field.getFieldId()));
        } catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 新增Field
     */
    @ApiOperation("新增Field")
    @PostMapping("/insertField")
    @ResponseBody
    public CommonResult insertField(@RequestBody Field field) {
        try{
            
            return CommonResult.success(fieldService.insertField(field));
        }catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 修改Field信息
     */
    @ApiOperation("修改Field信息")
    @PostMapping("/updateField")
    @ResponseBody
    public CommonResult updateField(@RequestBody Field field) {
        try{
            return CommonResult.success(fieldService.updateField(field));
        }catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 通过id删除Field
     */
    @ApiOperation("通过id删除Field")
    @PostMapping("/deleteFieldById/{fieldId}")
    @ResponseBody
    public CommonResult deleteFieldById(@PathVariable("fieldId") Long fieldId) {
        try{
            return CommonResult.success(fieldService.deleteFieldById(fieldId));
        }catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 通过id批量删除Field
     */
    @ApiOperation("通过id批量删除Field")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteFieldByIds(String fieldIds) {
        try{
            return CommonResult.success(fieldService.deleteFieldByIds(fieldIds));
        }catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 通过adminId查询Field
     */
    @ApiOperation("通过adminId查询Field")
    @PostMapping("/selectFieldByAdminId/")
    @ResponseBody
    public CommonResult selectFieldByAdminId(@RequestBody Field field) {


//        return CommonResult.success(fieldService.selectFieldById(field.getFieldId()));
        try{
            return CommonResult.success(fieldService.selectFieldByAdminId(field.getAdminId()));
        }catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 通过FieldIds查询Field
     */
    @ApiOperation("通过FieldIds数组查询Field")
    @GetMapping("/selectFieldByFieldIds/{fieldIds}")
    @ResponseBody
    public CommonResult selectFieldByFieldIds(@PathVariable String fieldIds) {

        try{
            return CommonResult.success(fieldService.selectFieldByFieldIds(fieldIds));
        }catch (Exception e) {
            return CommonResult.failed("请输入正确的fieldId");
        }

    }
}

