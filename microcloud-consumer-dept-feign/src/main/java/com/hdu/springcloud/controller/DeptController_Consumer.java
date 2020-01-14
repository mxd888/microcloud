package com.hdu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hdu.springCloud.entities.Dept;
import com.hdu.springCloud.service.DeptClientService;

@RestController
public class DeptController_Consumer {
	
	@Autowired
	private DeptClientService service;
	
	@GetMapping(value="/consumer/dept/add")
	public boolean add(Dept dept) {
		return this.service.add(dept);
	}
	
	@GetMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Integer id) {
		return this.service.get(id);
	}
	
	@GetMapping(value="/consumer/dept/list")
	public List<Dept> list() {
		return this.service.list();
	}

}
