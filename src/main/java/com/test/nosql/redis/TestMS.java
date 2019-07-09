package com.test.nosql.redis;

import redis.clients.jedis.Jedis;

public class TestMS {
    //主从复制
    public static void main(String[] args) {
        Jedis jedis_M = new Jedis("192.168.1.103",6379);
        Jedis jedis_S = new Jedis("192.168.1.103",6380);
        jedis_S.slaveof("192.168.1.103",6379);
        jedis_M.set("k1","v1");
        System.out.println(jedis_S.get("k1"));
    }
}
