package com.springboot.zxf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.zxf.mapper.UserMapper;
import com.springboot.zxf.model.User;
import com.springboot.zxf.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserMapper userMapper;
	
	@Override
	@Transactional(readOnly = true)
	public List<User> queryAllUser(){
		return userMapper.queryAllUser();
	}

	@Override
	public long save(User user) {
		return userMapper.insert(user);
	}
}
