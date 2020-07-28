package com.ecologicalRanch.stepCounting;

import com.ecologicalRanch.redis.entity.BluetoothRssiInfo;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ProgramStart {

	public static ExecutorService pool=Executors.newCachedThreadPool();
//	public  static ClientMQTT clientMQTT=new ClientMQTT();
	public  static boolean state=false;


	public void start() {
		MqttLoadServer.mqttReceiveTest.start();
		state=true;
	}

	public void close() {
		MqttLoadServer.mqttReceiveTest.stop();
		state=false;
	}


	public static void AppThread(BluetoothRssiInfo bluetoothRssiInfo){
		if(state) {
//			System.out.println("执行线程");
			pool.execute(new CalculationThread(bluetoothRssiInfo));
			Thread thread=new Thread(new Runnable() {
				@Override
				public void run() {

				}
			});
			thread.start();

		}
	}

}
