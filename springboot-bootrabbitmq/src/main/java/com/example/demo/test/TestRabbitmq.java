package com.example.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.producer.MyProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRabbitmq {
	
	
	@Autowired
	private MyProducer myProducer;
	@Test
	public void testSendMessage() {
		myProducer.sendMessage();
	}

}
