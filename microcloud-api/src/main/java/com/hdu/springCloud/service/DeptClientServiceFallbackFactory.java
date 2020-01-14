package com.hdu.springCloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hdu.springCloud.entities.Dept;

import feign.hystrix.FallbackFactory;

@Component		
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable cause) {
		// TODO Auto-generated method stub
		return new DeptClientService() {
			
			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Dept get(Integer id) {
				// TODO Auto-generated method stub
				return new Dept().setUserId(id)
						.setUserName("该ID："+id+"没有对应的信息。consumer提供的降级信息")
						.setDbSource("no is database in MySQL");
			}
			
			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
