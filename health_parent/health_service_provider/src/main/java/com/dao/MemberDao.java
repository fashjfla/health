package com.dao;

import com.github.pagehelper.Page;
import com.pojo.Member;

import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-09-18 15:09
 **/
public interface MemberDao {
	public List<Member> findAll();
	public Page<Member> selectByCondition(String queryString);
	public void add(Member member);
	public void deleteById(Integer id);
	public Member findById(Integer id);
	public Member findByTelephone(String telephone);
	public void edit(Member member);
	public Integer findMemberCountBeforeDate(String date);
	public Integer findMemberCountByDate(String date);
	public Integer findMemberCountAfterDate(String date);
	public Integer findMemberTotalCount();
}
