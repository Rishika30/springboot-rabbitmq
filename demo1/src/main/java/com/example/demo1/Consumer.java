package com.example.demo1;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	@RabbitListener(queues = MessagingConfig.QUEUE)
	public void consumeMessageFromQueue() {
		System.out.println("Message received from queue");
	}
}
