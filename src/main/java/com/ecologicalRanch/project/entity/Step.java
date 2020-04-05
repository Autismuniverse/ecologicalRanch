package com.ecologicalRanch.project.entity;

import lombok.Data;
import java.util.Date;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-04-02 16:07:03'
 */
@Data
public class Step  {
    /**
     * 步数表ID
     */

    private Long stepNumId;

    /**
     * 牲畜的ID
     */

    private Integer livestockId;

    /**
     * 牲畜的步数
     */

    private Integer stepNum;

    /**
     * 记录时间
     */

    private Date creatTime;


}