package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.Admin;
import com.ecologicalRanch.project.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags = "管理员")
@RestController
@RequestMapping("/admin")
//@CrossOrigin
@Slf4j
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 查询所有管理员信息
     * @return admin对象集
     */
    @ApiOperation("查询所有管理员信息")
    @GetMapping("queryAll")
    public CommonResult queryAll(){

        return CommonResult.success(adminService.queryAll());
    }

    /**
     * 通过管理员id查询管理员信息
     * @param adminId 管理员id
     * @return admin对象
     */
    @ApiOperation(value = "通过adminID查询管理员信息",notes = "adminId")
    @GetMapping("selectById/{adminId}")
    public CommonResult selectById(@PathVariable Long adminId) {
        try{
            return CommonResult.success((adminService.selectById(adminId)));
        }
        catch (Exception e){
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }

    /**
     * 登录
     * @param admin 对象
     * @return admin对象
     */
//    @ApiOperation(value = "登录",notes = "userId,password")
    @PostMapping("login/")
    public CommonResult login(@RequestBody Admin admin){
        try{return CommonResult.success(adminService.login(admin)); }
        catch (Exception e){
        return CommonResult.failed("未知错误");
    }
    }

    /**
     * 新增管理员
     * @param admin 对象
     * @return int对象
     */
    @ApiOperation(value = "插入")
    @PostMapping("insert/")
    public CommonResult insert(@RequestBody Admin admin){
        try{
            return CommonResult.success(adminService.insertAdmin(admin));
        }
        catch (Exception e){
            log.error(e.getMessage());
            return CommonResult.failed("未知错误");
        }
    }

}

