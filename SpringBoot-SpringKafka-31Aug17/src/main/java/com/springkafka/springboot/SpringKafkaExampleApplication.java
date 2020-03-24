package com.springkafka.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;

import com.springkafka.kafka.consumer.Listener;
import com.springkafka.kafka.consumer.Receiver;
import com.springkafka.kafka.producer.Sender;

@SpringBootApplication(scanBasePackages = { "com.springkafka" })
public class SpringKafkaExampleApplication {

	
	static ApplicationContext applicationContext;
	
	@Autowired
	private static KafkaTemplate<String, String> kafkaTemplate;

	public static void main(String[] args) {
		applicationContext= SpringApplication.run(SpringKafkaExampleApplication.class, args);
		printAllBeans();
		Sender sender = applicationContext.getBean("sender", Sender.class);
		/*sender.send("Hello-World", "Hello Kafka Test");
		sender.send("Hello-World", "My send message");*/
		
		kafkaTemplate.send("Hello-World", "message1", "Hello kafka");
		
		Receiver receiver = applicationContext.getBean("receiver", Receiver.class);
		receiver.receive("Hello-World");
		
		
		Listener listener = applicationContext.getBean("listener", Listener.class);
	}
	
	// to display available beans in spring context/ spring IOC
	public static void printAllBeans() {
		
		String[] beanDefs = applicationContext.getBeanDefinitionNames();
		
		for (String string : beanDefs) {
			System.out.println(string);
		}
		// check whether kafkaTemplate is available or not in spring context
		System.out.println("kafkaTemplate is defined in spring context: "+applicationContext.containsBeanDefinition("kafkaTemplate"));
	}

}