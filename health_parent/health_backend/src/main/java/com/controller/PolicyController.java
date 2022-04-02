package com.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.constant.MessageConstant;
import com.entity.PageResult;
import com.entity.QueryPageBean;
import com.entity.Result;
import com.pojo.EnrollmentAll;
import com.service.entrollment.PolicyService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-08 22:04
 **/
@RestController
@RequestMapping("/policy")
public class PolicyController {
	@Reference
	PolicyService policyService;


	@RequestMapping("/findPage")
	public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {

		PageResult pageResult = policyService.pageQuery(queryPageBean);
		System.out.println(pageResult);
		return pageResult;
	}
	@RequestMapping("/query")
	//@PreAuthorize("hasAuthority('CHECKITEM_ADD')")//权限校验
	public Result query(){
		List<EnrollmentAll> enrollmentAll = policyService.query();
		if(enrollmentAll != null && enrollmentAll.size() > 0){
			//查询成功
			Result result = new Result(true, MessageConstant.QUERY_SUCCESS);

			result.setData(enrollmentAll);
			return result;
		}
		//查询失败
		return new Result(false, MessageConstant.QUERY_FAIL);

	}

	//新增
	@RequestMapping("/add")
	//@PreAuthorize("hasAuthority('CHECKITEM_ADD')")//权限校验
	public Result add(@RequestBody EnrollmentAll enrollmentAll){
		try {
			policyService.add(enrollmentAll);
		}catch (Exception e){
			e.printStackTrace();
			return new Result(false,MessageConstant.ADD_FAIL);
		}
		return new Result(true,MessageConstant.ADD_SUCCESS);
	}

	//删除
	@RequestMapping("/delete")
	//@PreAuthorize("hasAuthority('CHECKITEM_DELETE')")//权限校验
	public Result delete(Integer id){
		try {
			policyService.delete(id);
		}catch (RuntimeException e){
			return new Result(false,e.getMessage());
		}catch (Exception e){
			return new Result(false, MessageConstant.DELETE_FAIL);
		}
		return new Result(true,MessageConstant.DELETE_SUCCESS);
	}


	//编辑
	@RequestMapping("/edit")
	//@PreAuthorize("hasAuthority('CHECKITEM_EDIT')")//权限校验
	public Result edit(@RequestBody EnrollmentAll enrollmentAll){
		try {
			policyService.edit(enrollmentAll);
		}catch (Exception e){
			return new Result(false,MessageConstant.EDIT_FAIL);
		}
		return new Result(true,MessageConstant.EDIT_SUCCESS);
	}

	@RequestMapping("/findById")
	public Result findById(Integer id){
		try{
			EnrollmentAll enrollmentAll = policyService.findById(id);
			return  new Result(true, MessageConstant.QUERY_SUCCESS,enrollmentAll);
		}catch (Exception e){
			e.printStackTrace();
			//服务调用失败
			return new Result(false, MessageConstant.QUERY_FAIL);
		}
	}



}
