package com.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dao.MemberDao;
import com.pojo.Member;
import com.service.MemberService;
import com.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-09-22 9:20
 **/
@Service(interfaceClass = MemberService.class)
@Transactional
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	//根据手机号查询会员
	public Member findByTelephone(String telephone) {

		return memberDao.findByTelephone(telephone);
	}

	//根据月份统计会员数量
	public List<Integer> findMemberCountByMonth(List<String> month) {
		List<Integer> list = new ArrayList<Integer>();
		for(String m : month){
			m = m + ".31";//格式：2019.04.31
			Integer count = memberDao.findMemberCountBeforeDate(m);
			list.add(count);
		}
		return list;
	}

	//保存会员信息
	public void add(Member member){
		String password = member.getPassword();
		if (password!=null){
			//使用md5将明文密码加密
			password = MD5Utils.md5(password);
			member.setPassword(password);
		}
		memberDao.add(member);
	}
}
