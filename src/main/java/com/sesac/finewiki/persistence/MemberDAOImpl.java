package com.sesac.finewiki.persistence;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sesac.finewiki.vo.LoginDTO;
import com.sesac.finewiki.vo.MemberVo;

@Repository
public class MemberDAOImpl implements MemberDAO {

	private static final String NAMESPACE = "com.sesac.finewiki.mappers.member.memberMapper";

	private final SqlSession sqlSession;

	@Inject
	public MemberDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 회원가입처리
	@Override
	public void register(MemberVo memberVo) throws Exception {
		sqlSession.insert(NAMESPACE + ".register", memberVo);
	}

	// 로그인 처리
	@Override
	public MemberVo login(LoginDTO loginDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".login", loginDTO);
	}

	// 로그인 유지 처리
	@Override
	public void keepLogin(String mem_id, String session_id, Date sessionLimit) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mem_id", mem_id);
		paramMap.put("session_id", session_id);
		paramMap.put("sessionLimit", sessionLimit);
		sqlSession.update(NAMESPACE + ".keepLogin", paramMap);

	}

	// 세션키 검증
	@Override
	public MemberVo checkUserWithSessionKey(String value) throws Exception {
		return null;
	}

}
