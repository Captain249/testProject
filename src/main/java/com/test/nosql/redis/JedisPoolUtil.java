package com.test.nosql.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {
    //单例模式,volatile防止指令重排
    private static volatile JedisPool jedisPool = null;

    private JedisPoolUtil(){}

    public static JedisPool getJedisPoolInstance(){
        synchronized (JedisPoolUtil.class){
            if(null == jedisPool){
                //连接池配置
                JedisPoolConfig poolConfig = new JedisPoolConfig();
                //可用1000个
                poolConfig.setMaxActive(1000);
                //最大空闲数，有32的时候差不多要挂了
                poolConfig.setMaxIdle(32);
                //等待
                poolConfig.setMaxWait(1000*100);
                //连接时检查可用 ping
                poolConfig.setTestOnBorrow(true);
                jedisPool = new JedisPool(poolConfig,"192.168.1.103",6379);
            }
        }
        return jedisPool;
    }

    //放回池子
    public static void release(JedisPool jedisPool, Jedis jedis){
        if(null != jedis){
            jedisPool.returnResourceObject(jedis);
        }
    }

    public void test(){
    }
}
