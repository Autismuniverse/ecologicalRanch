package com.ecologicalRanch.project.mapper;

import com.ecologicalRanch.project.entity.Price;

import java.util.List;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-02-27 16:11:23'
 */
public interface PriceMapper {

    /**
     * 查询Price列表
     * @param price 查询对象
     * @return 查询列表
     */
    List<Price> selectPriceList(Price price);

    /**
     * 通过Id查询 Price
     * @param livestockPriceId 查询Id
     * @return 查询对象
     */
    Price selectPriceById(Long livestockPriceId);

    /**
     * 新增Price
     * @param price 新增对象
     * @return 插入行数
     */
    int insertPrice(Price price);

    /**
     * 修改Price信息
     * @param  price 用户对象
     * @return 更新行数
     */
    int updatePrice(Price price);

    /**
     * 通过id删除Price
     * @param livestockPriceId 删除id
     * @return 删除行数
     */
    int deletePriceById(Long livestockPriceId);

    /**
     * 通过id批量删除Price
     * @param livestockPriceIds 删除ids
     * @return 删除行数
     */
    int deletePriceByIds(String[] livestockPriceIds);

    /**
     * 查询Price列表只返回一个type字段
     * @param price 查询对象
     * @return 查询列表
     */
    List<Price> selectPriceListNoPageHelperOneType(Price price);

}

