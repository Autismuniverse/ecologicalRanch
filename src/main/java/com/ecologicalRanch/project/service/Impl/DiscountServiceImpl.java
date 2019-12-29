package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.project.entity.Discount;
import com.ecologicalRanch.project.mapper.DiscountMapper;
import com.ecologicalRanch.project.service.DiscountService;
import com.ecologicalRanch.utils.Convert;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-28 11:27:04'
 */
@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountMapper discountMapper;

    /**
     * 通过Id查询 Discount
     */
    @Override
    public Discount selectDiscountById(Long predeterminedDiscountId) {
        return discountMapper.selectDiscountById(predeterminedDiscountId);
    }

    /**
     * 查询Discount列表
     */

    @Override
    public List<Discount> selectDiscountList(Discount discount, int pageNum, int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->discountMapper.selectDiscountList(discount));
    }

    /**
     * 新增Discount
     */
    @Override
    public int insertDiscount(Discount discount) {
        return discountMapper.insertDiscount(discount);
    }

    /**
     * 通过id删除Discount
     */
    @Override
    public int deleteDiscountById(Long predeterminedDiscountId) {
        return discountMapper.deleteDiscountById(predeterminedDiscountId);
    }

    /**
     * 通过id批量删除Discount
     */
    @Override
    public int deleteDiscountByIds(String predeterminedDiscountIds){
        return discountMapper.deleteDiscountByIds(Convert.toStrArray(predeterminedDiscountIds));
    }

    /**
     * 修改Discount信息
     */
    @Override
    public int updateDiscount(Discount discount) {
        return discountMapper.updateDiscount(discount);
    }

}
