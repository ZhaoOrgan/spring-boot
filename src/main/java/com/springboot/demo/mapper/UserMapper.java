package com.springboot.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.demo.model.User;

@Mapper
public interface UserMapper {
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> queryAllUser();
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	long insert(User user);

}
