package com.service;

import com.pojo.Member;

import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-09-22 9:18
 **/
public interface MemberService {
	void add(Member member);

	Member findByTelephone(String telephone);

	List<Integer> findMemberCountByMonth(List<String> month);
}
