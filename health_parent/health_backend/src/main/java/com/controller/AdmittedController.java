package com.controller;



import com.alibaba.dubbo.config.annotation.Reference;
import com.constant.MessageConstant;
import com.entity.PageResult;
import com.entity.QueryPageBean;
import com.entity.Result;
import com.pojo.EnrollmentAll;
import com.service.entrollment.AdmittedService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admitted")
public class AdmittedController {

	@Reference
	private AdmittedService admittedService;




	//编辑
	@RequestMapping("/edit")
	public Result edit(@RequestBody EnrollmentAll enrollmentAll){
		try {
			admittedService.edit(enrollmentAll);
		}catch (Exception e){
			return new Result(false,MessageConstant.EDIT_FAIL);
		}
		return new Result(true,MessageConstant.EDIT_SUCCESS);
	}

	//分页查询
	@RequestMapping("/findPage")
	public PageResult findPage(@RequestBody QueryPageBean queryPageBean){

		PageResult pageResult = admittedService.pageQuery(queryPageBean);
		System.out.println(pageResult);
		return pageResult;
	}

	@RequestMapping("/findById")
	public Result findById(Integer id){
		try{
			EnrollmentAll enrollmentAll = admittedService.findById(id);
			return  new Result(true, MessageConstant.QUERY_SUCCESS,enrollmentAll);
		}catch (Exception e){
			e.printStackTrace();
			//服务调用失败
			return new Result(false, MessageConstant.QUERY_FAIL);
		}
	}

}
