package com.hdu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
@EnableEurekaClient
public class SpringCloud_Turbine_9101 {

	public static void main(String[] args) {

		SpringApplication.run(SpringCloud_Turbine_9101.class, args);
	}

}
