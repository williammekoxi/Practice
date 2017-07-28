package com.example.soap

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.stereotype.Component
import wslite.soap.SOAPClient

@SpringBootApplication
class SoapApplication {

	static void main(String[] args) {
		SpringApplication.run SoapApplication, args
	}
}

@Component
class AppLoader implements CommandLineRunner {
	static Logger logger = LoggerFactory.getLogger(AppLoader.class)

	@Override
	void run(String... args) throws Exception {
		new AppPushServiceClient().SendAdSync(new AppAdMessage(
			title: "test 05",
			url: "https://github.com",
			appId: "Rbs",
			businessCode: "Rbs01",
			hotelId: "2000014",
			memberId: "059606324",
			message: "test 05 message"
		))
	}
}

