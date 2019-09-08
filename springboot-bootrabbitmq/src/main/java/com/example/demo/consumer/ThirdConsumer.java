package com.example.demo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "thirdQueue")
public class ThirdConsumer {
	
	private Logger logger = LoggerFactory.getLogger(ThirdConsumer.class); 
	
	
	@RabbitHandler
	public void getMessage(String message) {
		System.out.println("消费者3收到的消息是    "+message);
	}

}
