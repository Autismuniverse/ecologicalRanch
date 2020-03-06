package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.common.utils.text.Convert;
import com.ecologicalRanch.project.entity.Price;
import com.ecologicalRanch.project.mapper.PriceMapper;
import com.ecologicalRanch.project.service.PriceService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-02-27 16:11:23'
 */
@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceMapper priceMapper;

    /**
     * 通过Id查询 Price
     */
    @Override
    public Price selectPriceById(Long livestockPriceId) {
        return priceMapper.selectPriceById(livestockPriceId);
    }

    /**
     * 查询Price列表
     */

    @Override
    public List<Price> selectPriceList(Price price, int pageNum, int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->priceMapper.selectPriceList(price));
    }

    /**
     * 新增Price
     */
    @Override
    public int insertPrice(Price price) {
        return priceMapper.insertPrice(price);
    }

    /**
     * 通过id删除Price
     */
    @Override
    public int deletePriceById(Long livestockPriceId) {
        return priceMapper.deletePriceById(livestockPriceId);
    }

    /**
     * 通过id批量删除Price
     */
    @Override
    public int deletePriceByIds(String livestockPriceIds){
        return priceMapper.deletePriceByIds(Convert.toStrArray(livestockPriceIds));
    }

    /**
     * 修改Price信息
     */
    @Override
    public int updatePrice(Price price) {
        return priceMapper.updatePrice(price);
    }

}

