package com.service;

import java.util.Map;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-09-22 17:02
 **/
public interface ReportService {
	/**
	 * 获得运营统计数据
	 * Map数据格式：
	 *      todayNewMember -> number
	 *      totalMember -> number
	 *      thisWeekNewMember -> number
	 *      thisMonthNewMember -> number
	 *      todayOrderNumber -> number
	 *      todayVisitsNumber -> number
	 *      thisWeekOrderNumber -> number
	 *      thisWeekVisitsNumber -> number
	 *      thisMonthOrderNumber -> number
	 *      thisMonthVisitsNumber -> number
	 *      hotSetmeals -> List<Setmeal>
	 */
	public Map<String,Object> getBusinessReport() throws Exception;

//	Map<String, Object> getBusinessReportData() throws Exception;
}
