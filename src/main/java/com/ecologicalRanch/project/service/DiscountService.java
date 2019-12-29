package com.ecologicalRanch.project.service;

import com.ecologicalRanch.project.entity.Discount;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-28 11:27:04'
 */
public interface DiscountService {

    /**
     * 查询Discount列表
     */
    List<Discount> selectDiscountList(Discount discount, int pageNum, int pageSize);

    /**
     * 通过Id查询 Discount
     */
    Discount selectDiscountById(Long predeterminedDiscountId);

    /**
     * 新增Discount
     */
    int insertDiscount(Discount discount);

    /**
     * 通过id删除Discount
     */
    int deleteDiscountById(Long predeterminedDiscountId);

    /**
     * 通过id批量删除Discount
     */
    int deleteDiscountByIds(String predeterminedDiscountIds);

    /**
     * 修改Discount信息
     */
    int updateDiscount(Discount discount);

}
