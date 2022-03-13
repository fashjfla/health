package com.dao.enroller;

import com.pojo.EnrollmentAll;

import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-08 22:50
 **/
public interface EnrollmentDao {

	List<EnrollmentAll> query();

	void add(EnrollmentAll enrollmentAll);

	void edit(EnrollmentAll enrollmentAll);
}
