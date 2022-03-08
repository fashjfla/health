package com.controller;

import com.constant.MessageConstant;
import com.entity.Result;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-09-22 15:18
 **/
@RestController
@RequestMapping("/user")
public class UserController {
	//获取当前登录用户的用户名
	@RequestMapping("/getUsername")
	public Result getUsername()throws Exception{
		//当Spring security完成认证后，会将当前用户信息保存到框架提供的上下文对象
		try{
			org.springframework.security.core.userdetails.User user =
					(org.springframework.security.core.userdetails.User)
							SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return new Result(true, MessageConstant.GET_USERNAME_SUCCESS,user.getUsername());
		}catch (Exception e){
			return new Result(false, MessageConstant.GET_USERNAME_FAIL);
		}
	}
}