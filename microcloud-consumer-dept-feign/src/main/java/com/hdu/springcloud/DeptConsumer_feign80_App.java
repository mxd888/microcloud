package com.hdu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.hdu.springCloud"})
public class DeptConsumer_feign80_App {

	public static void main(String[] args) {

		SpringApplication.run(DeptConsumer_feign80_App.class, args);
	}

}
