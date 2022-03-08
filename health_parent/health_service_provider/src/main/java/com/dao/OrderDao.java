package com.dao;

import com.pojo.Order;

import java.util.List;
import java.util.Map;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-09-18 15:10
 **/
public interface OrderDao {
	List<Order> findByCondition(Order order);

	void add(Order order);

	Map findById4Detail(Integer id);
	Integer findOrderCountByDate(String date);
	Integer findOrderCountAfterDate(String date);
	Integer findVisitsCountByDate(String date);
	Integer findVisitsCountAfterDate(String date);
	List<Map> findHotSetmeal();
}
