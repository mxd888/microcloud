package com.hdu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hdu.springCloud.entities.Dept;

@RestController
public class DeptController_Consumer {

	// private static final String REST_URL_PREFIX="http://localhost:8001";
	private static final String REST_URL_PREFIX = "http://MICROCLOUD-DEPT";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpHeaders headers;

	@GetMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
	}

	@GetMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Integer id) {
		Dept dept = this.restTemplate.exchange(REST_URL_PREFIX + "/dept/get/" + id, HttpMethod.GET,
				new HttpEntity<Object>(this.headers), Dept.class).getBody();
	//	return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
		return dept;
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/consumer/dept/list")
	public List<Dept> list() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}

	@GetMapping(value = "/consumer/dept/discovery")
	public Object discovery() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);

	}

}
