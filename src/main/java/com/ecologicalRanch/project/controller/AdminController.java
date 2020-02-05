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
    public JSONResult login(@RequestBody Admin admin){ return JSONResult.ok(adminService.login(admin)); }

}

