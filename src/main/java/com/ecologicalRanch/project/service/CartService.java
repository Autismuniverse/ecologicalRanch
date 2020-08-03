package com.ecologicalRanch.project.service;


import com.ecologicalRanch.project.entity.Cart;

import java.util.List;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-06-27 16:34:04'
 */
public interface CartService {

    /**
     * 查询Cart列表
     */
    List<Cart> selectCartList(Cart cart, int pageNum, int pageSize);

    /**
     * 查询Cart列表
     */
    List<Cart> selectUserCart(Integer userId);

    /**
     * 通过Id查询 Cart
     */
    Cart selectCartById(Long shoppingCartId);

    /**
     * 新增Cart
     */
    int insertCart(Cart cart);

    /**
     * 通过id删除Cart
     */
    int deleteCartById(Long shoppingCartId);

    /**
     * 通过id批量删除Cart
     */
    int deleteCartByIds(String shoppingCartIds);

    /**
     * 修改Cart信息
     */
    int updateCart(Cart cart);

}

