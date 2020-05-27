package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.common.utils.text.Convert;
import com.ecologicalRanch.project.entity.Order;
import com.ecologicalRanch.project.mapper.OrderMapper;
import com.ecologicalRanch.project.service.OrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-26 18:55:17'
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 通过Id查询 Order
     */
    @Override
    public Order selectOrderById(Long orderId) {
        return orderMapper.selectOrderById(orderId);
    }

    /**
     * 查询Order列表
     */

    @Override
    public List<Order> selectOrderList(Order order,int pageNum,int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->orderMapper.selectOrderList(order));
    }

    /**
     * 新增Order
     */
    @Override
    public int insertOrder(Order order) {
        return orderMapper.insertOrder(order);
    }

    /**
     * 通过id删除Order
     */
    @Override
    public int deleteOrderById(Long orderId) {
        return orderMapper.deleteOrderById(orderId);
    }

    /**
     * 通过id批量删除Order
     */
    @Override
    public int deleteOrderByIds(String orderIds){
        return orderMapper.deleteOrderByIds(Convert.toStrArray(orderIds));
    }

    /**
     * 修改Order信息
     */
    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateOrder(order);
    }

    /**
     * 查询Order列表
     */

    @Override
    public List<Order> selectOrderInfoListByUserId(Order order,int pageNum,int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->orderMapper.selectOrderInfoListByUserId(order));
    }
}
