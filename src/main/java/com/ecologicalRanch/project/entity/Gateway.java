package com.ecologicalRanch.project.entity;

import lombok.Data;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-27 14:54:24'
 */
@Data
public class Gateway {
    /**
     * 网关id
     */

    private Long gatewayId;

    /**
     * 网关mac地址
     */

    private String mac;

    /**
     * x轴坐标
     */

    private Integer coordinateX;

    /**
     * y轴坐标
     */

    private Integer coordinateY;

    /**
     * 设备id
     */

    private String deviceId;



}
