package com.service.entrollment;

import com.pojo.EnrollmentPlan;

import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-08 22:07
 **/
public interface PolicyService {
	List<EnrollmentPlan> query();

	void add(EnrollmentPlan enrollmentPlan);

	void edit(EnrollmentPlan enrollmentPlan);
}
