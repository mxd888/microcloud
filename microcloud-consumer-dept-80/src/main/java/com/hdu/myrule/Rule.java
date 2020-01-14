package com.hdu.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

@Configuration
public class Rule {
	
	@Bean
	public IRule myRule() {
		return new MyselfRule();		//在这里new自己的类，即可覆盖springcloud原生的负载均衡算法
	}

}
