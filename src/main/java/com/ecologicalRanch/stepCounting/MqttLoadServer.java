package com.ecologicalRanch.stepCounting;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class MqttLoadServer implements ServletContextListener {

    public static ClientMQTT mqttReceiveTest = new  ClientMQTT();

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        mqttReceiveTest.stop();
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        mqttReceiveTest.start();
    }
}
