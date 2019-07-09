package com.test.nosql.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTx {

    public boolean transMethod(){
        Jedis jedis = new Jedis("192.168.1.103",6379);
        int balance;//可用余额
        int debt;//欠款
        int amtToSubtract = 10;//实刷余额

        jedis.watch("balance");
        balance = Integer.parseInt(jedis.get("balance"));
        if(balance < amtToSubtract){
            jedis.unwatch();
            System.out.println("modify");
            return false;
        }else{
            Transaction transaction = jedis.multi();
            transaction.decrBy("balance",amtToSubtract);
            transaction.incrBy("debt",amtToSubtract);
            transaction.exec();
            balance = Integer.parseInt(jedis.get("balance"));
            debt = Integer.parseInt(jedis.get("debt"));
            return true;
        }
    }

}
