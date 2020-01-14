package com.hdu.springcloud.filter;

import java.nio.charset.Charset;
import java.util.Base64;
 
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
 
public class AuthorizedRequestFilter1 extends ZuulFilter {
 
	@Override
	public Object run() { // 表示具体的过滤执行操作
		
		RequestContext curContext = RequestContext.getCurrentContext();
		
		// 进行一个Http头信息配置
//		HttpHeaders headers = new HttpHeaders();
		String auth = "mxd:123";
		byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
		// 加密字符串要有空格
		String authHeader = "Basic " + new String(encodedAuth);
		System.out.println("已加载头信息为："+authHeader);
		curContext.addZuulRequestHeader("Authorization", authHeader);
//		headers.set("Authorization", authHeader);
		
		return null;
	}
 
	@Override
	public boolean shouldFilter() { // 该filter是否要执行
		
		return true;
	}
 
	@Override
	public int filterOrder() {
		return 0; // 设置优先级，数值越大优先级越高
	}
 
	@Override
	public String filterType() {
		// 在进行Zuul过滤的时候可以设置其他过滤执行的位置，那么此时有如下几种类型
		// pre:请求前设置
		// route 请求的时候
		// post :发送的
		// error: 出错之后
		return "pre";
	}
 
}