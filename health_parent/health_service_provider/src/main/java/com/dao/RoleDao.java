package com.dao;

import com.pojo.Role;

import java.util.Set;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-09-22 14:40
 **/
public interface RoleDao {
	public Set<Role> findByUserId(int id);
}
