package com.service.entrollment;

import com.pojo.EnrollmentAll;

import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-10 21:22
 **/
public interface PreAdmittedService {
	List<EnrollmentAll> query();

	void edit(EnrollmentAll enrollmentAll);
}
