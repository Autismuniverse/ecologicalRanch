package com.ecologicalRanch.project.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-27 16:48:59'
 */
@Data
public class Admin {

    /**
     * 管理员id
     */

    private long adminId;

    /**
     * 密码
     */
    @Length(min = 8)
    private String password;

    /**
     * 电话号码
     */
    @Pattern(regexp = "^[1][3,4,5,7,8][0-9]{9}$",message = "请输入正确的电话号码")

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
