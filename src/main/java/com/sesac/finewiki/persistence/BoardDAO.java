package com.sesac.finewiki.persistence;

import java.util.List;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.vo.BoardVo;

public interface BoardDAO {

	void create(BoardVo boardVo) throws Exception;

	BoardVo read(Integer data_no) throws Exception;

    void update(BoardVo boardVo) throws Exception;

    void delete(Integer data_no) throws Exception;

    List<BoardVo> listAll() throws Exception;

    List<BoardVo> listPaging(int page) throws Exception;

    List<BoardVo> listCriteria(Criteria criteria) throws Exception;
    
    int countBoards(Criteria criteria) throws Exception;

}
