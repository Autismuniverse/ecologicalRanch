package com.ecologicalRanch.project.entity;

import lombok.Data;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-27 16:48:59'
 */
@Data
public class Address  {
    /**
     * 地址id
     */

    private Long addressId;

    /**
     * 用户id
     */

    private Integer userId;

    /**
     * 收货人名字
     */

    private String consignee;

    /**
     * 准确地址
     */

    private String address;

    /**
     * 收货电话
     */

    private String consigneePhone;

    /**
     * 0为不默认，1为默认地址
     */

    private Integer addressStatus;


}