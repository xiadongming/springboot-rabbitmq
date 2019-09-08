package com.example.demo.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.producer.MyProducer;

@Configuration
public class RabbitConfig {
	private Logger logger = LoggerFactory.getLogger(RabbitConfig.class);

	// 定义三个交换机
	// 定义四个队列
	// 定义绑定关系
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange("directExchange");
	}

	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange("topicExchange");
	}

	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("fanoutExchange");
	}

	@Bean
	public Queue firstQueue() {
		return new Queue("firstQueue");
	}

	@Bean
	public Queue secondQueue() {
		return new Queue("secondQueue");
	}

	@Bean
	public Queue thirdQueue() {
		return new Queue("thirdQueue");
	}

	@Bean
	public Queue fourthQueue() {
		return new Queue("fourthQueue");
	}

	@Bean
	public Binding bindFirst(@Qualifier("firstQueue") Queue queue,
			@Qualifier("directExchange") DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("rounting_key_1");
	}

	@Bean
	public Binding bindSecond(@Qualifier("secondQueue") Queue queue,
			@Qualifier("topicExchange") TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("*.rounting_key_1.*");
	}

	@Bean
	public Binding bindThird(@Qualifier("thirdQueue") Queue queue,
			@Qualifier("fanoutExchange") FanoutExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange);
	}

	@Bean
	public Binding bindFourth(@Qualifier("fourthQueue") Queue queue,
			@Qualifier("fanoutExchange") FanoutExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange);
	}

}
