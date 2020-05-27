package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.project.entity.Discount;
import com.ecologicalRanch.project.result.CommonResult;
import com.ecologicalRanch.project.service.DiscountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-28 14:23:46'
 */
@Api(tags = "折扣")
@Controller
@RequestMapping("/app/discount")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    /**
     * 查询Discount列表
     */
    @ApiOperation(" 查询Discount列表")
    @PostMapping("/selectDiscountList")
    @ResponseBody
    public CommonResult selectDiscountList(@RequestBody Discount discount){
        return CommonResult.success(discountService.selectDiscountList(discount));
    }

    /**
     * 通过Id查询Discount
     */
    @ApiOperation("通过Id查询Discount")
    @GetMapping("/selectDiscountById/{predeterminedDiscountId}")
    @ResponseBody
    public CommonResult selectDiscountById(@PathVariable("predeterminedDiscountId") Long predeterminedDiscountId){
        return CommonResult.success(discountService.selectDiscountById(predeterminedDiscountId));
    }

    /**
     * 新增Discount
     */
    @ApiOperation("新增Discount")
    @PostMapping("/insertDiscount")
    @ResponseBody
    public CommonResult insertDiscount(@RequestBody Discount discount){
        return CommonResult.success(discountService.insertDiscount(discount));
    }

    /**
     * 修改Discount信息
     */
    @ApiOperation("修改Discount信息")
    @PostMapping("/updateDiscount")
    @ResponseBody
    public CommonResult updateDiscount(@RequestBody Discount discount){
        return CommonResult.success(discountService.updateDiscount(discount));
    }

    /**
     * 通过id删除Discount
     */
    @ApiOperation("通过id删除Discount")
    @PostMapping("/deleteDiscountById/{predeterminedDiscountId}")
    @ResponseBody
    public CommonResult deleteDiscountById(@PathVariable("predeterminedDiscountId") Long predeterminedDiscountId){
        return CommonResult.success(discountService.deleteDiscountById(predeterminedDiscountId));
    }

    /**
     * 通过id批量删除Discount
     */
    @ApiOperation("通过id批量删除Discount")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteDiscountByIds(String predeterminedDiscountIds){
        return CommonResult.success(discountService.deleteDiscountByIds(predeterminedDiscountIds));
    }
}

