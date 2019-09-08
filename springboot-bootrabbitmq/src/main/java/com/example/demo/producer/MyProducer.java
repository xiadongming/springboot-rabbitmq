package com.example.demo.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MyProducer {
	
	 private Logger logger = LoggerFactory.getLogger(MyProducer.class);  
    @Autowired
	private RabbitTemplate  rabbitTemplate;
    
    
    public void sendMessage() {
    	rabbitTemplate.convertAndSend("directExchange", "rounting_key_1", "direct message11111111");
    	rabbitTemplate.convertAndSend("topicExchange","111.rounting_key_1.2222","topic message222222");
    	rabbitTemplate.convertAndSend("topicExchange","333.rounting_key_1.4444","topic message333333");
    	rabbitTemplate.convertAndSend("fanoutExchange", "","fanout message44444444");
    }
	
}
