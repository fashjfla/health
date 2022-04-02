package com.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.constant.MessageConstant;
import com.entity.PageResult;
import com.entity.QueryPageBean;
import com.entity.Result;
import com.pojo.EnrollmentAll;
import com.service.entrollment.PreAdmittedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-10 21:20
 **/

@RestController
@RequestMapping("/preAdmitted")
public class PreAdmittedController {

	@Reference
	PreAdmittedService preAdmittedService;




	//编辑
	@RequestMapping("/edit")
	public Result edit(@RequestBody EnrollmentAll enrollmentAll) {
		try {
			preAdmittedService.edit(enrollmentAll);
		} catch (Exception e) {
			return new Result(false, MessageConstant.EDIT_FAIL);
		}
		return new Result(true, MessageConstant.EDIT_SUCCESS);
	}


	//检查项分页查询
	@RequestMapping("/findPage")
	public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {

		PageResult pageResult = preAdmittedService.pageQuery(queryPageBean);
		System.out.println(pageResult);
		return pageResult;
	}


	@RequestMapping("/findById")
	public Result findById(Integer id){
		try{
			EnrollmentAll enrollmentAll = preAdmittedService.findById(id);
			return  new Result(true, MessageConstant.QUERY_SUCCESS,enrollmentAll);
		}catch (Exception e){
			e.printStackTrace();
			//服务调用失败
			return new Result(false, MessageConstant.QUERY_FAIL);
		}
	}

}