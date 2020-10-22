package com.ecologicalRanch.stepCounting;

import com.ecologicalRanch.config.ApplicationContextProvider;
import com.ecologicalRanch.redis.service.ISaveRssiService;
import lombok.extern.slf4j.Slf4j;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;

/**
 * MessagePacker数据类型解析
 */
@Slf4j
public class MessagePacker extends Thread {

	private ISaveRssiService saveRssiService;
//	private MessagePack messagepack;
	private  String gateway_mac;
	private static long Data_length;
	private static byte[] bs;

	public MessagePacker(byte[] b){
		this.saveRssiService = ApplicationContextProvider.getBean(ISaveRssiService.class);
//		this.messagepack=ApplicationContextProvider.getBean(MessagePack.class);
		this.bs=b;
	}
	@Override
	public void run() {
		try {
			MessageUnpacker unpacker = MessagePack.newDefaultUnpacker(bs);
//			MessageUnpacker unpacker = messagepack.newDefaultUnpacker(bs);
			int n=unpacker.unpackMapHeader();
			for(int i=0;i<n;i++) {
				switch (unpacker.unpackString()) {
					case "v":    unpacker.unpackString(); break;
					case "mid":  unpacker.unpackInt();    break;
					case "time": unpacker.unpackInt();    break;
					case "ip":   unpacker.unpackString(); break;
					case "mac":  gateway_mac=insert(unpacker.unpackString());break;
					case "devices": {
						Data_length = unpacker.unpackArrayHeader();
						if (Data_length >= 1)
							for (int j = 0; j < Data_length; j++) {
								byte[] bytes1 = new byte[unpacker.unpackBinaryHeader()];
								unpacker.readPayload(bytes1);
								Label_up(bytesToHex(bytes1));
							}
					}
					break;
				}
			}
		} catch (Exception e) {
			log.error("数据解析："+e.toString()+bs.toString());
		}
	}

	private boolean Label_up(String string){
        string = string.toUpperCase();
        String ladel_mac, uuid;
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
            try {
                saveRssiService.saveRssi(ladel_mac, gateway_mac, Integer.toString(rssi));
            }
            catch (Exception e)
            {
				log.error("数据存储："+e.toString());
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

