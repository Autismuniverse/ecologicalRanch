package com.ecologicalRanch.project.entity;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.Date;

//import com.fun.framework.web.entity.BaseEntity;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-18 13:29:26'
 */
@Data
public class User  {
    /**
     * 用户ID
     */

    private Long userId;

    /**
     * 用户密码
     */

    private String userPwd;

    /**
     * 用户名
     */

    private String username;

    /**
     *
     */

    private Object sex;

    /**
     * 电话号码
     */
    @Pattern(regexp = "^[1][3,4,5,7,8][0-9]{9}$",message = "请输入正确的电话号码")
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 出生日期
     */

    private String birthday;

    /**
     * 邮箱
     */

    private String email;

    /**
     * 微信号(open_id)
     */

    private String openId;

    /**
     * 头像存储路径
     */

    private String headPortrait;

    /**
     * 创建时间
     */

    private Date creatTime;

    /**
     * 登录状态（未登录：0；已登录：1）
     */

    private Integer state;


}