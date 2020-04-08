package com.ecologicalRanch.project.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-31 15:23:10'
 */
@Data
public class Livestock {
    /**
     * 牲畜ID
     */
    @ApiModelProperty(value = "牲畜ID")
    private Long livestockId;

    /**
     * 牲畜场id
     */
    @ApiModelProperty(value = "养殖场ID")
    private Integer fieldId;

    /**
     * 步数表ID
     */
    @ApiModelProperty(value = "步数ID")
    private Integer stepNumId;

    /**
     * 蓝牙ID
     */
    @ApiModelProperty(value = "蓝牙ID")
    private String bluetoothId;

    /**
     * RFID_id
     */
    @ApiModelProperty(value = "rfid")
    private Integer rfidId;

    /**
     *
     */
    @ApiModelProperty(value = "性别")
    private Object sex;

    /**
     * 牲畜的种类
     */
    @ApiModelProperty(value = "种类")
    private String species;

    /**
     * 体重
     */
    @ApiModelProperty(value = "体重")
    private double weight;

    /**
     * 照片路径
     */
    @ApiModelProperty(value = "图片路径")
    private String image;

    /**
     * 批次(购买这一批雏鸡的时间)
     */
    @ApiModelProperty(value = "批次")
    private String batch;

    /**
     * 预计出笼时间
     */
    @ApiModelProperty(value = "出笼时间")
    private String outTime;

    /**
     * 预购状态（0，正常；1，被预定；-1，已售出）
     */
    @ApiModelProperty(value = "预购状态（0，正常；1，被预定；-1，已售出）")
    private Integer preorderStatus;

    /**
     * 步数类
     */
    private Step Step;


    /**
     * 品种类
     */
    private Price price;

}
