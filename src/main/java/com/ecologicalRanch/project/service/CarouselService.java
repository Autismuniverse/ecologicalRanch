package com.ecologicalRanch.project.service;

import com.ecologicalRanch.project.entity.Carousel;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date '2020-01-10 16:30:19'
 */
public interface CarouselService {

    /**
     * 查询Carousel列表
     */
    List<Carousel> selectCarouselList(Carousel carousel, int pageNum, int pageSize);

    /**
     * 通过Id查询 Carousel
     */
    Carousel selectCarouselById(Long carouselId);

    /**
     * 新增Carousel
     */
    int insertCarousel(Carousel carousel);

    /**
     * 通过id删除Carousel
     */
    int deleteCarouselById(Long carouselId);

    /**
     * 通过id批量删除Carousel
     */
    int deleteCarouselByIds(String carouselIds);

    /**
     * 修改Carousel信息
     */
    int updateCarousel(Carousel carousel);

}
