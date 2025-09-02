package com.ashish.Transitions_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
//@EnableFeignClients(basePackages = "com.ashish.Transitions_Service.config")
public class TransitionsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransitionsServiceApplication.class, args);
	}

}
