package com.ecologicalRanch.project.entity;


import lombok.Data;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-31 18:15:45'
 */
@Data
public class Device  {
    /**
     * 设备id
     */

    private Long deviceId;

    /**
     * 设备名
     */

    private String deviceName;

    /**
     * 养殖场id
     */

    private Integer fieldId;

    /**
     * 设备mac地址
     */

    private String deviceMac;

    /**
     * 设备ip地址
     */

    private String deviceIp;



}