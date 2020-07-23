package com.ecologicalRanch.project.controller;


import com.ecologicalRanch.common.pagehelper.CommonPage;
import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.project.entity.Comment;
import com.ecologicalRanch.project.service.CommentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;


/**
 *
 * @author xxxFredYang
 * @date '2020-07-23 14:55:28'
 */
@Controller
@RequestMapping("/app/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;



    /**
     * 查询Comment列表
     */

    @ApiOperation(" 查询Comment列表")
    @PostMapping("/selectCommentList")
    @ResponseBody
    public CommonResult selectCommentList(Comment comment,
                                          @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                          @RequestParam(value = "pageNum",defaultValue = "10",required = false)int pageSize){
        return CommonResult.success(CommonPage.restPage(commentService.selectCommentList(comment,pageNum,pageSize)));
    }

    /**
     * 通过Id查询Comment
     */
    @ApiOperation("通过Id查询Comment")
    @GetMapping("/selectCommentById/{commentId}")
    @ResponseBody
    public CommonResult selectCommentById(@PathVariable("commentId") Long commentId){
        return CommonResult.success(commentService.selectCommentById(commentId));
    }

    /**
     * 新增Comment
     */
    @ApiOperation("新增Comment")
    @PostMapping("/insertComment")
    @ResponseBody
    public CommonResult insertComment(@RequestBody Comment comment){
        return CommonResult.success(commentService.insertComment(comment));
    }

    /**
     * 修改Comment信息
     */
    @ApiOperation("修改Comment信息")
    @PostMapping("/updateComment")
    @ResponseBody
    public CommonResult updateComment(@RequestBody Comment comment){
        return CommonResult.success(commentService.updateComment(comment));
    }

    /**
     * 通过id删除Comment
     */
    @ApiOperation("通过id删除Comment")
    @PostMapping("/deleteCommentById/{commentId}")
    @ResponseBody
    public CommonResult deleteCommentById(@PathVariable("commentId") Long commentId){
        return CommonResult.success(commentService.deleteCommentById(commentId));
    }

    /**
     * 通过id批量删除Comment
     */
    @ApiOperation("通过id批量删除Comment")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteCommentByIds(@NotNull String commentIds){
        return CommonResult.success(commentService.deleteCommentByIds(commentIds));
    }
}
