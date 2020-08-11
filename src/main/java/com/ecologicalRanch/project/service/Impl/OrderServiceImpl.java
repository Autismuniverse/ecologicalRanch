package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.common.utils.text.Convert;
import com.ecologicalRanch.project.entity.Livestock;
import com.ecologicalRanch.project.entity.Order;
import com.ecologicalRanch.project.mapper.LivestockMapper;
import com.ecologicalRanch.project.mapper.OrderMapper;
import com.ecologicalRanch.project.mapper.PriceMapper;
import com.ecologicalRanch.project.service.LivestockService;
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
    @Autowired
    private LivestockMapper livestockMapper;
    @Autowired
    private PriceMapper priceMapper;
    @Autowired
    private LivestockService livestockService;
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
        Livestock livestock = new Livestock();
        livestock.setLivestockId(order.getLivestockId().longValue());
        livestock.setStatus(order.getStatus());
        livestock.setStatus(8);
        if(livestockService.selectLivestockById(order.getLivestockId().longValue()).getStatus() == 8 ){
            return 0;
        }
        livestockMapper.updateLivestock(livestock);
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
        if (order.getStatus() != null){
            Livestock livestock = new Livestock();
            livestock.setLivestockId(order.getLivestockId().longValue());
            livestock.setStatus(order.getStatus());
            livestockService.updateLivestock(livestock);
        }
        return orderMapper.updateOrder(order);
    }

    /**
     * 取消订单
     * @param orderId
     * @return
     */
    @Override
    public int  cancelDelivery(Order order){
        Livestock livestock = new Livestock();
        livestock.setLivestockId(order.getLivestockId());
        livestock.setStatus(3);
        livestockService.updateLivestock(livestock);
        return orderMapper.cancelDelivery(order.getOrderId());
    }

    /**
     * 查询Order列表
     */

    @Override
    public List<Order> selectOrderInfoListByUserId(Order order,int pageNum,int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->orderMapper.selectOrderInfoListByUserId(order));
    }
}
