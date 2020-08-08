package com.ecologicalRanch.common.utils;


import com.ecologicalRanch.config.ApplicationContextProvider;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Data

public class UploadPic {


    private String path;
    private Upload upload;




    public Map<String,Object> upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {
        this. upload= ApplicationContextProvider.getBean(Upload.class);
        String fileName = file.getOriginalFilename();
        String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() ;//存储路径

        String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
        fileName = new Date().getTime() + "_" + new Random().nextInt(1000) + fileF;//新的文件名
        Map<String, Object> map = new HashMap<>();


        //先判断文件是否存在
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //获取文件夹路径
        File file1 = new File(upload.getUpload());
//        System.out.println(upload.getUpload());

        //将图片存入文件夹
        File targetFile = new File(file1, fileName);
        try {
            //将上传的文件写到服务器上指定的文件。
            file.transferTo(targetFile);
            this.setPath( returnUrl+ "/" + fileName);
            map.put("code", 1);
            map.put("message", "图片上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 0);
            map.put("message", "系统异常，图片上传失败");
        }
        return map;
    }

}
