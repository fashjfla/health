package com.service;

import com.pojo.User;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-09-22 14:27
 **/
public interface UserService {
	public User findByUsername(String username);
}
