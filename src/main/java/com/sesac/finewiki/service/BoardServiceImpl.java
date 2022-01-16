package com.sesac.finewiki.service;

import java.util.List;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.sesac.finewiki.paging.Criteria;
import com.sesac.finewiki.paging.SearchCriteria;
import com.sesac.finewiki.persistence.BoardDAO;
import com.sesac.finewiki.persistence.BoardFileDAO;
import com.sesac.finewiki.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {
	
    private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);


	private final BoardDAO boardDAO;
	private BoardFileDAO boardFileDAO;

	@Inject
	public BoardServiceImpl(BoardDAO vo) {
		this.boardDAO = vo;
	}

	@Transactional
	@Override
	public void create(BoardVo vo) throws Exception {
		String[] files = vo.getFiles();

		if (files == null) {

			boardDAO.create(vo);
			return;
		}
		vo.setFileCnt(files.length);

		boardDAO.create(vo);
		logger.info("Create - " + vo.toString());
		Integer data_no = vo.getData_no();
		for (String file_name : files) {
			boardFileDAO.addAttach(file_name, data_no);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BoardVo read(Integer data_no) throws Exception {
		boardDAO.updateHit(data_no);
		return boardDAO.read(data_no);
	}

	@Transactional
	@Override
	public void update(BoardVo vo) throws Exception {
	    	
	        
	        int data_no = vo.getData_no();
	        boardFileDAO.deleteAllAttach(data_no);

	        String[] files = vo.getFiles();
	        if (files == null) {
	        	vo.setFileCnt(0);
	            boardDAO.update(vo);
	            return;
	        }

	        vo.setFileCnt(files.length);
	        boardDAO.update(vo);
	        for (String file_name : files) {
	        	boardFileDAO.replaceAttach(file_name, data_no);
	        }
	}

	@Transactional
	@Override
	public void delete(Integer data_no) throws Exception {
		boardFileDAO.deleteAllAttach(data_no);
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

	@Override
	public List<BoardVo> memberBoardList(String mem_id) throws Exception {
		return boardDAO.memberBoardList(mem_id);
	}

}
