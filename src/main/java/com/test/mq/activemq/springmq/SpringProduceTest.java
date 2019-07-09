package com.test.mq.activemq.springmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-jms-producer.xml")
public class SpringProduceTest {

    @Autowired
    private Produce queueProducer;

    @Test
    public void testSend(){
        queueProducer.sendTextMessage("SpringJms-点对点");
    }

}