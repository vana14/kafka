package com.kafka.demo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class Producer {
    private static final Logger log = LoggerFactory.getLogger(Producer.class);

    public static void main(String[] args) {
        log.info("Kafka producer starting...");

        // Create producer properties
        Properties props = new Properties();

        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        // Create a producer record
        ProducerRecord<String, String> record = new ProducerRecord<>("test_topic", "hello world");

        producer.send(record);

        producer.flush();

        producer.close();
    }
}
