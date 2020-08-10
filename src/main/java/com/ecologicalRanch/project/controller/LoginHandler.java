package com.ecologicalRanch.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecologicalRanch.project.entity.User;
import com.ecologicalRanch.project.result.CommonResult;
import com.ecologicalRanch.project.service.UserService;
import com.ecologicalRanch.utils2.HttpUtil;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "微信登录")
@RestController
@Log4j2
public class LoginHandler {

    private String sig;


    @Autowired
    private UserService userService;

    private String appID = "wx4bd8b4a9b1e3c26e";
    private String appSecret = "bfffc7550da959acf43dc02013585b0d";



    @GetMapping("/we/login")
    public CommonResult userLogin(@RequestParam String code) {
//        System.out.println(code);

        //判断第一个字符是否为“{”
        if (code.startsWith("{")) {
            code = code.substring(1);
        }

        //判断最后一个字符是否为“}”
        if (code.endsWith("}")) {
            code = code.substring(0, code.length() - 1);
        }

        String str1 = code.replaceAll("\"", "");
        String str2 = str1.replaceAll("code:", "");

        try {//请求微信服务器，用code换取openid。HttpUtil是工具类，后面会给出实现，Configure类是小程序配置信息，后面会给出代码

            String reslut= HttpUtil.doGet(
                    "https://api.weixin.qq.com/sns/jscode2session?appid="
                            + appID + "&secret="
                            + appSecret + "&js_code="
                            + code
                            + "&grant_type=authorization_code",null
            );
//            System.out.println(reslut);

            JSONObject jsonObject =JSONObject.parseObject(reslut);

//            System.out.println(jsonObject.getString("openid"));


            if (userService.selectUserByOpenId(jsonObject.getString("openid")) != null){
            return CommonResult.success(userService.selectUserByOpenId(jsonObject.getString("openid")));
            }

            else{
                User user = new User();
                user.setOpenId(jsonObject.getString("openid"));
                System.out.println(user);
                userService.weinsertUser(user);
                return CommonResult.success(userService.selectUserByOpenId(jsonObject.getString("openid")));
            }




        } catch (Exception e) {
            log.error(e.toString());
            return CommonResult.failed();
        }
    }

}
