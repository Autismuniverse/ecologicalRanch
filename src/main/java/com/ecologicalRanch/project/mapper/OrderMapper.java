package com.ecologicalRanch.project.mapper;

import com.ecologicalRanch.project.entity.Order;

import java.util.List;



/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-26 18:55:17'
 */
public interface OrderMapper {

    /**
     * 查询Order列表
     * @param order 查询对象
     * @return 查询列表
     */
    List<Order> selectOrderList(Order order);

    /**
     * 通过Id查询 Order
     * @param orderId 查询Id
     * @return 查询对象
     */
    Order selectOrderById(Long orderId);

    /**
     * 新增Order
     * @param order 新增对象
     * @return 插入行数
     */
    int insertOrder(Order order);

    /**
     * 修改Order信息
     * @param  order 用户对象
     * @return 更新行数
     */
    int updateOrder(Order order);


    /**
     * 取消发货
     * @param orderId
     * @return
     */
    int cancelDelivery(Long orderId);

    /**
     * 通过id删除Order
     * @param orderId 删除id
     * @return 删除行数
     */
    int deleteOrderById(Long orderId);

    /**
     * 通过id批量删除Order
     * @param orderIds 删除ids
     * @return 删除行数
     */
    int deleteOrderByIds(String[] orderIds);

    /**
     * 通过order查询field
     * @param order 删除ids
     * @return 删除行数
     */
    List<Order> selectOrderInfoListByUserId(Order order);

}
