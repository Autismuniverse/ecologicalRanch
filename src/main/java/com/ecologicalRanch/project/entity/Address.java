package com.ecologicalRanch.project.entity;

import lombok.Data;

import javax.validation.constraints.Pattern;

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
    @Pattern(regexp = "^[1][3,4,5,7,8][0-9]{9}$",message = "请输入正确的电话号码")
    private String consigneePhone;

    /**
     * 0为不默认，1为默认地址
     */

    private Integer addressStatus;


}