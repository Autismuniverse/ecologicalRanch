package com.ecologicalRanch.stepCounting;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * ������Ϣ�Ļص���
 *
 */
@Slf4j
public class PushCallback implements MqttCallback {
	@SneakyThrows
	public void connectionLost(Throwable cause) {
		try {
			System.out.println("MQTT重连");
			Thread.sleep(1000);
			MqttLoadServer.mqttReceiveTest.stop();//关闭
			Thread.sleep(2000);
			MqttLoadServer.mqttReceiveTest.start();//重新连接
		}
		catch (Exception e) {
			MqttLoadServer.mqttReceiveTest.stop();//关闭
			ProgramStart.setState(false);
			e.printStackTrace();
		}
    }

    public void deliveryComplete(IMqttDeliveryToken token) {
		System.out.println("MQTT断开");
    }
    @SuppressWarnings("static-access")
	public void messageArrived(String topic, MqttMessage message) {
		byte[] data;
		try {
			data = message.getPayload();
			if (data[0] == -122 && data.length > 150) {
				ProgramStart.AppThread(data);
			}
		}
		catch (Exception e)
		{
			log.error("获取数据："+e.toString());
		}
    }


}
