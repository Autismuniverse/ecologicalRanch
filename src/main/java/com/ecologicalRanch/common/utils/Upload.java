package com.ecologicalRanch.common.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * 读取yaml中的上传路径实体类
 */
@Component
@ConfigurationProperties(prefix = "frame")
@Data
public class Upload {

//    @Value("${frame.upload}")
    private String upload;
}
