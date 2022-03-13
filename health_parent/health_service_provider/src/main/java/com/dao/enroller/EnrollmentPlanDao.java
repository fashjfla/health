package com.dao.enroller;

import com.pojo.EnrollmentPlan;

import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-08 23:28
 **/
public interface EnrollmentPlanDao {
	List<EnrollmentPlan> query();

	void add(EnrollmentPlan enrollmentPlan);

	void edit(EnrollmentPlan enrollmentPlan);
}
