package com.example.demo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.demo.configuration.RabbitConfig;

@Component
@RabbitListener(queues = "firstQueue")
public class FirstConsumer {
	private Logger logger = LoggerFactory.getLogger(FirstConsumer.class); 
	
	@RabbitHandler
	public void getMessage(String message) {
		System.out.println("消费者1收到的消息是      "+message);
	}

}
