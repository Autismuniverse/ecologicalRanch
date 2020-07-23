package com.ecologicalRanch.project.mapper;

import com.ecologicalRanch.project.entity.Cart;

import java.util.List;


/**
 *
 *
 * @author xxxfredyang
 * @date '2020-06-27 16:34:04'
 */
public interface CartMapper {

    /**
     * 查询Cart列表
     * @param cart 查询对象
     * @return 查询列表
     */
    List<Cart> selectCartList(Cart cart);

    /**
     * 通过Id查询 Cart
     * @param shoppingCartId 查询Id
     * @return 查询对象
     */
    Cart selectCartById(Long shoppingCartId);

    /**
     * 新增Cart
     * @param cart 新增对象
     * @return 插入行数
     */
    int insertCart(Cart cart);

    /**
     * 修改Cart信息
     * @param  cart 用户对象
     * @return 更新行数
     */
    int updateCart(Cart cart);

    /**
     * 通过id删除Cart
     * @param shoppingCartId 删除id
     * @return 删除行数
     */
    int deleteCartById(Long shoppingCartId);

    /**
     * 通过id批量删除Cart
     * @param shoppingCartIds 删除ids
     * @return 删除行数
     */
    int deleteCartByIds(String[] shoppingCartIds);

}

