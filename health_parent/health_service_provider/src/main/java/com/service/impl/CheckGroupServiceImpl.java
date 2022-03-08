package com.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dao.CheckGroupDao;
import com.entity.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pojo.CheckGroup;
import com.pojo.CheckItem;
import com.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-09-15 14:09
 **/
@Service(interfaceClass = CheckGroupService.class)
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService {
	@Autowired
	private CheckGroupDao checkGroupDao;

	//添加检查组合，同时需要设置检查组合和检查项的关联关系
	public void add(CheckGroup checkGroup, Integer[] checkitemIds) {
		checkGroupDao.add(checkGroup);
		setCheckGroupAndCheckItem(checkGroup.getId(),checkitemIds);
	}

	public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
		PageHelper.startPage(currentPage,pageSize);
		Page<CheckItem> page = checkGroupDao.selectByCondition(queryString);
		return new PageResult(page.getTotal(),page.getResult());
	}

	public CheckGroup findById(Integer id) {
		return checkGroupDao.findById(id);
	}

	public List<Integer> findCheckItemIdsByCheckGroupId(Integer id) {
		return checkGroupDao.findCheckItemIdsByCheckGroupId(id);
	}

	public void edit(CheckGroup checkGroup, Integer[] checkitemIds) {
//根据检查组id删除中间表数据（清理原有关联关系）
		checkGroupDao.deleteAssociation(checkGroup.getId());
		//向中间表(t_checkgroup_checkitem)插入数据（建立检查组和检查项关联关系）
		setCheckGroupAndCheckItem(checkGroup.getId(),checkitemIds);
		//更新检查组基本信息
		checkGroupDao.edit(checkGroup);
	}

	public List<CheckGroup> findAll() {
		return checkGroupDao.findAll();
	}

	//设置检查组合和检查项的关联关系
	public void setCheckGroupAndCheckItem(Integer checkGroupId,Integer[] checkitemIds){
		if(checkitemIds != null && checkitemIds.length > 0){
			for (Integer checkitemId : checkitemIds) {
				Map<String,Integer> map = new HashMap<String, Integer>();
				map.put("checkgroup_id",checkGroupId);
				map.put("checkitem_id",checkitemId);
				checkGroupDao.setCheckGroupAndCheckItem(map);

			}
		}
	}
}
