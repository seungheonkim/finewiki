package com.sesac.finewiki.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.paging.SearchCriteria;
import com.sesac.finewiki.persistence.BoardDAO;
import com.sesac.finewiki.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDAO boardDAO;

	@Inject
	public BoardServiceImpl(BoardDAO vo) {
		this.boardDAO = vo;
	}

	@Override
	public void create(BoardVo vo) throws Exception {
		boardDAO.create(vo);
	}

	@Override
	public BoardVo read(Integer data_no) throws Exception {
		return boardDAO.read(data_no);
	}

	@Override
	public void update(BoardVo vo) throws Exception {
		boardDAO.update(vo);
	}

	@Override
	public void delete(Integer data_no) throws Exception {
		boardDAO.delete(data_no);
	}

	@Override
	public List<BoardVo> listAll() throws Exception {
		return boardDAO.listAll();
	}

	@Override
	public List<BoardVo> listCriteria(Criteria criteria) throws Exception {
		return boardDAO.listCriteria(criteria);
	}

	@Override
	public int countBoards(Criteria criteria) throws Exception {
		return boardDAO.countBoards(criteria);
	}

	@Override
	public List<BoardVo> listSearch(SearchCriteria searchCriteria) throws Exception {
		return boardDAO.listSearch(searchCriteria);
	}

	@Override
	public int countSearchedBoards(SearchCriteria searchCriteria) throws Exception {
		return boardDAO.countSearchedBoards(searchCriteria);
	}

}
