package com.ecologicalRanch.project.controller;

import com.ecologicalRanch.common.result.CommonResult;
import com.ecologicalRanch.common.utils.UploadPic;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-26 18:55:17'
 */
@Api(tags = "上传文件")
@Controller
@RequestMapping("/app/order")
public class PictureUpload {

    /**
     * 上传图片
     */
    @ApiOperation("上传图片")
    @PostMapping("/PictureUpload")
    @ResponseBody
    public CommonResult Upload(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response){
            UploadPic uploadPic = new UploadPic();
            try {
                uploadPic.upload(file,request,response);
                return CommonResult.success(uploadPic.getPath(),"上传成功");
            }catch (Exception e){
                e.getMessage();
                return CommonResult.failed("上传失败");
            }
    }
}
