package com.hdu.springCloud.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hdu.springCloud.entities.Dept;



//@FeignClient(name = "MICROCLOUD-DEPT") //只包含feign
@FeignClient(name = "microcloud-zuul-gateway" ,fallbackFactory = DeptClientServiceFallbackFactory.class)		//包含feign和服务降级
public interface DeptClientService {
	
	@GetMapping(value = "/mxd/mydept/dept/get/{id}")
	public Dept get(@PathVariable("id") Integer id);

	@GetMapping(value = "/mxd/mydept/dept/list")
	public List<Dept> list();
	
	@PostMapping(value = "/mxd/mydept/dept/add")
	public boolean add(Dept dept);
}
