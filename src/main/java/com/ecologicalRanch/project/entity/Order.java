package com.ecologicalRanch.project.entity;


import lombok.Data;
import java.util.Date;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-26 18:55:17'
 */
@Data
public class Order  {
    /**
     * 订单id
     */

    private Long orderId;

    /**
     * 用户id
     */

    private Integer userId;

    /**
     * 牲畜id
     */

    private Integer livestockId;

    /**
     * 订单状态：0表示未付款；1表示已付款；2表示未发货；3表示已发货；4表示已收货；5表示已预订支付定金 但未支付全额；
     */

    private Integer status;

    /**
     * 养殖户id
     */

    private Integer fieldId;

    /**
     * 支付金额
     */

    private Integer paymentAmount;

    /**
     *原价
     */

    private Integer originalPrice;

    /**
     * 评价id
     */

    private Integer commentId;

    /**
     * 创建时间
     */

    private Date creationTime;

    /**
     * 支付时间
     */

    private Date paymentTime;

    /**
     * 发货时间
     */

    private Date deliveryTime;

    /**
     * 物流地址id
     */

    private Integer addressId;

    /**
     * 养殖场类
     */
    private Field Field;

    /**
     * 牲畜信息类
     */
    private Livestock livestock;

    /**
     * 牲畜信息类
     */
    private Step step;



}