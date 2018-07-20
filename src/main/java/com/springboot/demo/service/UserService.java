package com.springboot.demo.service;

import java.util.List;

import com.springboot.demo.model.User;

/**
 * @description: 用户管理业务接口
 * @author zhaoxuefeng
 * @date 2018年7月18日 下午11:17:50
 */
public interface UserService {

	// 查询所有数据
	public List<User> queryAllUser();

	// 保存数据
	public long save(User user);

}
