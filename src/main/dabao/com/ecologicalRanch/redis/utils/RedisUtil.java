package com.ecologicalRanch.redis.utils;

import com.ecologicalRanch.config.ApplicationContextProvider;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * jedis连接池工具
 */
public final class RedisUtil {

    private static JedisPool jedisPool = null;

    /**
     * 初始化Redis连接池
     */
    RedisUtil(){

        jedisPool = ApplicationContextProvider.getBean(JedisPool.class);
//        //Redis服务器IP
//        String ADDR = "10.12.11.32";
//
//        //Redis的端口号
//        int PORT = 6379;
//
//        //访问密码
//        String AUTH = "";
//
//        //可用连接实例的最大数目，默认值为8；
//        //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
//        int Max_T0TAL = 1024;
//
//        //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
//        int MAX_IDLE = 200;
//
//        //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
//        int MAX_WAIT = 10000;
//
//        int TIMEOUT = 10000;
//
//        //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
//        boolean TEST_ON_BORROW = true;
//
//        try {
//            JedisPoolConfig config = new JedisPoolConfig();
//            config.setMaxTotal(Max_T0TAL);
//            config.setMaxIdle(MAX_IDLE);
//            config.setMaxWaitMillis(MAX_WAIT);
//            config.setTestOnBorrow(TEST_ON_BORROW);
//
//            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT);
//            System.out.println("连接成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 获取 JedisPool 实例
     *
     * @return
     */
    public synchronized static JedisPool getJedisPool() {
        if (jedisPool != null)
            return jedisPool;
        return null;
    }

    /**
     * 获取Jedis实例
     *
     * @return
     */
    public synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                return jedisPool.getResource();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 释放Jedis资源
     *
     * @param jedis
     */
    private static void returnResource(final Jedis jedis) {
        if (jedis != null) jedis.close();
    }
}

