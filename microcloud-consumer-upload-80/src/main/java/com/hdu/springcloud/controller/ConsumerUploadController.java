package com.hdu.springcloud.controller;

import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ConsumerUploadController {
	// 设置进行远程上传微服务调用的代理地址
	public static final String UPLOAD_URL = "http://localhost:9527/zuul/mxd/myupload/upload";
	public static final String UPLOADTEST_URL = "http://localhost:9527/zuul/mxd/myupload/test";

	@GetMapping(value = "/consumer/uploadPre")
	public String uploadPre() {
		return "upload";
	}
	
	@PostMapping(value = "/consumer/test")
	@ResponseBody
	public String cunsumerTest(String name, MultipartFile photo) throws Exception{
		 CloseableHttpClient httpClient = HttpClients.createDefault(); // 创建一个HttpClient对象
         HttpClientContext httpContext = HttpClientContext.create(); // 创建Http处理操作的上下文对象
        // HttpPost httpPost = new HttpPost(UPLOAD_URL); // 设置要进行访问的请求地址
         HttpGet httpGet = new HttpGet(UPLOADTEST_URL);
//         HttpEntity entity = MultipartEntityBuilder.create()
//               .addBinaryBody("photo", photo.getBytes(),
//                     ContentType.create("image/jpeg"), "temp.jpg")
//               .build();
//         httpPost.setEntity(entity);    // 将请求的实体信息进行发送
         httpClient.execute(httpGet, httpContext) ;    // 执行请求的发送HttpResponse response = 
        // return EntityUtils.toString(response.getEntity(),Charset.forName("UTF-8")) ;
		return "测试成功";
	}

	@PostMapping(value = "/consumer/upload")
	@ResponseBody
	public String upload(String name, MultipartFile photo) throws Exception{
		System.out.println("文件名："+photo.getOriginalFilename()+"大小："+photo.getSize()+"类型："+photo.getContentType());
		if (photo.getSize() != 0) {
			CloseableHttpClient httpClient = HttpClients.createDefault(); // 创建一个http对象	http://localhost:9527/zuul/mxd/myupload/upload
	//		CredentialsProvider cProvider = new BasicCredentialsProvider(); // 创建一个具有认证访问的信息
	//		Credentials credentials = new UsernamePasswordCredentials("zuul", "mixiaodong"); // 创建一条认证信息
	//		cProvider.setCredentials(AuthScope.ANY, credentials); // 所有的认证请求都使用一个认证信息
			HttpClientContext httpContext = HttpClientContext.create(); // 创建http处理操作的上下文对象
	//		httpContext.setCredentialsProvider(cProvider); // 设置认证的提供信息
			HttpPost httpPost = new HttpPost(UPLOAD_URL); // 设置要进行访问的请求地址
	//		 HttpGet httpGet = new HttpGet(UPLOADTEST_URL);
			HttpEntity requestEntity = MultipartEntityBuilder.create()
					.addBinaryBody("photo", photo.getBytes(), ContentType.create("image/jpeg"), "mxd.jpg").build();
			httpPost.setEntity(requestEntity);	//将请求实体发送出去
			HttpResponse response = httpClient.execute(httpPost, httpContext);//执行请求的发送
			
			return EntityUtils.toString(response.getEntity(),Charset.forName("UTF-8"));
			
//			return "[--消费端--]name = " + name + "photoName = " + photo.getOriginalFilename() + "ContentType = "
//					+ photo.getContentType();
			
			
//			 CloseableHttpClient httpClient = HttpClients.createDefault(); // 创建一个HttpClient对象
//	         HttpClientContext httpContext = HttpClientContext.create(); // 创建Http处理操作的上下文对象
//	         HttpPost httpPost = new HttpPost(UPLOAD_URL); // 设置要进行访问的请求地址
//	         HttpEntity entity = MultipartEntityBuilder.create()
//	               .addBinaryBody("photo", photo.getBytes(),
//	                     ContentType.create("image/jpeg"), "temp.jpg")
//	               .build();
//	         httpPost.setEntity(entity);    // 将请求的实体信息进行发送
//	         HttpResponse response = httpClient.execute(httpPost, httpContext) ;    // 执行请求的发送
//	         return EntityUtils.toString(response.getEntity(),Charset.forName("UTF-8")) ;

		}
		return "无上传信息";
	}

}
