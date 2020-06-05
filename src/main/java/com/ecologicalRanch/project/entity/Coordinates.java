package com.ecologicalRanch.project.entity;

import lombok.Data;

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
