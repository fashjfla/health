package com.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-03-08 22:11
 **/
@Data
public class EnrollmentAll implements Serializable {
	private Integer id;//主键
	private String uniqueId;//考号
	private String name;//姓名
	private String sex;//1是男生，0是女生
	private Integer age;//年龄
	private String graduationSchool;//毕业学校
	private String address;//户籍地址
	private String ident;//证件号
	private String parentName;//父/母姓名
	private String phone;//联系电话
	private String date;//报名日期
	private String admissionStatus;//录取状态（U-待录取，R-未录取，A-预录取，S-已录取）
	private String admissionRemark;//
	private String remark;//备注
	private String interviewDate;//面试时间
	private Integer enrollment;//招生人数
	private String admissionBatch;//录取批次
	private String professionCode;//专业代号
	private String professionName;//专业名称
	private String schoolYear;//学制年限
	private float fee;//学费标准
	private String period;//S-小学 M-初中 H-高中
	private Integer people;//报名人数
	private String startDate;
	private String endDate;
	private String ageGroup;
	private String school;//招生学校




}
