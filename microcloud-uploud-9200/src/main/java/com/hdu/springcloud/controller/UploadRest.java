package com.hdu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class UploadRest {
	
	@GetMapping(value = ("/test"))
	public String uploadTest() {
		System.out.println("成功");
		return "Test成功";
	}

	@PostMapping(value = "/upload")
	@HystrixCommand(fallbackMethod = "uploadFallback") 
	public Object upload(@RequestParam("photo") MultipartFile photo) {
		if (photo != null) {
			System.out.println("成功上传");
			System.out.println("文件名称:"+photo.getOriginalFilename()+"文件大小:"+photo.getSize()+"文件类型："+photo.getContentType());
		}
		return "成功";
	}
	public String uploadFallback(@RequestParam("photo") MultipartFile photo) {
		return "没有文件";
	}
}
