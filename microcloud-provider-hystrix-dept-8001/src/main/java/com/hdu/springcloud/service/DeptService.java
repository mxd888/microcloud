package com.hdu.springcloud.service;

import java.util.List;

import com.hdu.springCloud.entities.Dept;

public interface DeptService {

	public boolean add(Dept dept);

	public Dept get(Integer id);

	public List<Dept> list();
}
