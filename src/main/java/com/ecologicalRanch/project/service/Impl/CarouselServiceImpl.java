package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.common.utils.text.Convert;
import com.ecologicalRanch.project.entity.Carousel;
import com.ecologicalRanch.project.mapper.CarouselMapper;
import com.ecologicalRanch.project.service.CarouselService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date '2020-01-10 16:30:19'
 */
@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    /**
     * 通过Id查询 Carousel
     */
    @Override
    public Carousel selectCarouselById(Long carouselId) {
        return carouselMapper.selectCarouselById(carouselId);
    }

    /**
     * 查询Carousel列表
     */

    @Override
    public List<Carousel> selectCarouselList(Carousel carousel,int pageNum,int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->carouselMapper.selectCarouselList(carousel));
    }

    /**
     * 新增Carousel
     */
    @Override
    public int insertCarousel(Carousel carousel) {
        return carouselMapper.insertCarousel(carousel);
    }

    /**
     * 通过id删除Carousel
     */
    @Override
    public int deleteCarouselById(Long carouselId) {
        return carouselMapper.deleteCarouselById(carouselId);
    }

    /**
     * 通过id批量删除Carousel
     */
    @Override
    public int deleteCarouselByIds(String carouselIds){
        return carouselMapper.deleteCarouselByIds(Convert.toStrArray(carouselIds));
    }

    /**
     * 修改Carousel信息
     */
    @Override
    public int updateCarousel(Carousel carousel) {
        return carouselMapper.updateCarousel(carousel);
    }

}