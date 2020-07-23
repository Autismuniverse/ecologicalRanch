package com.ecologicalRanch.stepCounting;

import com.ecologicalRanch.config.ApplicationContextProvider;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.concurrent.ScheduledExecutorService;

/**
 * MQTT连接
 */

public class ClientMQTT {

    private Mqtt datasourcePro;
    private MqttClient client;
    private MqttConnectOptions options;

    @SuppressWarnings("unused")
    private ScheduledExecutorService scheduler;

    ClientMQTT() {

        this.datasourcePro = ApplicationContextProvider.getBean(Mqtt.class);
        try {
            client = new MqttClient(datasourcePro.getHOST(), datasourcePro.getClientId(), new MemoryPersistence());
            options = new MqttConnectOptions();
            options.setCleanSession(true);//断开连接时是否清除连接（重连获取以前数据）
            options.setUserName(datasourcePro.getUserName());
            options.setPassword(datasourcePro.getPassWord().toCharArray());
            options.setConnectionTimeout(10);//设置超过时间
            options.setKeepAliveInterval(120);//设置会话心跳时间
            client.setCallback(new PushCallback());

        } catch (Exception e) {
            e.printStackTrace();
        }
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
            String[] topic1 = {datasourcePro.getTOPIC1()};
            client.subscribe(topic1, Qos);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            if(client.isConnected()) {
                client.unsubscribe(datasourcePro.getTOPIC1());
                // 断开连接
                client.disconnect();
                // 关闭客户端
                client.close();
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
