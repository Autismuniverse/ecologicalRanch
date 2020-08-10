package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.common.utils.text.Convert;
import com.ecologicalRanch.project.entity.Cart;
import com.ecologicalRanch.project.mapper.CartMapper;
import com.ecologicalRanch.project.service.CartService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 *
 *
 * @author xxxfredyang
 * @date '2020-06-27 16:34:04'
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    /**
     * 通过Id查询 Cart
     */
    @Override
    public Cart selectCartById(Long shoppingCartId) {
        return cartMapper.selectCartById(shoppingCartId);
    }

    /**
     * 查询Cart列表
     */

    @Override
    public List<Cart> selectCartList(Cart cart,int pageNum,int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->cartMapper.selectCartList(cart));
    }

    @Override
    public List<Cart> selectUserCart(Integer userId){
//        System.out.println(userId);
        return cartMapper.selectUserCart(userId);
    }

    /**
     * 新增Cart
     */
    @Override
    public int insertCart(Cart cart) {
        System.out.println("查询结果："+cartMapper.selectCartList(cart));
        if (cartMapper.selectCartList(cart).toArray().length == 0)
        {
            System.out.println("该用户没有添加过购物车，添加成功");
            return cartMapper.insertCart(cart);
        }

        else
            return 0;
    }

    /**
     * 通过id删除Cart
     */
    @Override
    public int deleteCartById(Long shoppingCartId) {
        return cartMapper.deleteCartById(shoppingCartId);
    }

    /**
     * 通过id批量删除Cart
     */
    @Override
    public int deleteCartByIds(String shoppingCartIds){
        return cartMapper.deleteCartByIds(Convert.toStrArray(shoppingCartIds));
    }

    /**
     * 修改Cart信息
     */
    @Override
    public int updateCart(Cart cart) {
        return cartMapper.updateCart(cart);
    }

}
