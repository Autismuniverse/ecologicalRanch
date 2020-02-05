package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.Follow;
import com.ecologicalRanch.project.service.FollowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



/**
 *
 *
 * @author u-fun
 * @date '2020-01-19 18:10:04'
 */
@Api(tags = "关注")
@Controller
@RequestMapping("/app/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    /**
     * 查询Follow列表
     */
    @ApiOperation(" 查询Follow列表")
    @PostMapping("/selectFollowList")
    @ResponseBody
    public CommonResult selectFollowList(@RequestBody Follow follow,
                                         @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                         @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize){
        return CommonResult.success(CommonPage.restPage(followService.selectFollowList(follow,pageNum,pageSize)));
    }



    /**
     * 新增Follow
     */
    @ApiOperation("新增Follow")
    @PostMapping("/insertFollow")
    @ResponseBody
    public CommonResult insertFollow(@RequestBody Follow follow){
        return CommonResult.success(followService.insertFollow(follow));
    }



    /**
     * 删除Follow
     */
    @ApiOperation("删除Follow")
    @PostMapping("/deleteFollow")
    @ResponseBody
    public CommonResult deleteFollow(@RequestBody Follow follow){
        return CommonResult.success(followService.deleteFollow(follow));
    }

    /**
     * 通过id批量删除Follow
     */
    @ApiOperation("通过id批量删除Follow")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteFollowByIds(String userIds){
        return CommonResult.success(followService.deleteFollowByIds(userIds));
    }
}
