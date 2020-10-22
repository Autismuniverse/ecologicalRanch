package com.ecologicalRanch.stepCounting;

import com.ecologicalRanch.redis.entity.BluetoothRssiInfo;
import lombok.extern.slf4j.Slf4j;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Slf4j

public class ProgramStart {

	public static ExecutorService pool=Executors.newCachedThreadPool( );//数量不固定的线程池
	// pool = new ThreadPoolExecutor(10, 100, 1000, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
	public static ExecutorService ex = Executors.newSingleThreadExecutor();//单线程的线程池
	public  static ClientMQTT clientMQTT=new ClientMQTT();
	public  static boolean state=false;


	public void start() {
		ClientMQTT.clientMQTT=clientMQTT;
		clientMQTT.start();
		log.error("执行线程");
		state=true;
	}

	public void close() {
		clientMQTT.stop();
		state=false;
	}
	public static void setState(boolean bool)
	{
		state=bool;
	}

	public static void AppThread(BluetoothRssiInfo bluetoothRssiInfo){
		if(state) {
			pool.execute(new CalculationThread(bluetoothRssiInfo));
		}
	}
	public static void AppThread(byte[] b)
	{
		if(state) {
//			pool.execute(new MessagePacker(b));
			ex.execute(new MessagePacker(b));
		}
	}
}
