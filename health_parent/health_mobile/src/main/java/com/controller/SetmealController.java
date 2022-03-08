package com.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.constant.MessageConstant;
import com.entity.Result;
import com.pojo.Setmeal;
import com.service.SetmealService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-09-17 17:35
 **/
@RestController
@RequestMapping("/setmeal")
public class SetmealController {
	@Reference//(check = false)
	private SetmealService setmealService;

	//获取所有套餐信息
	@RequestMapping("/getAllSetmeal")
	public Result getSetmeal(){
		try{
			List<Setmeal> list = setmealService.findAll();
			return new Result(true, MessageConstant.GET_SETMEAL_LIST_SUCCESS,list);
		}catch (Exception e){
			e.printStackTrace();
			return new Result(false,MessageConstant.GET_SETMEAL_LIST_FAIL);
		}
	}

	//根据id查询套餐信息
	@RequestMapping("/findById")
	public Result findById(int id){
		try{
			Setmeal setmeal = setmealService.findById(id);
			return new Result(true,MessageConstant.QUERY_SETMEAL_SUCCESS,setmeal);
		}catch (Exception e){
			e.printStackTrace();
			return new Result(false,MessageConstant.QUERY_SETMEAL_FAIL);
		}
	}
}
