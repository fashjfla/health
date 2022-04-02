package com.service.enrollment;


import com.alibaba.dubbo.config.annotation.Service;
import com.dao.NoticeDao;
import com.entity.PageResult;
import com.entity.QueryPageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pojo.EnrollmentPolicy;
import com.service.entrollment.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-10 20:36
 **/
@Service(interfaceClass = NoticeService.class)
@Transactional
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDao noticeDao;



	public void edit(EnrollmentPolicy enrollmentPolicy) {
       noticeDao.edit(enrollmentPolicy);
	}

	public PageResult pageQuery(QueryPageBean queryPageBean) {
		Integer currentPage = queryPageBean.getCurrentPage();
		Integer pageSize = queryPageBean.getPageSize();
		String queryString = queryPageBean.getQueryString();//查询条件
		//完成分页查询，基于mybatis框架提供的分页助手插件完成
		PageHelper.startPage(currentPage,pageSize);
		//select * from t_checkitem limit 0,10
		Page<EnrollmentPolicy> page = noticeDao.selectByCondition(queryString);

		long total = page.getTotal();

		return new PageResult(total,page.getResult());
	}

	public EnrollmentPolicy findById(Integer id) {
		return noticeDao.findById(id);
	}
}
