package com.springboot.demo.service;

import java.util.List;

import com.springboot.demo.model.User;

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
