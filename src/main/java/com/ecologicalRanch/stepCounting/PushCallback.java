package com.ecologicalRanch.stepCounting;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * ������Ϣ�Ļص���
 *
 */
public class PushCallback implements MqttCallback {
	private static MessagePacker me=new MessagePacker();
	public void connectionLost(Throwable cause) {
		try {
			Thread.sleep(1000);
			MqttLoadServer.mqttReceiveTest.stop();//关闭
			Thread.sleep(2000);
			MqttLoadServer.mqttReceiveTest.start();//重新连接
		}
		catch (Exception e) {
			MqttLoadServer.mqttReceiveTest.stop();//关闭
			e.printStackTrace();
		}
    }

    public void deliveryComplete(IMqttDeliveryToken token) {
		System.out.println("MQTT连接成功");
    }
    @SuppressWarnings("static-access")
	public void messageArrived(String topic, MqttMessage message) throws Exception {
        // subscribe��õ�����Ϣ��ִ�е�������
        byte[] data_1;
       	data_1=message.getPayload();
		if(data_1[0]==-122&&data_1.length>150) {
			byte[] data_2 = new byte[data_1.length - 1];
			for (int i = 0; i < data_2.length; i++)
				data_2[i] = data_1[i + 1];
			try {
				me.dataString(data_2);
			} catch (Exception e) {
				e.getMessage();
			}
		}
    }


}
