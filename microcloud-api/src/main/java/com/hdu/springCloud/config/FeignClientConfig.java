package com.hdu.springCloud.config;

import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignClientConfig {
	
	/*public Logger.level name() {
		return
	}*/
	public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor("zuul", "mixiaodong");
	}

}
