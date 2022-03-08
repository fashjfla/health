package com.service;

import com.entity.PageResult;
import com.pojo.Setmeal;

import java.util.List;
import java.util.Map;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-09-16 16:25
 **/
public interface SetmealService {
	void add(Setmeal setmeal, Integer[] checkgroupIds);

	PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

	List<Setmeal> findAll();

	public Setmeal findById(int id);

	List<Map<String, Object>> findSetmealCount();
}
