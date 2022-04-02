package com.pojo;

import lombok.Data;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2022-04-01 23:02
 **/
@Data
public class EnrollmentPolicy {
	private Integer id;
	private String preRemark;
	private String noneRemark;
	private String remark;
	private String noRemark;
	private Integer flag;
}
