package com.service.entrollment;




import com.entity.PageResult;
import com.entity.QueryPageBean;
import com.pojo.EnrollmentPolicy;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-10 20:36
 **/

public interface NoticeService {



	void edit(EnrollmentPolicy enrollmentPolicy);

	PageResult pageQuery(QueryPageBean queryPageBean);

	EnrollmentPolicy findById(Integer id);
}
