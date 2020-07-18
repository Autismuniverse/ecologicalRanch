package com.ecologicalRanch.project.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-27 16:48:59'
 */
@Data
public class Discount {
    /**
     * 预定折扣ID，这个id应该和userid对应一样\r\n
     */

    private Long predeterminedDiscountId;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;


    /**
     *
     */
    @NotNull
    private double firstMonth;

    /**
     *
     */
    @NotNull
    private double secondMonth;

    /**
     *
     */
    @NotNull
    private double thirdMonth;

    /**
     *
     */
    @NotNull
    private double fourthMonth;

    /**
     *
     */
    @NotNull
    private double fifthMonth;

    /**
     *
     */
    @NotNull
    private double sixthMonth;

    /**
     *
     */
    @NotNull
    private double seventhMonth;

    /**
     *
     */
    @NotNull
    private double eighthMonth;

    /**
     *
     */
    @NotNull
    private double ninthMonth;

    /**
     *
     */
    @NotNull
    private double tenthMonth;

    /**
     *
     */
    @NotNull
    private double eleventhMonth;

    /**
     *
     */
    @NotNull
    private double twelfthMonth;

    /**
     * 养殖场id
     */
    private int fieldId;

}