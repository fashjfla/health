package com.service.enrollment;

import com.alibaba.dubbo.config.annotation.Service;
import com.dao.enroller.EnrollmentPlanDao;
import com.pojo.EnrollmentPlan;
import com.service.entrollment.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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

	public List<EnrollmentPlan> query() {
		return enrollmentPlanDao.query();
	}

	public void add(EnrollmentPlan enrollmentPlan) {
		enrollmentPlanDao.add(enrollmentPlan);
	}

	public void edit(EnrollmentPlan enrollmentPlan) {
		enrollmentPlanDao.edit(enrollmentPlan);
	}
}
