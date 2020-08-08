package com.ecologicalRanch.common.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;



@Component
@ConfigurationProperties(prefix = "frame")
@Data
public class Upload {

//    @Value("${frame.upload}")
    private String upload;

//    @Value("${mqtt.HOST}")
//    private String HOST;




}
