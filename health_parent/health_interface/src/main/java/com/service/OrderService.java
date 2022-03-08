package com.service;

import com.entity.Result;

import java.util.Map;

/**
 * 体检预约服务接口
 */
public interface OrderService {
	//体检预约
	public Result order(Map map) throws Exception;

	Map findById(Integer id)throws Exception;
}