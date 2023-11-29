package com.upskilling.springboot.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.upskilling.springboot.publisher.RabbitMQProducer;

@Service
public class RabbitMQConsumer {

	
	private static final Logger LOGGER=LoggerFactory .getLogger(RabbitMQConsumer.class);
	
	@RabbitListener(queues= {"${rabbitmq.queue.name}"})
	private void consume(String message) {
		LOGGER.info(String.format("Received message -> %s", message));
		
	}
}
