package com.ecologicalRanch.project.controller;


import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.Carousel;
import com.ecologicalRanch.project.service.CarouselService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author u-fun
 * @date '2020-01-10 16:30:19'
 */
@Api(tags = "轮播图")
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
                                           @RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum,
                                           @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        try {
            return CommonResult.success(CommonPage.restPage(carouselService.selectCarouselList(carousel, pageNum, pageSize)));
        } catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }

    /**
     * 通过Id查询Carousel
     */
    @ApiOperation("通过Id查询Carousel")
    @GetMapping("/selectCarouselById")
    @ResponseBody
    public CommonResult selectCarouselById(@RequestBody Carousel carousel) {
        try {
            return CommonResult.success(carouselService.selectCarouselById(carousel.getCarouselId()));
        } catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }

    /**
     * 新增Carousel
     */
    @ApiOperation("新增Carousel")
    @PostMapping("/insertCarousel")
    @ResponseBody
    public CommonResult insertCarousel(@RequestBody Carousel carousel) {
        try {
            return CommonResult.success(carouselService.insertCarousel(carousel));
        } catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }

    /**
     * 修改Carousel信息
     */
    @ApiOperation("修改Carousel信息")
    @PostMapping("/updateCarousel")
    @ResponseBody
    public CommonResult updateCarousel(@RequestBody Carousel carousel) {
        try {
            return CommonResult.success(carouselService.updateCarousel(carousel));
        } catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }

    /**
     * 通过id删除Carousel
     */
    @ApiOperation("通过id删除Carousel")
    @PostMapping("/deleteCarouselById/{carouselId}")
    @ResponseBody
    public CommonResult deleteCarouselById(@PathVariable("carouselId") Long carouselId) {
        try {
            return CommonResult.success(carouselService.deleteCarouselById(carouselId));
        } catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }

    /**
     * 通过id批量删除Carousel
     */
    @ApiOperation("通过id批量删除Carousel")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteCarouselByIds(String carouselIds) {
        try {
            return CommonResult.success(carouselService.deleteCarouselByIds(carouselIds));
        } catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }
}
