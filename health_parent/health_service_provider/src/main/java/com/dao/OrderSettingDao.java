package com.dao;

import com.pojo.OrderSetting;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-09-17 10:14
 **/
public interface OrderSettingDao {
	public void add(OrderSetting orderSetting);
	//更新可预约人数
	public void editNumberByOrderDate(OrderSetting orderSetting);
	public long findCountByOrderDate(Date orderDate);

	//根据日期范围查询预约设置信息
	List<OrderSetting> getOrderSettingByMonth(Map map);


	OrderSetting findByOrderDate(Date date);
	//更新已预约人数
	void editReservationsByOrderDate(OrderSetting orderSetting);
}
