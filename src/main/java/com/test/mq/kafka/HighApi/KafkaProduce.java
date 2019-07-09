package com.test.mq.kafka.HighApi;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.Test;

import java.util.Properties;

public class KafkaProduce {

    @Test
    public void kafkaTest(){
        Properties props = new Properties();
        // Kafka 服务端的主机名和端口号
        props.put("bootstrap.servers", "192.168.1.103:9092");
        // 等待所有副本节点的应答
        props.put("acks", "all");
        // 消息发送最大尝试次数
        props.put("retries", 0);
        // 一批消息处理大小
        props.put("batch.size", 16384);
        // 增加服务端请求延时
        props.put("linger.ms", 1);
        // 发送缓存区内存大小
        props.put("buffer.memory", 33554432);
        // key 序列化
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // value 序列化
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(props);
        kafkaProducer.send(new ProducerRecord<String, String>("szj","key5", "value5" ), new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
            if (metadata != null) {
                System.err.println(metadata.partition() + "---" + metadata.offset());
            }
            }
        });
        kafkaProducer.close();
    }

}
