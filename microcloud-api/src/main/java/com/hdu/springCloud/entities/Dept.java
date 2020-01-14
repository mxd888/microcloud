package com.hdu.springCloud.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor		//全参构造	 注释掉后续可以自定义构造
@Data
@Accessors(chain=true)
public class Dept implements Serializable{
	private Integer userId;
	private String userName;
	private String dbSource;
	
	/*public Dept(Integer userName, Integer dbSource) {
		super();
		this.userName = userName;
		this.dbSource = dbSource;
	}*/

	
	
}
