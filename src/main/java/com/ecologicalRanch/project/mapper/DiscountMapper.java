package com.ecologicalRanch.project.mapper;

import com.ecologicalRanch.project.entity.Discount;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-28 11:27:04'
 */
public interface DiscountMapper {

    /**
     * 查询Discount列表
     * @param discount 查询对象
     * @return 查询列表
     */
    List<Discount> selectDiscountList(Discount discount);

    /**
     * 通过Id查询 Discount
     * @param predeterminedDiscountId 查询Id
     * @return 查询对象
     */
    Discount selectDiscountById(Long predeterminedDiscountId);

    /**
     * 通过Id查询 Discount
     * @param fieldId 查询Id
     * @return 查询对象
     */
    Discount selectDiscountByFieldId(Integer fieldId);

    /**
     * 新增Discount
     * @param discount 新增对象
     * @return 插入行数
     */
    int insertDiscount(Discount discount);

    /**
     * 修改Discount信息
     * @param  discount 用户对象
     * @return 更新行数
     */
    int updateDiscount(Discount discount);

    /**
     * 通过id删除Discount
     * @param predeterminedDiscountId 删除id
     * @return 删除行数
     */
    int deleteDiscountById(Long predeterminedDiscountId);

    /**
     * 通过id批量删除Discount
     * @param predeterminedDiscountIds 删除ids
     * @return 删除行数
     */
    int deleteDiscountByIds(String[] predeterminedDiscountIds);

}
