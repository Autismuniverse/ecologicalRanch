package com.ecologicalRanch.stepCounting;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.concurrent.ScheduledExecutorService;




/**
 * ������Ϣ
 * @author 
 *
 */

public class ClientMQTT {  
    public static final String HOST = "tcp://10.12.11.32:1883";  
    public static final String TOPIC1 = "qwe";  
    private static final String clientid = "aeca9180b52b4d6bbb718b6b6f9fbb40";
   // private static JIS jedis;
    public MqttClient client;
    private MqttConnectOptions options;  
    private String userName = "zengyong";    
    private String passWord = "zengyong312";  
    @SuppressWarnings("unused")
    private ScheduledExecutorService scheduler;
    public ClientMQTT()
    {
        try {
            client = new MqttClient(HOST, clientid, new MemoryPersistence());
            options = new MqttConnectOptions();
            options.setCleanSession(true);
            //断开连接时是否清除连接（重连获取以前数据）
            options.setUserName(userName);
            options.setPassword(passWord.toCharArray());
            options.setConnectionTimeout(10);//设置超过时间
            options.setKeepAliveInterval(120);//设置会话心跳时间
            client.setCallback(new PushCallback());
            @SuppressWarnings("unused")
            MqttTopic topic = client.getTopic(TOPIC1);
//����        options.setWill(topic, "close".getBytes(), 2, true);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void publish(MqttTopic topic , MqttMessage message) throws MqttPersistenceException, MqttException {
      MqttDeliveryToken token = topic.publish(message);
      token.waitForCompletion();
   }
    public void start() {
        try {
            while (true) {
                try {
                    if (!client.isConnected()) {
                        client.connect(options);
                    }
                    if (client.isConnected()) {//连接成功，跳出连接
                        break;
                    }
                } catch (MqttException e1) {
                    e1.printStackTrace();
                }
            }
            //订阅消息
            int[] Qos  = {0};
            String[] topic1 = {TOPIC1};
            client.subscribe(topic1, Qos);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            client.unsubscribe(TOPIC1);
            // 断开连接
            client.disconnect();
            // 关闭客户端
            client.close();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
