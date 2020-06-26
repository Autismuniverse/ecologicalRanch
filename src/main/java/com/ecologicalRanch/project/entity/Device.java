package com.ecologicalRanch.project.entity;


import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
    @NotNull(message = "不能为空",groups = {wechat.class})
    private String deviceName;

    /**
     * 养殖场id
     */

    private Long fieldId;

    /**
     * 设备mac地址
     */

    @Pattern(regexp = "/^[A-F0-9]{2}(:[A-F0-9]{2}){5}$/",message = "mac地址有误")
    private String deviceMac;

    /**
     * 设备ip地址
     */

    private String deviceIp;



}