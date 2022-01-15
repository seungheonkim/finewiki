package com.sesac.finewiki.persistence;

import java.util.List;

import com.sesac.finewiki.vo.MemberVo;

public interface MemberDAO {
	void create(MemberVo vo) throws Exception;

	MemberVo read(Integer article_no) throws Exception;

	void update(MemberVo vo) throws Exception;

	void delete(String mem_id) throws Exception;

	List<MemberVo> listAll() throws Exception;
}
