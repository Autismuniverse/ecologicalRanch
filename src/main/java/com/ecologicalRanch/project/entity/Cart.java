package com.ecologicalRanch.project.entity;

import lombok.Data;
import java.util.Date;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-06-27 16:27:13'
 */
@Data
public class Cart  {
    /**
     * 购物车商品ID
     */

    private Long shoppingCartId;

    /**
     * 用户ID
     */

    private Integer userId;

    /**
     * 牲畜ID
     */

    private Integer livestockId;

    /**
     * 商品状态（1:正常；0：删除）
     */


    /**
     * 创建（加入购物车）时间
     */


    /**
     * 删除时间
     */

    private Date deleteTime;


}