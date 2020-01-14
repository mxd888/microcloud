package com.hdu.springcloud.cfgbeans;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class ConfigBean {
	
	@Bean
	@LoadBalanced	//spring cloud ribbon基于Netflix ribbon实现的一套客户端  负载均衡工具
	public RestTemplate geRestTemplate() {
		return new RestTemplate();
	}
	
	//自己通过实现接口，从而避免使用Springcloud自己带的负载均衡算法	-----》诺自己写了类，则以下代码失效
	
	//负载均衡算法
	@Bean
	public IRule myRule() {
		return new RandomRule();			//随机算法  	-->自定义算法在这里new，无效
	}
	
	
	@Bean
	public HttpHeaders gethttpheaders() {

		HttpHeaders headers = new HttpHeaders();
		String auth = "Java:mixiaodong";// 认证信息
		byte[] encodeAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
		//在进行授权的头信息内容配置的时候加密的信息一定要与“basic”之间有一个空格
		//Basic后面必须有一个空格。否则浪费最好的年华，还丢掉那个她
		String authHeader = "Basic " + new String(encodeAuth);
		headers.set("Authorization", authHeader);
		return headers;
	}

}
