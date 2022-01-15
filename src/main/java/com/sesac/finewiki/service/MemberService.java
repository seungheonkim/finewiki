package com.sesac.finewiki.service;

import java.sql.Date;

import com.sesac.finewiki.vo.LoginDTO;
import com.sesac.finewiki.vo.MemberVo;

public interface MemberService {

	// 회원가입처리
	void register(MemberVo memberVo) throws Exception;

	// 로그인 처리
	MemberVo login(LoginDTO loginDTO) throws Exception;

	// 로그인 유지
	void keepLogin(String mem_id, String session_id, Date sessionLimit) throws Exception;

	// 회원정보 조회
	MemberVo checkLoginBefore(String value) throws Exception;

}
