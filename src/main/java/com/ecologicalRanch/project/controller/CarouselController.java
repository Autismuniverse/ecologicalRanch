package com.ecologicalRanch.project.controller;


import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.Carousel;
import com.ecologicalRanch.project.service.CarouselService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 * @author u-fun
 * @date '2020-01-10 16:30:19'
 */
@Controller
@RequestMapping("/app/carousel")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    /**
     * 查询Carousel列表
     */
    @ApiOperation(" 查询Carousel列表")
    @PostMapping("/selectCarouselList")
    @ResponseBody
    public CommonResult selectCarouselList(@RequestBody Carousel carousel,
                                           @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                           @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize){
        return CommonResult.success(CommonPage.restPage(carouselService.selectCarouselList(carousel,pageNum,pageSize)));
    }

    /**
     * 通过Id查询Carousel
     */
    @ApiOperation("通过Id查询Carousel")
    @GetMapping("/selectCarouselById/{carouselId}")
    @ResponseBody
    public CommonResult selectCarouselById(@PathVariable("carouselId") Long carouselId){
        return CommonResult.success(carouselService.selectCarouselById(carouselId));
    }

    /**
     * 新增Carousel
     */
    @ApiOperation("新增Carousel")
    @PostMapping("/insertCarousel")
    @ResponseBody
    public CommonResult insertCarousel(@RequestBody Carousel carousel){
        return CommonResult.success(carouselService.insertCarousel(carousel));
    }

    /**
     * 修改Carousel信息
     */
    @ApiOperation("修改Carousel信息")
    @PostMapping("/updateCarousel")
    @ResponseBody
    public CommonResult updateCarousel(@RequestBody Carousel carousel){
        return CommonResult.success(carouselService.updateCarousel(carousel));
    }

    /**
     * 通过id删除Carousel
     */
    @ApiOperation("通过id删除Carousel")
    @PostMapping("/deleteCarouselById/{carouselId}")
    @ResponseBody
    public CommonResult deleteCarouselById(@PathVariable("carouselId") Long carouselId){
        return CommonResult.success(carouselService.deleteCarouselById(carouselId));
    }

    /**
     * 通过id批量删除Carousel
     */
    @ApiOperation("通过id批量删除Carousel")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteCarouselByIds(String carouselIds){
        return CommonResult.success(carouselService.deleteCarouselByIds(carouselIds));
    }
}
