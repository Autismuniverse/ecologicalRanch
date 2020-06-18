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
		MqttLoadServer.mqttReceiveTest.stop();//关闭
		MqttLoadServer.mqttReceiveTest.start();//重新连接
    }

    public void deliveryComplete(IMqttDeliveryToken token) {
		System.out.println("MQTT连接成功");
    }
    @SuppressWarnings("static-access")
	public void messageArrived(String topic, MqttMessage message) throws Exception {
        // subscribe��õ�����Ϣ��ִ�е�������
    	String str=bytesToHex(message.getPayload());
    	str=str.toUpperCase();
        byte[] data_1=new byte[message.getPayload().length];
       	data_1=message.getPayload();
       	if(data_1[0]>=-128&&data_1[0]<=-113)
       	{
        	str=str.substring(0,Seek(str,"C426"));
        	byte[] data_2=new byte[data_1.length-1];
        	for(int i=0;i<data_2.length;i++)
        		data_2[i]=data_1[i+1];
        	me.dataString(data_2);
       	}
    }
    /**
     * �ֽ�תʮ������
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if(hex.length() < 2){
                sb.append(0);
            }
            sb.append(hex);
        }
        return sb.toString();
    }
    /**
     * �����ض����ݵ�λ��
     * @param hex �����ҵ�����
     * @param content  �ض�����
     * @return
     */
    private static int Seek(String hex,String content)
    {
    	String str=null;
    	for (int i = 0,j=content.length(); j < hex.length(); i++,j++)
    	{
    	    str=hex.substring(i,j);
    	    if(str.equalsIgnoreCase(content))
    	    {
    	    	str=hex.substring(0,i);
    	        return i;
    	    }
        }
    	return 0;

    }
}
