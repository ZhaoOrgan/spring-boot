package com.springboot.zxf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.springboot.zxf.model.User;
import com.springboot.zxf.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/list")
	public Object list() {
		PageHelper.startPage(1, 100);
		return userService.queryAllUser();
	}
	
	@RequestMapping(value = "/save")
	public Object save() {
		User user = new User();
		user.setName("123");
		user.setPassword("123");
		user.setEmail("123@qq.com");
		return userService.save(user);
	}
	
}
