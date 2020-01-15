package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.project.entity.Admin;
import com.ecologicalRanch.project.service.IAdminService;
import com.ecologicalRanch.utils2.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(tags = "管理员")
@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Resource
    private IAdminService adminService;

    /**
     * 查询所有管理员信息
     * @return admin对象集
     */
    @ApiOperation("查询所有管理员信息")
    @GetMapping("queryAll")
    public JSONResult queryAll(){ return JSONResult.ok(adminService.queryAll());}

    /**
     * 通过管理员id查询管理员信息
     * @param adminId 管理员id
     * @return admin对象
     */
    @ApiOperation(value = "通过adminID查询管理员信息",notes = "adminId")
    @PostMapping("selectById/{adminId}")
    public JSONResult selectById(@PathVariable("adminId") long adminId) { return JSONResult.ok(adminService.selectById(adminId));}

    /**
     * 登录
     * @param admin 对象
     * @return admin对象
     */
    @ApiOperation(value = "登录",notes = "userId,password")
    @PostMapping("login/")
    @ResponseBody
    public JSONResult login(Admin admin){ return JSONResult.ok(adminService.login(admin)); }

    //public String openid="o_JIB5U6B0th388-RCa3T95iwiqE";
    /**
     * openid
     * @param code 对象
     * @return openid对象
     */
//    @ApiOperation(value = "we登录",notes = "openid")
//    @PostMapping("openid")
//    public JSONResult welogin(String code) {return JSONResult.ok(this.openid); }


//    @RestController
//    public class LoginHandler {
//
//        private String appID = "wx4bd8b4a9b1e3c26e";
//        private String appSecret = "bfffc7550da959acf43dc02013585b0d";
//
//        @PostMapping("/we/login")
//        public String userLogin(@RequestParam("code") String code) throws IOException {
//            String result = "";
//            try{//请求微信服务器，用code换取openid。HttpUtil是工具类，后面会给出实现，Configure类是小程序配置信息，后面会给出代码
//                result = HttpUtil.doGet(
//                        "https://api.weixin.qq.com/sns/jscode2session?appid="
//                                + this.appID + "&secret="
//                                + this.appSecret + "&js_code="
//                                + code
//                                + "&grant_type=authorization_code", null);
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//            }
//            ObjectMapper mapper = new ObjectMapper();
//            OpenIdJson openIdJson = mapper.readValue(result,OpenIdJson.class);
//            System.out.println(result.toString());
//            System.out.println(openIdJson.getOpenid());
//            return result;
//        }
//
//    }
}

