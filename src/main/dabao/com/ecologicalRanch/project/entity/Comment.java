package com.ecologicalRanch.project.entity;


import lombok.Data;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-07-23 14:55:28'
 */
@Data
public class Comment  {
    /**
     * 评论ID
     */

    private Long commentId;

    /**
     * 用户ID
     */

    private Integer userId;

    /**
     * 牲畜的ID
     */

    private Integer livestockId;

    /**
     * 评论内容
     */

    private String contents;

    /**
     * 订单id
     */

    private Integer orderId;

    /**
     * 养殖场id
     */

    private String fieldId;


    /**
     * 关联user
     */
    private User user;


}
