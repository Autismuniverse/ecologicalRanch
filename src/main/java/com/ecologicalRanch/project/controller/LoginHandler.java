package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.project.result.CommonResult;
import com.ecologicalRanch.utils2.HttpUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
@Api(tags = "微信登录")
@RestController
public class LoginHandler {

    private String appID = "wx4bd8b4a9b1e3c26e";
    private String appSecret = "bfffc7550da959acf43dc02013585b0d";

    @PostMapping("/we/login")

    public CommonResult userLogin(@RequestBody String code) throws IOException {
        String result = "";
        String str = code;

        //判断第一个字符是否为“{”
        if (str.startsWith("{")) {
            str = str.substring(1);
        }

        //判断最后一个字符是否为“}”
        if (str.endsWith("}")) {
            str = str.substring(0,str.length() - 1);
        }

        String str1 = str.replaceAll("\"", "");
        String str2 = str1.replaceAll("code:", "");
        try{//请求微信服务器，用code换取openid。HttpUtil是工具类，后面会给出实现，Configure类是小程序配置信息，后面会给出代码
            result = HttpUtil.doGet(
                    "https://api.weixin.qq.com/sns/jscode2session?appid="
                            + appID + "&secret="
                            + appSecret + "&js_code="
                            + str2
                            + "&grant_type=authorization_code", null
                            );
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("https://api.weixin.qq.com/sns/jscode2session?appid="
                + appID + "&secret="
                + appSecret + "&js_code="
                + str2
                + "&grant_type=authorization_code");

        return CommonResult.success(result);
    }

}
