package com.service.entrollment;

import com.pojo.EnrollmentAll;

import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-10 21:12
 **/
public interface AdmittedService {
	List<EnrollmentAll> query();

	void edit(EnrollmentAll enrollmentAll);
}
