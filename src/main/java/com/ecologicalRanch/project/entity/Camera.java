package com.ecologicalRanch.project.entity;

import lombok.Data;

import javax.validation.constraints.Pattern;

/**
 *
 *
 * @author u-fun
 * @date '2020-07-20 16:11:14'
 */
@Data
public class Camera {
    /**
     * 摄像头id
     */

    private Integer cameraId;

    /**
     * 摄像头ip
     */
    @Pattern(regexp = "^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$")
    private String cameraIp;

    /**
     * 摄像头mac地址
     */
    @Pattern(regexp = "^([0-9a-fA-F]{2})(([/\\s:][0-9a-fA-F]{2}){5})$",message = "mac地址有误")
    private String cameraMac;

    /**
     * 转码后视频流
     */

    private String streaming;

    /**
     * 养殖场id
     */

    private Long fieldId;


}