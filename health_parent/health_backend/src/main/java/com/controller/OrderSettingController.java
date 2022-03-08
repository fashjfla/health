package com.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.constant.MessageConstant;
import com.entity.Result;
import com.pojo.OrderSetting;
import com.service.OrderSettingService;
import com.utils.POIUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 预约设置
 */
@RestController
@RequestMapping("/ordersetting")
public class OrderSettingController {

	@Reference
	private OrderSettingService orderSettingService;

    //文件上传，实现预约设置数据批量导入
	@RequestMapping("/upload")
	public Result upload(@RequestParam("excelFile") MultipartFile excelFile){
		try {
			//读取Excel文件数据
			List<String[]> list = POIUtils.readExcel(excelFile);
			if(list != null && list.size() > 0){
				List<OrderSetting> orderSettingList = new ArrayList<>();
				for (String[] strings : list) {
					OrderSetting orderSetting =
							new OrderSetting(new Date(strings[0]), Integer.parseInt(strings[1]));
					orderSettingList.add(orderSetting);
				}
				orderSettingService.add(orderSettingList);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return new Result(false, MessageConstant.IMPORT_ORDERSETTING_FAIL);
		}
		return new Result(true,MessageConstant.IMPORT_ORDERSETTING_SUCCESS);
	}

	/**
	 * 根据日期查询预约设置数据(获取指定日期所在月份的预约设置数据)
	 * @param date
	 * @return
	 */
	@RequestMapping("/getOrderSettingByMonth")
	public Result getOrderSettingByMonth(String date){//参数格式为：2019-03
		try{
			List<Map> list = orderSettingService.getOrderSettingByMonth(date);
			//获取预约设置数据成功
			return new Result(true,MessageConstant.GET_ORDERSETTING_SUCCESS,list);
		}catch (Exception e){
			e.printStackTrace();
			//获取预约设置数据失败
			return new Result(false,MessageConstant.GET_ORDERSETTING_FAIL);
		}
	}

	/**
	 * 根据指定日期修改可预约人数
	 * @param orderSetting
	 * @return
	 */
	@RequestMapping("/editNumberByDate")
	public Result editNumberByDate(@RequestBody OrderSetting orderSetting){
		try{
			orderSettingService.editNumberByDate(orderSetting);
			//预约设置成功
			return new Result(true,MessageConstant.ORDERSETTING_SUCCESS);
		}catch (Exception e){
			e.printStackTrace();
			//预约设置失败
			return new Result(false,MessageConstant.ORDERSETTING_FAIL);
		}
	}
	}

