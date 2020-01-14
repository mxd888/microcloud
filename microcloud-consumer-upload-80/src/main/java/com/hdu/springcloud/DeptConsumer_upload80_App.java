package com.hdu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class DeptConsumer_upload80_App {

	public static void main(String[] args) {

		SpringApplication.run(DeptConsumer_upload80_App.class, args);
	}

}
