package com.springkafka.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Sender {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void send(String topic, String payload) {
		System.out.println("Sending message : "+topic+" payload: "+payload);
		System.out.println("KafkaTemplate: "+kafkaTemplate);
		kafkaTemplate.send(topic, payload);
	}

}
