package com.sesac.finewiki.persistence;


import java.sql.Date;

import com.sesac.finewiki.vo.LoginDTO;
import com.sesac.finewiki.vo.MemberVo;

public interface MemberDAO {
	
	//회원가입처리
	void register(MemberVo memberVo) throws Exception;
	
	// 로그인 처리
	MemberVo login(LoginDTO loginDTO) throws Exception;
	
	// 로그인 유지 처리 
	void keepLogin(String mem_id, String session_id, Date sessionLimit) throws Exception; 
	
	// 세션키 검증 
	MemberVo checkUserWithSessionKey(String value) throws Exception;
	
}
