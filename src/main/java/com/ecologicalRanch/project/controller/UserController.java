package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.project.entity.User;
import com.ecologicalRanch.project.result.CommonResult;
import com.ecologicalRanch.project.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
        return CommonResult.success(userService.login(user));
    }
    /**
     * 通过Id查询User
     */
    @ApiOperation("通过Id查询User")
    @GetMapping("/selectUserById/{userId}")
    @ResponseBody
    public CommonResult selectUserById(@PathVariable("userId") Long userId){
        return CommonResult.success(userService.selectUserById(userId));
    }

    /**
     * 新增User
     */
    @ApiOperation("新增User")
    @PostMapping("/insertUser")
    @ResponseBody
    public CommonResult insertUser(@RequestBody User user){
        return CommonResult.success(userService.insertUser(user));
    }

    /**
     * 修改User信息
     */
    @ApiOperation("修改User信息")
    @PostMapping("/updateUser")
    @ResponseBody
    public CommonResult updateUser(User user){
        return CommonResult.success(userService.updateUser(user));
    }

    /**
     * 通过id删除User
     */
    @ApiOperation("通过id删除User")
    @PostMapping("/deleteUserById/{userId}")
    @ResponseBody
    public CommonResult deleteUserById(@PathVariable("userId") Long userId){
        return CommonResult.success(userService.deleteUserById(userId));
    }

    /**
     * 通过id批量删除User
     */
    @ApiOperation("通过id批量删除User")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteUserByIds(String userIds){
        return CommonResult.success(userService.deleteUserByIds(userIds));
    }
}

