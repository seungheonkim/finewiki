package com.sesac.finewiki.service;

import java.sql.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sesac.finewiki.persistence.MemberDAO;
import com.sesac.finewiki.vo.LoginDTO;
import com.sesac.finewiki.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {

	private final MemberDAO memberDAO;

	@Inject
	public MemberServiceImpl(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	// 회원 가입 처리
	@Override
	public void register(MemberVo memberVo) throws Exception {
		memberDAO.register(memberVo);
	}

	@Override
	public MemberVo login(LoginDTO loginDTO) throws Exception {
		return memberDAO.login(loginDTO);
	}

	@Override
	public void keepLogin(String mem_id, String session_id, Date sessionLimit) throws Exception {
		memberDAO.keepLogin(mem_id, session_id, sessionLimit);
	}

	@Override
	public MemberVo checkLoginBefore(String value) throws Exception {
		return memberDAO.checkUserWithSessionKey(value);
	}

}
