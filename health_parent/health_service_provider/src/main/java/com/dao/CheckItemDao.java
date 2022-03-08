package com.dao;

import com.github.pagehelper.Page;
import com.pojo.CheckItem;

import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-09-14 17:57
 **/
public interface CheckItemDao {
	public void add(CheckItem checkItem);
	public Page<CheckItem> selectByCondition(String queryString);

	long findCountByCheckItemId(Integer id);

	void deleteById(Integer id);

	void edit(CheckItem checkItem);

	CheckItem findById(Integer id);

	List<CheckItem> findAll();
}