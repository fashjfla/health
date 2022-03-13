package com.controller.enrollerment;

import com.alibaba.dubbo.config.annotation.Reference;
import com.constant.MessageConstant;
import com.entity.Result;
import com.pojo.EnrollmentPlan;
import com.service.entrollment.PolicyService;
import org.springframework.security.access.prepost.PreAuthorize;
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


	@RequestMapping("/query")
	//@PreAuthorize("hasAuthority('CHECKITEM_ADD')")//权限校验
	public Result query(){
		List<EnrollmentPlan> enrollmentAll = policyService.query();
		if(enrollmentAll != null && enrollmentAll.size() > 0){
			//查询成功
			Result result = new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS);

			result.setData(enrollmentAll);
			return result;
		}
		//查询失败
		return new Result(false, MessageConstant.QUERY_CHECKGROUP_FAIL);

	}

	/*//新增
	@RequestMapping("/add")
	@PreAuthorize("hasAuthority('CHECKITEM_ADD')")//权限校验
	public Result add(@RequestBody EnrollmentAll enrollmentAll){
		try {
			policyService.add(enrollmentAll);
		}catch (Exception e){
			e.printStackTrace();
			return new Result(false,MessageConstant.ADD_CHECKITEM_FAIL);
		}
		return new Result(true,MessageConstant.ADD_CHECKITEM_SUCCESS);
	}
*/
/*

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
*/


	//编辑
	@RequestMapping("/edit")
	@PreAuthorize("hasAuthority('CHECKITEM_EDIT')")//权限校验
	public Result edit(@RequestBody EnrollmentPlan enrollmentPlan){
		try {
			policyService.edit(enrollmentPlan);
		}catch (Exception e){
			return new Result(false,MessageConstant.EDIT_CHECKITEM_FAIL);
		}
		return new Result(true,MessageConstant.EDIT_CHECKITEM_SUCCESS);
	}
/*

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
*/



}
