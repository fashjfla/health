package com.dao;


import com.github.pagehelper.Page;
import com.pojo.EnrollmentAll;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-08 22:50
 **/
@Mapper
public interface EnrollmentDao {

	List<EnrollmentAll> query();

	void add(EnrollmentAll enrollmentAll);

	void edit(EnrollmentAll enrollmentAll);

	Page<EnrollmentAll> selectByCondition(String queryString);

	EnrollmentAll findById(Integer id);
}
