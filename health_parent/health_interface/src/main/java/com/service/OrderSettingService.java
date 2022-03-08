package com.service;

import com.pojo.OrderSetting;

import java.util.List;
import java.util.Map;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-09-17 10:12
 **/
public interface OrderSettingService {
	void add(List<OrderSetting> orderSettingList);

	List<Map> getOrderSettingByMonth(String date);

	void editNumberByDate(OrderSetting orderSetting);
}
