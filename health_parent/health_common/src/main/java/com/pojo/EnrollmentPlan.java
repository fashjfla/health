package com.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-08 22:25
 **/
@Data
public class EnrollmentPlan implements Serializable {
	private Integer id;
	private Integer enrollment;//招生人数
	private String testKind;//
	private String school;//学校
	private String age;//年龄条件
	private String address;//户籍条件
	private String remark;//备注
	private Date date;//报名日期

}
