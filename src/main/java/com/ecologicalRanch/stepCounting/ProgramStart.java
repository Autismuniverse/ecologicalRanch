package com.ecologicalRanch.stepCounting;

import com.ecologicalRanch.redis.entity.BluetoothRssiInfo;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ProgramStart {

	public static ExecutorService pool=Executors.newCachedThreadPool();
	public  static ClientMQTT clientMQTT=new ClientMQTT();
	public  static boolean state=false;

	public void start() {
		clientMQTT.start();
		state=true;
	}

	public void close() throws MqttException {
		clientMQTT.stop();
		state=false;
	}

//	public  static  void  AppThread(String bluetoothId) {
//		if (state) {
//			System.out.println("执行线程");
//			pool.execute(new CalculationThread(bluetoothId));
//
//		}
//	}
	public static void AppThread(BluetoothRssiInfo bluetoothRssiInfo){
		if(state) {
//			System.out.println("执行线程");
			pool.execute(new CalculationThread(bluetoothRssiInfo));
		}
	}

}