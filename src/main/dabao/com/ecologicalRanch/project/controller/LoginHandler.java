package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.project.result.CommonResult;
import com.ecologicalRanch.utils2.HttpUtil;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "微信登录")
@RestController
@Log4j2
public class LoginHandler {

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
            System.out.println(
                    "https://api.weixin.qq.com/sns/jscode2session?appid="
                            + appID + "&secret="
                            + appSecret + "&js_code="
                            + code
                            + "&grant_type=authorization_code"
            );

            return CommonResult.success(HttpUtil.doGet(
                "https://api.weixin.qq.com/sns/jscode2session?appid="
                        + appID + "&secret="
                        + appSecret + "&js_code="
                        + code
                        + "&grant_type=authorization_code", null
            ));
        } catch (Exception e) {
            log.error(e.toString());
            return CommonResult.failed();
        }
    }

}
