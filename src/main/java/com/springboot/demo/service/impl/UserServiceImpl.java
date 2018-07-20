package com.springboot.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.demo.mapper.UserMapper;
import com.springboot.demo.model.User;
import com.springboot.demo.service.UserService;

/**
 * @description: 用户管理业务实现类
 * @author zhaoxuefeng
 * @date 2018年7月20日 下午11:18:33
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	@Transactional(readOnly = true)
	public List<User> queryAllUser() {
		return userMapper.queryAllUser();
	}

	@Override
	public long save(User user) {
		return userMapper.insert(user);
	}
}
