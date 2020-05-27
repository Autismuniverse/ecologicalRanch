package com.ecologicalRanch.project.entity;

import lombok.Data;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-26 16:01:07'
 */
@Data
public class Device  {
    /**
     * 蓝牙ID
     */

    private String bluetoothId;

    /**
     * rfid
     */

    private String rfidId;

    /**
     * 养殖场id
     */

    private Long fieldId;

    /**
     * 蓝牙电量
     */

    private Integer power;



}