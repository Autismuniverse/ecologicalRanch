package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.Admin;
import com.ecologicalRanch.project.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags = "管理员")
@RestController
@RequestMapping("/admin")
//@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 查询所有管理员信息
     * @return admin对象集
     */
    @ApiOperation("查询所有管理员信息")
    @GetMapping("queryAll")
    public CommonResult queryAll(){ return CommonResult.success(adminService.queryAll());}

    /**
     * 通过管理员id查询管理员信息
     * @param adminId 管理员id
     * @return admin对象
     */
    @ApiOperation(value = "通过adminID查询管理员信息",notes = "adminId")
    @GetMapping("selectById/{adminId}")
    public CommonResult selectById(@PathVariable Long adminId) { return CommonResult.success((adminService.selectById(adminId)));}

    /**
     * 登录
     * @param admin 对象
     * @return admin对象
     */
    @ApiOperation(value = "登录",notes = "userId,password")
    @PostMapping("login/")
    public CommonResult login(@RequestBody Admin admin){
        return CommonResult.success(adminService.login(admin)); }

}

