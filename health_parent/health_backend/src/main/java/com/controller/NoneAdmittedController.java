package com.controller;



import com.alibaba.dubbo.config.annotation.Reference;
import com.constant.MessageConstant;
import com.entity.PageResult;
import com.entity.QueryPageBean;
import com.entity.Result;
import com.pojo.EnrollmentAll;
import com.service.entrollment.NoneAdmittedService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-08 22:04
 **/
@RestController
@RequestMapping("/noneAdmitted")
public class NoneAdmittedController {

	@Reference
	NoneAdmittedService noneAdmittedService;

	@RequestMapping("/findPage")
	public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {

		PageResult pageResult = noneAdmittedService.pageQuery(queryPageBean);

		System.out.println(pageResult);
		return pageResult;
	}


	/**
	 * 将录取状态进行改变
	 * @param enrollmentAll
	 * @return
	 */
	@RequestMapping("/edit")
	public Result edit(@RequestBody EnrollmentAll enrollmentAll){
		try {
			noneAdmittedService.edit(enrollmentAll);
		}catch (Exception e){
			return new Result(false,MessageConstant.EDIT_FAIL);
		}
		return new Result(true,MessageConstant.EDIT_SUCCESS);
	}

	@RequestMapping("/findById")
	public Result findById(Integer id){
		try{
			EnrollmentAll enrollmentAll = noneAdmittedService.findById(id);
			return  new Result(true, MessageConstant.QUERY_SUCCESS,enrollmentAll);
		}catch (Exception e){
			e.printStackTrace();
			//服务调用失败
			return new Result(false, MessageConstant.QUERY_FAIL);
		}
	}



}
