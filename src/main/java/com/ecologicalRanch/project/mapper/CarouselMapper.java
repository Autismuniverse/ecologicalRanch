package com.ecologicalRanch.project.mapper;

import com.ecologicalRanch.project.entity.Carousel;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date '2020-01-10 16:30:19'
 */
public interface CarouselMapper {

    /**
     * 查询Carousel列表
     * @param carousel 查询对象
     * @return 查询列表
     */
    List<Carousel> selectCarouselList(Carousel carousel);

    /**
     * 通过Id查询 Carousel
     * @param carouselId 查询Id
     * @return 查询对象
     */
    Carousel selectCarouselById(Long carouselId);

    /**
     * 新增Carousel
     * @param carousel 新增对象
     * @return 插入行数
     */
    int insertCarousel(Carousel carousel);

    /**
     * 修改Carousel信息
     * @param  carousel 用户对象
     * @return 更新行数
     */
    int updateCarousel(Carousel carousel);

    /**
     * 通过id删除Carousel
     * @param carouselId 删除id
     * @return 删除行数
     */
    int deleteCarouselById(Long carouselId);

    /**
     * 通过id批量删除Carousel
     * @param carouselIds 删除ids
     * @return 删除行数
     */
    int deleteCarouselByIds(String[] carouselIds);

}