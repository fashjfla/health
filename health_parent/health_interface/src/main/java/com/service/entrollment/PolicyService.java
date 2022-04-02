package com.service.entrollment;




import com.entity.PageResult;
import com.entity.QueryPageBean;
import com.pojo.EnrollmentAll;

import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-08 22:07
 **/
public interface PolicyService {
	List<EnrollmentAll> query();

	void add(EnrollmentAll enrollmentAll);

	void edit(EnrollmentAll enrollmentAll);

	EnrollmentAll findById(Integer id);

	void delete(Integer id);


	PageResult pageQuery(QueryPageBean queryPageBean);
}
