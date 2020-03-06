package com.ecologicalRanch.project.service;

import com.ecologicalRanch.project.entity.Price;

import java.util.List;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-02-27 16:11:23'
 */
public interface PriceService {

    /**
     * 查询Price列表
     */
    List<Price> selectPriceList(Price price, int pageNum, int pageSize);

    /**
     * 通过Id查询 Price
     */
    Price selectPriceById(Long livestockPriceId);

    /**
     * 新增Price
     */
    int insertPrice(Price price);

    /**
     * 通过id删除Price
     */
    int deletePriceById(Long livestockPriceId);

    /**
     * 通过id批量删除Price
     */
    int deletePriceByIds(String livestockPriceIds);

    /**
     * 修改Price信息
     */
    int updatePrice(Price price);

}