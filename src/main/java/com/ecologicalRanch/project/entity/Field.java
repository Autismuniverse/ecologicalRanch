package com.ecologicalRanch.project.entity;

import lombok.Data;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-30 14:31:08'
 */
@Data
public class Field {
    /**
     * 场地ID
     */

    private Long fieldId;

    /**
     * 牲畜场管理员id
     */

    private Long adminId;

    /**
     * 场地名称
     */

    private String fieldName;

    /**
     * 位置
     */

    private String address;

    /**
     * 合格验证，0为未合格，1为合格
     */

    private Integer qualified;

    /**
     * 养殖场关注数
     */

    private Integer grade;

    /**
     * 商店logo src地址
     */

    private String logoSrc;

    /**
     * 样式名
     */

    private String styleClass;


}
