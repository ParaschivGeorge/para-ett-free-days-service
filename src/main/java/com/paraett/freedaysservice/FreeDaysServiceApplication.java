package com.paraett.freedaysservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FreeDaysServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreeDaysServiceApplication.class, args);
	}

}
