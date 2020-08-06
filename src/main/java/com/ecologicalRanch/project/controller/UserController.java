package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.project.entity.User;
import com.ecologicalRanch.project.result.CommonResult;
import com.ecologicalRanch.project.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//import com.fun.common.result.CommonResult;
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//import java.util.Map;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-18 13:29:26'
 */
@Api(tags = "用户")
@Controller
@RequestMapping("/app/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

//    /**
//     * 查询User列表
//     */
//    @ApiOperation(" 查询User列表")
//    @PostMapping("/selectUserList")
//    @ResponseBody
//    public CommonResult selectUserList(User user,
//                                       @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
//                                       @RequestParam(value = "pageNum",defaultValue = "10",required = false)int pageSize){
//        return CommonResult.success(CommonPage.restPage(userService.selectUserList(user,pageNum,pageSize)));
//    }
    /**
     * 登录
     */
    @ApiOperation("登录")
    @PostMapping("/userLogin")
    @ResponseBody
    public CommonResult login(@RequestBody User user ){
        if(userService.login(user)!=null){
            return CommonResult.success("登录成功");
        }
        return CommonResult.failed("账号或密码错误");
    }
    /**
     * 通过Id查询User
     */
    @ApiOperation("通过Id查询User")
    @GetMapping("/selectUserById/{userId}")
    @ResponseBody
    public CommonResult selectUserById(@PathVariable("userId") Long userId){
        try{
            return CommonResult.success(userService.selectUserById(userId));
        }catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed(e.toString());
        }
    }

    /**
     * 新增User
     */
    @ApiOperation("新增User")
    @PostMapping("/insertUser")
    @ResponseBody
    public CommonResult insertUser(@RequestBody User user){
        try{
            return CommonResult.success(userService.insertUser(user));
        }catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed(e.toString());
        }
    }

    /**
     * 修改User信息
     */
    @ApiOperation("修改User信息")
    @PostMapping("/updateUser")
    @ResponseBody
    public CommonResult updateUser(@RequestBody User user){
        try{
            return CommonResult.success(userService.updateUser(user));
        }catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed(e.toString());
        }
    }

    /**
     * 通过id删除User
     */
    @ApiOperation("通过id删除User")
    @PostMapping("/deleteUserById/{userId}")
    @ResponseBody
    public CommonResult deleteUserById(@PathVariable("userId") Long userId){
        try{
            return CommonResult.success(userService.deleteUserById(userId));
        }catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed(e.toString());
        }
    }

    /**
     * 通过id批量删除User
     */
    @ApiOperation("通过id批量删除User")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteUserByIds(String userIds){
        try{
            return CommonResult.success(userService.deleteUserByIds(userIds));
        }catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed(e.toString());
        }
    }
}

