package com.practice.queue

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class QueueApplication {
	static void main(String[] args) {
		SpringApplication.run QueueApplication, args
	}
}

@Component
public class RbsMqListener {

	@RabbitListener(queues = "testteam-RBS-NEWORDER")
	public void processNewOrder(data) {
		System.out.println("received: ${new String(data.body)}")
	}

}
