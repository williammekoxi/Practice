package com.example.deme04

import org.slf4j.*
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

import java.text.SimpleDateFormat

@SpringBootApplication
@EnableScheduling
class Deme04Application {

	static void main(String[] args) {
		SpringApplication.run Deme04Application, args
	}
}

@Component
public class ScheduledTasks {
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class)
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss")

	@Scheduled(cron = "5/10 * * * * *")
	public void reportCurrentTime() {
		log.info("the time is now ${dateFormat.format(new Date())}")
	}
}
