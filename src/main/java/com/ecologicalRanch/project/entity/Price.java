package com.ecologicalRanch.project.entity;

import lombok.Data;

import javax.validation.constraints.Max;
import java.sql.Date;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-02-27 16:11:23'
 */
@Data
public class Price  {
    /**
     * 牲畜的初始价格ID
     */

    private Long livestockPriceId;

    /**
     * 养殖场（商城）id
     */

    private Integer fieldId;

    /**
     * 牲畜的种类
     */

    private String type;

    /**
     * 原价
     */
    @Max(value = 500,message = "定价不能高于500")
    private double originalPrice;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 生效时间
     */

    private Date takeEffectTime;

    /**
     * 鸡的图片
     */
    private String img;


}