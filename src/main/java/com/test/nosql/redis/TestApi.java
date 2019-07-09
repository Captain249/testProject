package com.test.nosql.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.Set;

public class TestApi {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.1.103",6379);
        jedis.set("k1","v1");
        jedis.set("k2","v2");
        System.out.println(jedis.get("k1"));
        Set<String> sets = jedis.keys("*");
        System.out.println(sets.size());

        //事务
        Transaction transaction = jedis.multi();
        transaction.set("k3","v3");
        transaction.set("k4","v4");
        transaction.exec();
        //回滚
        //transaction.discard();

    }
}
