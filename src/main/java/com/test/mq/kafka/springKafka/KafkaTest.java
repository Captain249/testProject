package com.test.mq.kafka.springKafka;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kafka-producer.xml","classpath:kafka-consumer.xml"})
public class KafkaTest {

    @Test
    public void kafkatest(){
        Logger.getLogger("org").setLevel(Level.ERROR);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:kafka-producer.xml");
        KafkaTemplate kafkaTemplate = ctx.getBean("KafkaTemplate", KafkaTemplate.class);
        for (int i = 1; i < 5; i++) {
            String msg = "msg-" + i;
            //向topic发送消息
            kafkaTemplate.send("szj", msg);
            System.out.println("send msg  : " + msg);
        }
    }
}