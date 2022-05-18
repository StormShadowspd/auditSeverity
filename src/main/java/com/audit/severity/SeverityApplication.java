package com.audit.severity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.audit.severity"})
@EnableFeignClients
public class SeverityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeverityApplication.class, args);
	}

}
