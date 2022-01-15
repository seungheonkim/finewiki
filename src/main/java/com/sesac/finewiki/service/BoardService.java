package com.sesac.finewiki.service;

import java.util.List;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.vo.BoardVo;

public interface BoardService {
	void create(BoardVo boardVo) throws Exception;

	BoardVo read(Integer data_no) throws Exception;

    void update(BoardVo boardVo) throws Exception;

    void delete(Integer data_no) throws Exception;

    List<BoardVo> listAll() throws Exception;
    
    List<BoardVo> listCriteria(Criteria criteria) throws Exception;
}
