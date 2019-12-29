package com.ecologicalRanch.bluetooth;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.concurrent.ScheduledExecutorService;

/**
 * ģ��һ���ͻ��˽�����Ϣ
 * @author rag
 *
 */
public class ClientMQTT {  
    public static final String HOST = "tcp://10.12.10.241:1883";  
    public static final String TOPIC1 = "qwe";  
    private static final String clientid = "client11";  
    private MqttClient client;  
    private MqttConnectOptions options;  
    private String userName = "zengyong";    
    private String passWord = "zengyong312";  
    @SuppressWarnings("unused")
    private ScheduledExecutorService scheduler;  
    public void start() {
        try {
            client = new MqttClient(HOST, clientid, new MemoryPersistence());

            options = new MqttConnectOptions();  
            options.setCleanSession(false);
            options.setUserName(userName);
            options.setPassword(passWord.toCharArray());
            options.setConnectionTimeout(10);
            options.setKeepAliveInterval(20);
            client.setCallback(new PushCallback());
           
            MqttTopic topic = client.getTopic(TOPIC1);  
             client.connect(options);
            int[] Qos  = {1};
            String[] topic1 = {TOPIC1};  
            client.subscribe(topic1, Qos);  

        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  

//    public static void main(String[] args) throws MqttException {
//        ClientMQTT client = new ClientMQTT();
//        client.start();
//    }


}  
