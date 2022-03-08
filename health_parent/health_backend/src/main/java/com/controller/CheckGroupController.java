package com.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.constant.MessageConstant;
import com.entity.PageResult;
import com.entity.QueryPageBean;
import com.entity.Result;
import com.pojo.CheckGroup;
import com.service.CheckGroupService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-09-15 14:04
 **/
@RestController
@RequestMapping("/checkgroup")
public class CheckGroupController {
	@Reference
	private CheckGroupService checkGroupService;

	//新增
	@RequestMapping("/add")
	public Result add(@RequestBody CheckGroup checkGroup, Integer[] checkitemIds){
		try {
			checkGroupService.add(checkGroup,checkitemIds);
		}catch (Exception e){
			//新增失败
			return new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
		}
		//新增成功
		return new Result(true,MessageConstant.ADD_CHECKGROUP_SUCCESS);
	}
	//分页查询
	@RequestMapping("/findPage")
	public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
		PageResult pageResult = checkGroupService.pageQuery(
				queryPageBean.getCurrentPage(),
				queryPageBean.getPageSize(),
				queryPageBean.getQueryString()


		);

		return pageResult;
	}

	//根据id查询
	@RequestMapping("/findById")
	public Result findById(Integer id){
		CheckGroup checkGroup = checkGroupService.findById(id);
		if(checkGroup != null){
			Result result = new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS);
			result.setData(checkGroup);
			return result;
		}
		return new Result(false, MessageConstant.QUERY_CHECKGROUP_FAIL);

	}

	//根据检查组合id查询对应的所有检查项id
	@RequestMapping("/findCheckItemIdsByCheckGroupId")
	public Result findCheckItemIdsByCheckGroupId(Integer id){
		try{
			List<Integer> checkitemIds =
					checkGroupService.findCheckItemIdsByCheckGroupId(id);
			return new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS,checkitemIds);

		}catch (Exception e){
			e.printStackTrace();
			return new Result(false, MessageConstant.QUERY_CHECKITEM_FAIL);

		}
	}

	//编辑
	@RequestMapping("/edit")
	public Result edit(@RequestBody CheckGroup checkGroup,Integer[] checkitemIds){
		try {
			checkGroupService.edit(checkGroup,checkitemIds);
		}catch (Exception e){
			return new Result(false,MessageConstant.EDIT_CHECKGROUP_FAIL);
		}
		return new Result(true,MessageConstant.EDIT_CHECKGROUP_SUCCESS);

	}

	//查询所有
	@RequestMapping("/findAll")
	public Result findAll(){
		List<CheckGroup> checkGroupList = checkGroupService.findAll();
		if(checkGroupList != null && checkGroupList.size() > 0){
			//查询成功
			Result result = new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS);

			result.setData(checkGroupList);
			return result;
		}
		//查询失败
		return new Result(false, MessageConstant.QUERY_CHECKGROUP_FAIL);
	}

}
