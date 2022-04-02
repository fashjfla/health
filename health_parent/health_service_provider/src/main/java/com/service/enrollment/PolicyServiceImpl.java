package com.service.enrollment;

import com.alibaba.dubbo.config.annotation.Service;
import com.dao.EnrollmentPlanDao;
import com.entity.PageResult;
import com.entity.QueryPageBean;
import com.github.pagehelper.PageHelper;
import com.pojo.EnrollmentAll;
import com.service.entrollment.PolicyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;


import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-08 22:00
 **/
@Service(interfaceClass = PolicyService.class)
@Transactional
public class PolicyServiceImpl implements PolicyService {
	@Autowired
	EnrollmentPlanDao enrollmentPlanDao;

	public List<EnrollmentAll> query() {
		return enrollmentPlanDao.query();
	}

	public void add(EnrollmentAll enrollmentAll) {
		enrollmentPlanDao.add(enrollmentAll);
	}

	public void edit(EnrollmentAll enrollmentAll) {

		enrollmentPlanDao.edit(enrollmentAll);
	}

	public EnrollmentAll findById(Integer id) {
		return enrollmentPlanDao.findById(id);
	}

	public void delete(Integer id) {
		enrollmentPlanDao.delete(id);
	}

	public PageResult pageQuery(QueryPageBean queryPageBean) {
		Integer currentPage = queryPageBean.getCurrentPage();
		Integer pageSize = queryPageBean.getPageSize();
		String queryString = queryPageBean.getQueryString();//查询条件
		//完成分页查询，基于mybatis框架提供的分页助手插件完成
		PageHelper.startPage(currentPage,pageSize);
		//select * from t_checkitem limit 0,10
		Page<EnrollmentAll> page = enrollmentPlanDao.selectByCondition(queryString);

		long total = page.getTotal();

		List<EnrollmentAll> rows = page.getResult();
		for (EnrollmentAll row : rows) {
			if ("S".equals(row.getPeriod())){
				row.setPeriod("小学");
			}else if("M".equals(row.getPeriod())){
				row.setPeriod("初中");
			}else if("H".equals(row.getPeriod())){
				row.setPeriod("高中");
			}
			if (StringUtils.isNotEmpty(row.getEndDate())){
				String end = row.getEndDate().substring(0, 10);
				row.setEndDate(end);
			}
			if (StringUtils.isNotEmpty(row.getStartDate())){
				String start = row.getStartDate().substring(0, 10);
				row.setStartDate(start);
			}
		}

		return new PageResult(total,rows);
	}
}
