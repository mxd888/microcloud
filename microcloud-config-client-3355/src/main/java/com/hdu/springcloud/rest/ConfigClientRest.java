package com.hdu.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConfigClientRest {

	@Value("${spring.application.name}")
	private String applicationName;
	
	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServers;
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/config")
	public String getconfig() {
		String string="application:"+applicationName+"\t eurekaServers:"+eurekaServers
				+"\t server.port"+port;
		System.out.println("*****"+string);
		return string;
	}
}
