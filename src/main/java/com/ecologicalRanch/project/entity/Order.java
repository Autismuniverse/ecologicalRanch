package com.ecologicalRanch.project.entity;


import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.sql.Timestamp;

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

    private Long livestockId;

    /**
     * 订单状态：0表示未付款；1表示已付款；2表示未发货；3表示已发货；4表示已收货；5表示已预订支付定金 但未支付全额；
     */

    @Range(min = 0,max = 7,message = "请输入正确的状态")
    private Integer status;

    /**
     * 养殖户id
     */

    private Integer fieldId;

    /**
     * 支付金额
     */

    private double paymentAmount;

    /**
     *原价
     */

    private double originalPrice;

    /**
     * 评价id
     */

    private Long commentId;

    /**
     * 创建时间
     */

    private Timestamp creationTime;

    /**
     * 支付时间
     */

    private Timestamp paymentTime;

    /**
     * 发货时间
     */

    private Timestamp deliveryTime;

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

    /**
     * 牲畜价格品种信息
     */
    private Price price;

    /**
     * 物流单号
     */
    private String logistics;

}