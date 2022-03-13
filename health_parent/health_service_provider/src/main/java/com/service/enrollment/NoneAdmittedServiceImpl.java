package com.service.enrollment;

import com.alibaba.dubbo.config.annotation.Service;
import com.dao.enroller.EnrollmentDao;
import com.pojo.EnrollmentAll;
import com.service.entrollment.NoneAdmittedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-10 20:36
 **/
@Service(interfaceClass = NoneAdmittedService.class)
@Transactional
public class NoneAdmittedServiceImpl implements NoneAdmittedService {

	@Autowired
	EnrollmentDao enrolledDao;

	public List<EnrollmentAll> query() {
		return enrolledDao.query();
	}

	public void edit(EnrollmentAll enrollmentAll) {
       enrolledDao.edit(enrollmentAll);
	}
}
