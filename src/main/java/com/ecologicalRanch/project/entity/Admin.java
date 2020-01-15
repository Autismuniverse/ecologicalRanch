package com.ecologicalRanch.project.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Admin {

    /**
     * 管理员id
     */
    @ApiModelProperty(value = "管理员id")
    private long adminId;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 电话号码
     */
    @ApiModelProperty(value = "电话号码")
    private String phone;

    /**
     * 权限
     */
    @ApiModelProperty(value = "权限")
    private boolean role;

    /**
     * 登录状态
     */
    @ApiModelProperty(value = "登录状态")
    private boolean state;
}
