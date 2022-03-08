package com.service;

import com.entity.PageResult;
import com.entity.QueryPageBean;
import com.pojo.CheckItem;

import java.util.List;

/**
 *服务接口
 * @date 2021-09-14 17:49
 **/
public interface CheckItemService {

	public void add(CheckItem checkItem);
	public PageResult pageQuery(QueryPageBean queryPageBean);

	void delete(Integer id);

	void edit(CheckItem checkItem);

	CheckItem findById(Integer id);

	List<CheckItem> findAll();
}
