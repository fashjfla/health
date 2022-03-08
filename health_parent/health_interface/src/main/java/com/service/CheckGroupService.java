package com.service;

import com.entity.PageResult;
import com.pojo.CheckGroup;

import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-09-15 14:08
 **/
public interface CheckGroupService {

	void add(CheckGroup checkGroup, Integer[] checkitemIds);

	PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

	CheckGroup findById(Integer id);

	List<Integer> findCheckItemIdsByCheckGroupId(Integer id);

	void edit(CheckGroup checkGroup, Integer[] checkitemIds);

	List<CheckGroup> findAll();
}
