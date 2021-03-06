package com.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.constant.MessageConstant;
import com.entity.PageResult;
import com.entity.QueryPageBean;
import com.entity.Result;
import com.pojo.CheckItem;
import com.service.CheckItemService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 检查项管理
 * @date 2021-09-14 17:45
 **/

@RestController
@RequestMapping("/checkitem")
public class CheckItemController {
	@Reference
	private CheckItemService checkItemService;

	//新增
	@RequestMapping("/add")
	@PreAuthorize("hasAuthority('CHECKITEM_ADD')")//权限校验
	public Result add(@RequestBody CheckItem checkItem){
		try {
			checkItemService.add(checkItem);
		}catch (Exception e){
			e.printStackTrace();
			return new Result(false,MessageConstant.ADD_CHECKITEM_FAIL);
		}
		return new Result(true,MessageConstant.ADD_CHECKITEM_SUCCESS);
	}

	//检查项分页查询
	@PreAuthorize("hasAuthority('CHECKITEM_QUERY')")//权限校验
	@RequestMapping("/findPage")
	public PageResult findPage(@RequestBody QueryPageBean queryPageBean){

		PageResult pageResult = checkItemService.pageQuery(queryPageBean);
		System.out.println(pageResult);
		return pageResult;
}
	//删除
	@RequestMapping("/delete")
	@PreAuthorize("hasAuthority('CHECKITEM_DELETE')")//权限校验
	public Result delete(Integer id){
		try {
			checkItemService.delete(id);
		}catch (RuntimeException e){
			return new Result(false,e.getMessage());
		}catch (Exception e){
			return new Result(false, MessageConstant.DELETE_CHECKITEM_FAIL);
		}
		return new Result(true,MessageConstant.DELETE_CHECKITEM_SUCCESS);
	}


	//编辑
	@RequestMapping("/edit")
	@PreAuthorize("hasAuthority('CHECKITEM_EDIT')")//权限校验
	public Result edit(@RequestBody CheckItem checkItem){
		try {
			checkItemService.edit(checkItem);
		}catch (Exception e){
			return new Result(false,MessageConstant.EDIT_CHECKITEM_FAIL);
		}
		return new Result(true,MessageConstant.EDIT_CHECKITEM_SUCCESS);
	}

	@RequestMapping("/findById")
	public Result findById(Integer id){
		try{
			CheckItem checkItem = checkItemService.findById(id);
			return  new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS,checkItem);
		}catch (Exception e){
			e.printStackTrace();
			//服务调用失败
			return new Result(false, MessageConstant.QUERY_CHECKITEM_FAIL);
		}
	}

	//查询所有
	@RequestMapping("/findAll")
	public Result findAll(){
		List<CheckItem> checkItemList = checkItemService.findAll();
		if(checkItemList != null && checkItemList.size() > 0){
			Result result = new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS);

			result.setData(checkItemList);
			return result;
		}
		return
				new Result(false,MessageConstant.QUERY_CHECKITEM_FAIL);
	}


}
