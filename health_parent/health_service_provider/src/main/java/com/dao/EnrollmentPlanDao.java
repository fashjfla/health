package com.dao;


import com.github.pagehelper.Page;
import com.pojo.EnrollmentAll;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-08 23:28
 **/
@Mapper
public interface EnrollmentPlanDao {
	List<EnrollmentAll> query();

	void add(EnrollmentAll enrollmentAll);

	void edit(EnrollmentAll enrollmentAll);

	EnrollmentAll findById(Integer id);

	void delete(Integer id);

	Page<EnrollmentAll> selectByCondition(String queryString);
}
