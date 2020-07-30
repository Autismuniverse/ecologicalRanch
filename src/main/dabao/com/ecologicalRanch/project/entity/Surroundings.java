package com.ecologicalRanch.project.entity;


import lombok.Data;

/**
 *
 *
 * @author XXXFredYang
 * @date '2020-07-29 15:43:26'
 */
@Data
public class Surroundings {
    /**
     * 环境图片id
     */

    private Integer surroundingsId;

    /**
     * 养殖场id
     */

    private Integer fieldId;

    /**
     * 图片地址
     */

    private String picSrc;


}