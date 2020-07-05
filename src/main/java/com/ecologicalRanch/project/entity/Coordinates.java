package com.ecologicalRanch.project.entity;

import lombok.Data;

import javax.validation.constraints.Pattern;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-28 14:32:02'
 */
@Data
public class Coordinates   {
    /**
     * 蓝牙id
     */

    private String bluetoothId;

    /**
     * 蓝牙mac地址
     */
    @Pattern(regexp = "^([0-9a-fA-F]{2})(([/\\s:][0-9a-fA-F]{2}){5})$",message = "mac地址有误")
    private String bluetoothMac;

    /**
     * 蓝牙x轴的坐标距离
     */

    private Integer coordinateX;

    /**
     * 蓝牙y轴的坐标距离
     */

    private Integer coordinateY;

    /**
     * 设备id
     */

    private String deviceId;


}
