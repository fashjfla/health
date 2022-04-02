package com.service.enrollment;


import com.dao.EnrollmentDao;
import com.entity.PageResult;
import com.entity.QueryPageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pojo.EnrollmentAll;
import com.service.entrollment.AdmittedService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-10 21:13
 **/

@Service(interfaceClass = AdmittedService.class)
@Transactional
public class AdmittedServiceImpl implements AdmittedService {

	@Autowired
	EnrollmentDao enrollmentDao;

	public List<EnrollmentAll> query() {
		return enrollmentDao.query();
	}

	public void edit(EnrollmentAll enrollmentAll) {
		enrollmentDao.edit(enrollmentAll);
	}

	public PageResult pageQuery(QueryPageBean queryPageBean) {
		Integer currentPage = queryPageBean.getCurrentPage();
		Integer pageSize = queryPageBean.getPageSize();
		String queryString = queryPageBean.getQueryString();//查询条件
		//完成分页查询，基于mybatis框架提供的分页助手插件完成
		PageHelper.startPage(currentPage,pageSize);
		//select * from t_checkitem limit 0,10
		Page<EnrollmentAll> page = enrollmentDao.selectByCondition(queryString);


		List<EnrollmentAll> rows = page.getResult();
		List<EnrollmentAll> enrollmentAllList = new ArrayList<EnrollmentAll>();
		for (EnrollmentAll row : rows) {

			if (StringUtils.isNotEmpty(row.getEndDate())){
				String end = row.getEndDate().substring(0, 10);
				row.setEndDate(end);
			}
			if (StringUtils.isNotEmpty(row.getStartDate())){
				String start = row.getStartDate().substring(0, 10);
				row.setStartDate(start);
			}
			if ("S".equals(row.getAdmissionStatus())){
				row.setAdmissionStatus("已录取");
				enrollmentAllList.add(row);
			}
		}
		long total = enrollmentAllList.size();

		return new PageResult(total,enrollmentAllList);
	}

	public EnrollmentAll findById(Integer id) {
		return enrollmentDao.findById(id);
	}
}