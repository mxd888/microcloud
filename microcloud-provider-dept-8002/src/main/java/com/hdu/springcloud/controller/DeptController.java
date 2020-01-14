package com.hdu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hdu.springCloud.entities.Dept;
import com.hdu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class DeptController {

	@Autowired
	private DeptService service;
	
	@Autowired
	private DiscoveryClient client;
	
	@PostMapping(value="/dept/add")
	public boolean add(@RequestBody Dept dept) {
		return service.add(dept);
	}
	
	@HystrixCommand
	@GetMapping(value="/dept/testget/{id}")
	public Dept get(@PathVariable("id") Integer id) {
		return service.get(id);
	}
	
	@HystrixCommand(fallbackMethod = "")
	@GetMapping(value="/dept/list")
	public List<Dept> list() {
		return service.list();
	}
	
	@GetMapping(value="/dept/discovery")
	public Object discovery() {
		List<String> list=client.getServices();
		System.out.println("********"+list);
		
		List<ServiceInstance> srvlist=client.getInstances("MICROCLOUD-DEPT");
		for (ServiceInstance serviceInstance : srvlist) {
			System.out.println(serviceInstance.getInstanceId()+"\t"
		+serviceInstance.getHost()+"\t"
		+serviceInstance.getPort()+"\t"
		+serviceInstance.getUri());
			
		}

		return this.client;
		
	}
	
	
}
