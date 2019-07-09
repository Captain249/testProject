package com.test.mq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;
import java.util.HashMap;

public class ActivemqProduce {

    @Test
    public void mqtest() throws JMSException {
        //1.创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.1.103:61616");
        //2.获取连接
        Connection connection = connectionFactory.createConnection();
        //3.启动连接
        connection.start();
        //4.获取 session (参数 1：是否启动事务,参数 2：消息确认模式)
        /*
            AUTO_ACKNOWLEDGE = 1 自动确认
            CLIENT_ACKNOWLEDGE = 2 客户端手动确认
            DUPS_OK_ACKNOWLEDGE = 3 自动批量确认
            SESSION_TRANSACTED = 0 事务提交并确认
         */
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5.创建队列对象
        Queue queue = session.createQueue("test-queue");
        //6.创建消息生产者
        MessageProducer producer = session.createProducer(queue);
        //7.创建消息
        TextMessage textMessage = session.createTextMessage("hello word");
        HashMap map = new HashMap();
        MapMessage mapMessage = session.createMapMessage();
        //8.发送消息
        producer.send(textMessage);
        //9.关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}
