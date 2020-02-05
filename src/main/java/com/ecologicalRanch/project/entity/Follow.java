package com.ecologicalRanch.project.entity;

import lombok.Data;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-01-19 18:10:04'
 */
@Data
public class Follow  {
    /**
     * 用户唯一识别码
     */

    private String userId;

    /**
     * 商店id
     */

    private Integer shopId;


}