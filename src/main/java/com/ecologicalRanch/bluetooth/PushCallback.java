package com.ecologicalRanch.bluetooth;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.sql.SQLException;

/** 
 * ������Ϣ�Ļص��� 
 * 
 * ����ʵ��MqttCallback�Ľӿڲ�ʵ�ֶ�Ӧ����ؽӿڷ���CallBack �ཫʵ�� MqttCallBack�� 
 * ÿ���ͻ�����ʶ����Ҫһ���ص�ʵ�����ڴ�ʾ���У����캯�����ݿͻ�����ʶ�����Ϊʵ�����ݡ� 
 * �ڻص��У�����������ʶ�Ѿ������˸ûص����ĸ�ʵ���� 
 * �����ڻص�����ʵ������������ 
 * 
 *  public void messageArrived(MqttTopic topic, MqttMessage message)�����Ѿ�Ԥ���ķ����� 
 * 
 *  public void connectionLost(Throwable cause)�ڶϿ�����ʱ���á� 
 * 
 *  public void deliveryComplete(MqttDeliveryToken token)) 
 *  ���յ��Ѿ������� QoS 1 �� QoS 2 ��Ϣ�Ĵ�������ʱ���á� 
 *  �� MqttClient.connect ����˻ص��� 
 * 
 */  
public class PushCallback implements MqttCallback { 
	private static Sql sql;
	public int gatewayId=1;
	private static int Le=50;//һ�׵�rssiֵ�ľ���ֵ
	private static double Eaf=3.5; //����˥������
	
	public void connectionLost(Throwable cause) {  //�Ͽ��¼�
        // ���Ӷ�ʧ��һ�����������������  
        System.out.println("���ӶϿ�������������");  
    }  

    public void deliveryComplete(IMqttDeliveryToken token) {  //���ͳɹ�
        System.out.println("deliveryComplete---------" + token.isComplete());  
    }  

    public void messageArrived(String topic, MqttMessage message) throws Exception {  
        // subscribe��õ�����Ϣ��ִ�е�������  
    	String str=bytesToHex(message.getPayload());
    	str=str.toUpperCase();
        System.out.println("������Ϣ���� : " + topic);  
        System.out.println("������ϢQos : " + message.getQos());  
        System.out.println("������Ϣ���� : " + str); //new String(message.getPayload())
        if(str.length()>81)
          Storage_Gateway(str);
    }  
    //�ֽ�תʮ������
    
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
    //���������ϴ�
    public void Storage_Gateway(String hex) {
    	String num_1=null,num_2=null,num_3=null,num_4=null,num_5=null,num_6=null;
    	String str="";
    	int n;
    	//hex.indexOf("a2");
    	try {
    		for (int i = 0,j=4; j < hex.length(); i++,j++) {

			    str=hex.substring(i,j);
			    if(str.equalsIgnoreCase("c426")||str.equalsIgnoreCase("C426"))
			    {
			    	str=hex.substring(0,i);
			        break;
			    }
		    }
    		num_1=str.substring(8,24);
    		num_1=hexStringToString(num_1);//�̼��汾
    		num_3=str.substring(70,str.length()-52);
    		num_3=hexStringToString(num_3);//IP
    		num_4=str.substring(str.length()-42,str.length()-18);
    		num_4=hexStringToString(num_4);//mac
    		num_4=insert(num_4);
    		num_5=str.substring(str.length()-2,str.length());
    		long qw=Long.parseLong(num_5,16);//����
    		num_2=String.valueOf(hex.length());//����
    		num_6=hex.substring(str.length()+4);
    		Storage_Modular(num_6);
//    		sql=new Sql();
//    		sql.Console();
    		//sql.insertTimeData("insert into Bluetooth_Gateway(ip,mac,data,Data_quantity)values('" + num_3  + "','"+num_4 +"',"+(int)qw+",'"+num_2+ "')");
            //���ݿ����
//            sql.close();
		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			System.out.print("ʧ��");
		}
    	
		
	}
    //��ǩ���ݲ��
    public void Storage_Modular(String hex) {
    	String str;
    	int m=0;
    	for (int i = 0,j=4; j < hex.length(); i++,j++) {
		    str=hex.substring(i,j); 
		    if(str.equalsIgnoreCase("c426"))
		    {
		    	Analysis(hex.substring(m,i));
		    	m=i+4;
		    }
	    }

	}
    
    private void Analysis(String string) {
		// TODO ��ǩ���ݷ���
    	String num_1 ,num_2,num_3;
    	int a;
		String str;
		str=string.substring(16, 18);
		long qw=Long.parseLong(str,16);
//		str=string.substring(22+2*(int)qw,30+2*(int)qw);
//		if(str.equalsIgnoreCase("4c000215"))
		num_2=string.substring(30+2*(int)qw, 62+2*(int)qw);//uuid
		if(num_2.equalsIgnoreCase("FDA50693A4E24FB1AFCFC6EB07647825"))
		{
			num_1=string.substring(2, 14);//mac
			num_1=insert(num_1);
			//num_3=string.substring(string.length()-2, string.length());//
			str=string.substring(14,16);
			a=(int)Long.parseLong(str,16)-256;
			num_3=Float.toString(Count(a));
    		try {
    			sql=new Sql();
    			sql.Console();
//    			sql.insertTimeData("insert into localtioninfo(mac,rssi,uuid,data)values('" + num_1 + "',"+a+",'" + num_2  + "','"+num_3 +"')");
				sql.insertTimeData("insert into localtioninfo(rssi,Bluetooth_id,gatway_number)values('"+a+"',"+ gatewayId++ +","+gatewayId+")");

				sql.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
    /**
     * nihao
     * @param rssi
     * @return
     */
    public static float Count(int rssi)
    {
    	float n;
        n=(float)Math.abs(rssi);
        n=(float) ((n-Le)/(10*Eaf));
    	n=(float) Math.pow(10,n);
    	n+=0.005;
    	n*=100;
    	n=(int)n;
    	n=(float)n/100;
    	return n;	
    }

	//Ϊmac��ַ���'"'
    private static String insert(String string) {
    	// TODO Auto-generated method stub
    	String str="";
    	for (int i = 0; i < string.length()-2; i+=2) {
    		if(i!=0)
    	       str+=":";
			str+=string.substring(i, i+2);
		}
    	return str;
    }
    //ʮ������ת�ַ�
    public static String hexStringToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "UTF-8");
            new String();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

}  