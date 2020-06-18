package com.ecologicalRanch.stepCounting;

import com.ecologicalRanch.config.ApplicationContextProvider;
import com.ecologicalRanch.redis.service.ISaveRssiService;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;

import java.io.IOException;

public class MessagePacker {

	private ISaveRssiService saveRssiService;

	private  String gateway_mac;
	private static long Data_length;
	public static int Le=56;
	public static double Eaf=3.3;
	public static String[] label_data;

	public MessagePacker(){
		this.saveRssiService = ApplicationContextProvider.getBean(ISaveRssiService.class);
	}

	public boolean dataString(byte[] bs)
    {
		int n;
		try {
//			System.out.println("数据长度"+BytesToHex(bs).length());
			MessageUnpacker unpacker = MessagePack.newDefaultUnpacker(bs);
//			MessageUnpacker unpacker = MessagePack.(bs);
			unpacker.hashCode();
		    unpacker.unpackString();
	       // firmware =
	        unpacker.unpackString();
	        unpacker.unpackString();
			//id=
		    unpacker.unpackInt();
			unpacker.unpackString();
			//up_time=
			unpacker.unpackInt();
			unpacker.unpackString();
			//ip=
			unpacker.unpackString();
			unpacker.unpackString();
			gateway_mac=unpacker.unpackString();
			gateway_mac=insert(gateway_mac);
			unpacker.unpackString();
			Data_length=unpacker.unpackArrayHeader();
			label_data=new String[(int)Data_length];
	    	for (int j = 0; j <Data_length; j++) {
	    		n=unpacker.unpackBinaryHeader();
	    		label_data[j]=bytesToHex(unpacker.readPayload(n));
	    		Label_up(label_data[j]);
			}
		    unpacker.close();
		    return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
    }
	/**
	 * 字节转十六进制
	 * @param bytes
	 * @return
	 */
	public String BytesToHex(byte[] bytes) {
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

	private boolean Label_up(String string){
        string = string.toUpperCase();
        String ladel_mac = null, uuid = null;
        int rssi;
        String str;
        str = string.substring(16, 18);
        long qw = Long.parseLong(str, 16);
        uuid = string.substring(30 + 2 * (int) qw, 62 + 2 * (int) qw);//uuid
        if (uuid.equalsIgnoreCase("FDA50693A4E24FB1AFCFC6EB07647825")) {
            ladel_mac = string.substring(2, 14);//mac
            ladel_mac = insert(ladel_mac);
            str = string.substring(14, 16);//
            rssi = (int) Long.parseLong(str, 16) - 256;
            rssi = Math.abs(rssi);
//			System.out.println("标签："+ladel_mac+"     网关："+gateway_mac+""+"    rssi:"+rssi);

            try {
                saveRssiService.saveRssi(ladel_mac, gateway_mac, Integer.toString(rssi));
            }
            catch (Exception e)
            {
                e.getMessage();
            }


        }
        return false;
	}

    private static String insert(String string) {
    	// TODO Auto-generated method stub
    	String str="";
    	for (int i = 0; i < string.length(); i+=2) {
    		if(i!=0)
    	       str+=":";
			str+=string.substring(i, i+2);
		}
    	return str;
    }

	public String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF).toUpperCase();
            if(hex.length() < 2){
                sb.append(0);
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}

