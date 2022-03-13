package com.service.enrollment;

import com.dao.enroller.EnrollmentDao;
import com.pojo.EnrollmentAll;
import com.service.entrollment.PreAdmittedService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-10 21:23
 **/
public class PreAdmittedServiceImpl implements PreAdmittedService {

	@Autowired
	EnrollmentDao enrollmentDao;

	public List<EnrollmentAll> query() {
		return enrollmentDao.query();
	}

	public void edit(EnrollmentAll enrollmentAll) {
       enrollmentDao.edit(enrollmentAll);
	}
}
