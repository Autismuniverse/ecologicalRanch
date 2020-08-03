package com.ecologicalRanch;


import com.alibaba.fastjson.JSONObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.ecologicalRanch.project.mapper")
@EnableSwagger2
@EnableConfigurationProperties
@EnableScheduling
public class ecologicalRanchApplication extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        JSONObject js = new JSONObject();
        SpringApplication.run(ecologicalRanchApplication.class, args);
    }

    @Override
    //重写父类提供的跨域请求处理的接口
    public void addCorsMappings(CorsRegistry registry) {
        //添加映射路径
        registry.addMapping("/**")
                //是否发送Cookie信息
                .allowCredentials(true)
                //放行哪些原始域头部信息
                .allowedHeaders("*")
                //放行哪些原始域（如：”http://admin.com”）
                .allowedOrigins("*")
                //放行哪些原始域请求方式( 如：”GET,POST”)
                .allowedMethods("*");
    }
}
