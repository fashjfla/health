package com.controller;



import com.alibaba.dubbo.config.annotation.Reference;
import com.constant.MessageConstant;
import com.entity.PageResult;
import com.entity.QueryPageBean;
import com.entity.Result;
import com.pojo.EnrollmentPolicy;
import com.service.entrollment.NoticeService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-08 22:04
 **/
@RestController
@RequestMapping("/notice")
public class NoticeController {

	@Reference
	NoticeService noticeService;

	@RequestMapping("/findPage")
	public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {

		PageResult pageResult = noticeService.pageQuery(queryPageBean);

		System.out.println(pageResult);
		return pageResult;
	}



	@RequestMapping("/edit")
	public Result edit(@RequestBody EnrollmentPolicy enrollmentPolicy){
		try {
			noticeService.edit(enrollmentPolicy);
		}catch (Exception e){
			return new Result(false,MessageConstant.EDIT_FAIL);
		}
		return new Result(true,MessageConstant.EDIT_SUCCESS);
	}

	@RequestMapping("/findById")
	public Result findById(Integer id){
		try{
			EnrollmentPolicy enrollmentPolicy = noticeService.findById(id);
			return  new Result(true, MessageConstant.QUERY_SUCCESS,enrollmentPolicy);
		}catch (Exception e){
			e.printStackTrace();
			//服务调用失败
			return new Result(false, MessageConstant.QUERY_FAIL);
		}
	}



}
