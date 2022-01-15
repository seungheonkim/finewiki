package com.sesac.finewiki.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sesac.finewiki.service.BoardService;
import com.sesac.finewiki.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	 private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	    private final BoardService boardService;

	    @Inject
	    public BoardController(BoardService boardService) {
	        this.boardService = boardService;
	    }
	    
	 // 등록 페이지 이동
	    @RequestMapping(value = "/write", method = RequestMethod.GET)
	    public String writeGET() {

	        logger.info("write GET...");

	        return "/board/write";
	    }
	    
	 // 등록 처리
	    @RequestMapping(value = "/write", method = RequestMethod.POST)
	    public String writePOST(BoardVo boardVo,
	                            RedirectAttributes redirectAttributes) throws Exception {

	        logger.info("write POST...");
	        logger.info(boardVo.toString());
	        boardService.create(boardVo);;
	        redirectAttributes.addFlashAttribute("msg", "regSuccess");

	        return "redirect:/board/list";
	    }
	    
	 // 목록 페이지 이동
	    @RequestMapping(value = "/list", method = RequestMethod.GET)
	    public String list(Model model) throws Exception {

	        logger.info("list ...");
	        model.addAttribute("boards", boardService.listAll());

	        return "/board/list";
	    }
	    
	 // 조회 페이지 이동
	    @RequestMapping(value = "/read", method = RequestMethod.GET)
	    public String read(@RequestParam("data_no") int data_no,
	                       Model model) throws Exception {

	        logger.info("read ...");
	        model.addAttribute("board", boardService.read(data_no));

	        return "/board/read";
	    }
	    
	 // 수정 페이지 이동
	    @RequestMapping(value = "/modify", method = RequestMethod.GET)
	    public String modifyGET(@RequestParam("data_no") int data_no,
	                            Model model) throws Exception {

	        logger.info("modifyGet ...");
	        model.addAttribute("article", boardService.read(data_no));

	        return "/board/modify";
	    }
	    
	 // 수정 처리
	    @RequestMapping(value = "/modify", method = RequestMethod.POST)
	    public String modifyPOST(BoardVo boardVo,
	                             RedirectAttributes redirectAttributes) throws Exception {

	        logger.info("modifyPOST ...");
	        boardService.update(boardVo);
	        redirectAttributes.addFlashAttribute("msg", "modSuccess");

	        return "redirect:/board/list";
	    }
	    
	 // 삭제 처리
	    @RequestMapping(value = "/remove", method = RequestMethod.POST)
	    public String remove(@RequestParam("data_no") int data_no,
	                         RedirectAttributes redirectAttributes) throws Exception {

	        logger.info("remove ...");
	        boardService.delete(data_no);
	        redirectAttributes.addFlashAttribute("msg", "delSuccess");

	        return "redirect:/board/list";
	    }

}
