package com.dao;


import com.github.pagehelper.Page;
import com.pojo.EnrollmentPolicy;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-08 22:50
 **/
@Mapper
public interface NoticeDao {



	void edit(EnrollmentPolicy enrollmentPolicy);

	Page<EnrollmentPolicy> selectByCondition(String queryString);

	EnrollmentPolicy findById(Integer id);
}
