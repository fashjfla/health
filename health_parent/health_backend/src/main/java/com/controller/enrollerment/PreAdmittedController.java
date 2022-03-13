package com.controller.enrollerment;

import com.alibaba.dubbo.config.annotation.Reference;
import com.constant.MessageConstant;
import com.entity.Result;
import com.pojo.EnrollmentAll;
import com.service.entrollment.AdmittedService;
import com.service.entrollment.PreAdmittedService;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/PreAdmitted")
public class PreAdmittedController {

	@Reference
	PreAdmittedService preAdmittedService;


	@RequestMapping("/query")
	//@PreAuthorize("hasAuthority('CHECKITEM_ADD')")//权限校验
	public Result query(){
		List<EnrollmentAll> enrollmentAll = preAdmittedService.query();
		List<EnrollmentAll> enrollmentAllList = new ArrayList<>();
		enrollmentAll.forEach(enrollmentAll1 -> {
			EnrollmentAll enrollmentAll2 = new EnrollmentAll();
			if ("A".equals(enrollmentAll1.getAdmissionStatus())){
				enrollmentAllList.add(enrollmentAll2);
			}
		});
		if(enrollmentAllList.size() > 0){
			//查询成功
			Result result = new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS);

			result.setData(enrollmentAllList);
			return result;
		}
		//查询失败
		return new Result(false, MessageConstant.QUERY_CHECKGROUP_FAIL);

	}

	//编辑
	@RequestMapping("/edit")
	@PreAuthorize("hasAuthority('CHECKITEM_EDIT')")//权限校验
	public Result edit(@RequestBody EnrollmentAll enrollmentAll){
		try {
			preAdmittedService.edit(enrollmentAll);
		}catch (Exception e){
			return new Result(false, MessageConstant.EDIT_CHECKITEM_FAIL);
		}
		return new Result(true,MessageConstant.EDIT_CHECKITEM_SUCCESS);
	}
}

