package com.ecologicalRanch.project.entity;

import lombok.Data;

@Data
public class Admin {

    /**
     * 管理员id
     */

    private long adminId;

    /**
     * 密码
     */

    private String password;

    /**
     * 电话号码
     */

    private String phone;

    /**
     * 权限
     */

    private boolean role;

    /**
     * 登录状态
     */

    private boolean state;

    /**
     * 管理员名字
     */

    private String adminName;
}
