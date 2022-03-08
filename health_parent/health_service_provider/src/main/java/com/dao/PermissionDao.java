package com.dao;

import com.pojo.Permission;

import java.util.Set;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-09-22 14:41
 **/
public interface PermissionDao {
	public Set<Permission> findByRoleId(int roleId);
}
