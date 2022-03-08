package com.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dao.PermissionDao;
import com.dao.RoleDao;
import com.dao.UserDao;
import com.pojo.Permission;
import com.pojo.Role;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-09-22 14:37
 **/
@Service(interfaceClass = UserService.class)
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private PermissionDao permissionDao;
	//根据用户名查询数据库获取用户信息和关联的角色信息，同时需要查询角色关联的权限信息
	public User findByUsername(String username) {
		User user = userDao.findByUsername(username);//查询用户基本信息不包含用户的角色
		if (user == null){
			return null;
		}
		Integer userId = user.getId();
		//根据用户ID查询对应的角色
		Set<Role>roles = roleDao.findByUserId(userId);
		if (roles !=null&&roles.size()>0){
			for (Role role : roles) {
				Integer roleId = role.getId();
				Set<Permission> permissions = permissionDao.findByRoleId(roleId);
				if(permissions != null && permissions.size() > 0){
					role.setPermissions(permissions);
				}

			}
			user.setRoles(roles);
		}
		return user;
	}
}
