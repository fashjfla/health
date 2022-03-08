package com.dao;

import com.pojo.User;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-09-22 14:40
 **/
public interface UserDao {
	public User findByUsername(String username);
}
