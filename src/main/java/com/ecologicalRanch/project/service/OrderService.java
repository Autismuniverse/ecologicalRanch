package com.ecologicalRanch.project.service;

import com.ecologicalRanch.project.entity.Order;

import java.util.List;



/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-26 18:55:17'
 */
public interface OrderService {

    /**
     * 查询Order列表
     */
    List<Order> selectOrderList(Order order, int pageNum, int pageSize);

    /**
     * 通过Id查询 Order
     */
    Order selectOrderById(Long orderId);

    /**
     * 新增Order
     */
    int insertOrder(Order order);

    /**
     * 通过id删除Order
     */
    int deleteOrderById(Long orderId);

    /**
     * 通过id批量删除Order
     */
    int deleteOrderByIds(String orderIds);

    /**
     * 修改Order信息
     */
    int updateOrder(Order order);

    /**
     * 根据Order查询field
     */
    List<Order> selectOrderInfoListByUserId(Order order, int pageNum, int pageSize);
}
