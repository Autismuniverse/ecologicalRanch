package com.ecologicalRanch.stepCounting;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "mqtt")
@Component
@Data
public class Mqtt {
    @Value("${mqtt.HOST}")
    private String HOST ;
    @Value("${mqtt.TOPIC1}")
    private String TOPIC1;
    @Value("${mqtt.clientId}")
    private String clientId ;
    @Value("${mqtt.userName}")
    private String userName ;
    @Value("${mqtt.passWord}")
    private String passWord ;

//    public String getHOST() {
//        return HOST;
//    }
//    public void setHOST(String HOST) {
//        this.HOST = HOST;
//    }
//    public String getTOPIC1() {
//        return TOPIC1;
//    }
//    public void setTOPIC1(String TOPIC1) {
//        this.TOPIC1 = TOPIC1;
//    }
//    public String getclientid() {
//        return clientid;
//    }
//    public void setclientid(String clientid) {
//        this.clientid = clientid;
//    }
//    public String getuserName() {
//        return userName;
//    }
//    public void setuserName(String userName) {
//        this.userName = userName;
//    }
//    public String getpassWord() {
//        return passWord;
//    }
//    public void setpassWord(String passWord) {
//        this.passWord = passWord;
//    }
}
