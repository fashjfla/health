package com.dao;

import com.github.pagehelper.Page;
import com.pojo.Setmeal;

import java.util.List;
import java.util.Map;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-09-16 16:53
 **/
public interface SetmealDao {
	void add(Setmeal setmeal);

	void setSetmealAndCheckGroup(Map map);


	Page<Setmeal> findByCondition(String queryString);

	List<Setmeal> findAll();

	public Setmeal findById(int id);

	List<Map<String, Object>> findSetmealCount();
}
