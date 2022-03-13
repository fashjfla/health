package com.service.entrollment;

import com.alibaba.dubbo.config.annotation.Service;
import com.pojo.EnrollmentAll;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-10 20:36
 **/

public interface NoneAdmittedService {


	List<EnrollmentAll> query();

	void edit(EnrollmentAll enrollmentAll);
}
