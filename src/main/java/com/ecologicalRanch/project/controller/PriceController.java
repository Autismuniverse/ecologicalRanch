package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.Price;
import com.ecologicalRanch.project.service.PriceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-02-27 16:11:23'
 */
@Api(tags = "价格与品种")
@Controller
@RequestMapping("/app/price")
public class PriceController {

    @Autowired
    private PriceService priceService;

    /**
     * 查询Price列表
     */
    @ApiOperation(" 查询Price列表")
    @PostMapping("/selectPriceList")
    @ResponseBody
    public CommonResult selectPriceList(@RequestBody Price price,
                                        @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                        @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize){
        return CommonResult.success(CommonPage.restPage(priceService.selectPriceList(price,pageNum,pageSize)));
    }

    /**
     * 查询Price不分页列表
     */
    @ApiOperation(" 查询Price列表无分页")
    @PostMapping("/selectPriceListNoPageHelper")
    @ResponseBody
    public CommonResult selectPriceListNoPageHelper(@RequestBody Price price){
        return CommonResult.success(priceService.selectPriceListNoPageHelper(price));
    }

    /**
     * 通过Id查询Price
     */
    @ApiOperation("通过Id查询Price")
    @PostMapping("/selectPriceById")
    @ResponseBody
    public CommonResult selectPriceById(@RequestBody Long livestockPriceId){
        return CommonResult.success(priceService.selectPriceById(livestockPriceId));
    }

    /**
     * 新增Price
     */
    @ApiOperation("新增Price")
    @PostMapping("/insertPrice")
    @ResponseBody
    public CommonResult insertPrice(@RequestBody Price price){
        return CommonResult.success(priceService.insertPrice(price));
    }

    /**
     * 修改Price信息
     */
    @ApiOperation("修改Price信息")
    @PostMapping("/updatePrice")
    @ResponseBody
    public CommonResult updatePrice(@RequestBody Price price){
        return CommonResult.success(priceService.updatePrice(price));
    }

    /**
     * 通过id删除Price
     */
    @ApiOperation("通过id删除Price")
    @PostMapping("/deletePriceById")
    @ResponseBody
    public CommonResult deletePriceById(@RequestBody Price price){
        return CommonResult.success(priceService.deletePriceById(price.getLivestockPriceId()));
    }

    /**
     * 通过id批量删除Price
     */
    @ApiOperation("通过id批量删除Price")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deletePriceByIds(String livestockPriceIds){
        return CommonResult.success(priceService.deletePriceByIds(livestockPriceIds));
    }
    /**
     * 查询Price只返回一个type字段
     */
    @ApiOperation(" 查询鸡的type列表无分页，只返回一个type字段")
    @PostMapping("/selectPriceListNoPageHelperOneType")
    @ResponseBody
    public CommonResult selectPriceListNoPageHelperOneType(@RequestBody Price price){
        return CommonResult.success(priceService.selectPriceListNoPageHelperOneType(price));
    }
}