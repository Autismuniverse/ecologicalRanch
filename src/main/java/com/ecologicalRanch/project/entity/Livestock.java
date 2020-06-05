package com.ecologicalRanch.project.entity;

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

    private Long livestockId;

    /**
     * 牲畜场id
     */

    private Integer fieldId;

    /**
     * 步数表ID
     */

    private String stepNum;

    /**
     * 蓝牙ID
     */

    private String bluetoothId;

    /**
     * RFID_id
     */

    private String rfidId;

    /**
     *
     */

    private Object sex;

    /**
     * 牲畜的种类
     */

    private String species;

    /**
     * 体重
     */

    private double weight;



    /**
     * 批次(购买这一批雏鸡的时间)
     */

    private String batch;

    /**
     * 预计出笼时间
     */

    private String outTime;

    /**
     * 预购状态（0，正常；1，被预定；-1，已售出）
     */

    private Integer status;

    /**
     * 鸡的品种
     */
    private String type;







}
