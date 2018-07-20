package com.springboot.zxf.service;

import java.util.List;

import com.springboot.zxf.model.User;

public interface UserService {
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<User> queryAllUser();
	
	/**
	 * 保存数据
	 * @return
	 */
	public long save(User user);
	
}
