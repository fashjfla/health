package com.service.enrollment;

import com.alibaba.dubbo.config.annotation.Service;
import com.dao.enroller.EnrollmentDao;
import com.pojo.EnrollmentAll;
import com.service.entrollment.AdmittedService;
import com.service.entrollment.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
}
