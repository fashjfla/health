package com.dao;

import com.github.pagehelper.Page;
import com.pojo.CheckGroup;
import com.pojo.CheckItem;

import java.util.List;
import java.util.Map;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-09-15 14:10
 **/
public interface CheckGroupDao {
	void add(CheckGroup checkGroup);

	void setCheckGroupAndCheckItem(Map map);

	Page<CheckItem> selectByCondition(String queryString);

	CheckGroup findById(Integer id);

	List<Integer> findCheckItemIdsByCheckGroupId(Integer id);

	void deleteAssociation(Integer id);

	void edit(CheckGroup checkGroup);

	List<CheckGroup> findAll();
}
