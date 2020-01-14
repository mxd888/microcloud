package com.hdu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.hdu.myrule.Rule;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="MICROCLOUD-DEPT")//,configuration=Rule.class)	// configuration-》要指向带有@Configuration的类，在内部进行new对象，对象为负载均衡算法
public class DeptConsumer80_App {

	public static void main(String[] args) {

		SpringApplication.run(DeptConsumer80_App.class, args);
	}

}
