package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.Livestock;
import com.ecologicalRanch.project.service.LivestockService;
import com.ecologicalRanch.project.service.PriceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
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
    @Autowired
    private PriceService priceService;

    /**
     * 查询Livestock列表
     */
    @ApiOperation(" 查询Livestock列表")
    @PostMapping("/selectLivestockList")
    @ResponseBody
    public CommonResult selectLivestockList(@RequestBody @Validated Livestock livestock,
                                            @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                            @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize){
        try{
            return CommonResult.success(CommonPage.restPage(livestockService.selectLivestockList(livestock,pageNum,pageSize)));
        }catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }

    /**
     * 通过Id查询Livestock
     */
    @ApiOperation("通过Id查询Livestock")

    @GetMapping("/selectLivestockById/{livestockId}")
    @ResponseBody
    public CommonResult selectLivestockById(@PathVariable("livestockId") Long livestockId){
        try{
            return CommonResult.success(livestockService.selectLivestockById(livestockId));
        }catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }


    /**
     * 查询Livestock列表
     */
    @ApiOperation(" 查询Livestock列表无分页")
    @PostMapping("/selectLivestockListNoPageHelper")
    @ResponseBody
    public CommonResult selectLivestockList(@RequestBody @Validated Livestock livestock){
        try{
            return CommonResult.success(livestockService.selectLivestockListNoPageHelper(livestock));
        }catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }

    /**
     * 新增Livestock
     */
    @ApiOperation("新增Livestock")
    @PostMapping("/insertLivestock")
    @ResponseBody
    public CommonResult insertLivestock(@RequestBody @Validated Livestock livestock){
        try{
            return CommonResult.success(livestockService.insertLivestock(livestock));}
        catch (Exception e){
            return CommonResult.failed("请检查是否数据输入错误");
        }
    }

    /**
     * 修改Livestock信息
     */
    @ApiOperation("修改Livestock信息")
    @PostMapping("/updateLivestock")
    @ResponseBody
    public CommonResult updateLivestock(@RequestBody @Validated Livestock livestock){
        try{
            return CommonResult.success(livestockService.updateLivestock(livestock));
        }catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }

    /**
     * 通过id删除Livestock
     */
    @ApiOperation("通过id删除Livestock")
    @PostMapping("/deleteLivestockById/{livestockId}")
    @ResponseBody
    public CommonResult deleteLivestockById(@PathVariable("livestockId") Long livestockId){
        try{
            return CommonResult.success(livestockService.deleteLivestockById(livestockId));
        }catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }

    /**
     * 通过id批量删除Livestock
     */
    @ApiOperation("通过id批量删除Livestock")
    @GetMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteLivestockByIds(String livestockIds){
        try{
            return CommonResult.success(livestockService.deleteLivestockByIds(livestockIds));
        }catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
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

        try{
            return CommonResult.success(CommonPage.restPage(livestockService.fuzzyLivestockList(livestock,pageNum,pageSize)));
        }catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }

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
    @ApiOperation(" 查询Livestock出售时间去重")
    @PostMapping("/selectOutTime")
    @ResponseBody
    public CommonResult selectOutTime(@RequestBody Livestock livestock){
        try{
            return CommonResult.success(livestockService.selectOutTime(livestock));
        }catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }

    /**
     * 通过Ids查询Livestock
     */
    @ApiOperation("通过Ids查询Livestock列表")
    @GetMapping("/selectLivestockListByIds/{livestockIds}")
    @ResponseBody
    public CommonResult selectLivestockById(@PathVariable String livestockIds){
        try{
            return CommonResult.success(livestockService.selectLivestockListByIds(livestockIds));
        }catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }

    /**
     * 通过LivestockIds查询Livestock价格
     */
    @ApiOperation("通过LivestockIds查询Livestock价格列表")
    @GetMapping("/selectLivestockPriceByIds/{livestockIds}")
    @ResponseBody
    public CommonResult selectLivestockPrice(@PathVariable String livestockIds){
        try{
            return CommonResult.success(livestockService.selectLivestockPrice(livestockIds));
        }catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }


    @ApiOperation("根据养殖场id查询Livestock步数排名列表")
    @GetMapping("/selectLivestockListRank/{fieldId}")
    @ResponseBody
    public CommonResult selectLivestockListRank(@PathVariable Long fieldId){
        try{
            return CommonResult.success(livestockService.selectLivestockListRank(fieldId));
        }catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }


    /**
     * 通过types和outTimes查询Livestock
     */
    @ApiOperation("通过Ids查询Livestock列表")
    @PostMapping("/queryOptions")
    @ResponseBody
    public CommonResult queryOptions(String outTimes,String types,Integer fieldId){
        try{
            return CommonResult.success(livestockService.queryOptions(outTimes,types,fieldId));
        }catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }

    /**
     * 通过types和outTimes查询Livestock
     */
    @ApiOperation("通过Ids查询Livestock以及原始price列表")
    @PostMapping("/selectLivestockAndOriginalPriceById")
    @ResponseBody
    public CommonResult selectLivestockAndOriginalPriceById(String livestockIds,Long fieldId){
        try{
            return CommonResult.success(livestockService.selectLivestockAndOriginalPriceById(livestockIds,fieldId));
        }catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }



}
