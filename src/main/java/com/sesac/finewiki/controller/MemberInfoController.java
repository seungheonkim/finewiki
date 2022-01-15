package com.sesac.finewiki.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sesac.finewiki.service.BoardService;
import com.sesac.finewiki.service.MemberService;
import com.sesac.finewiki.service.ReplyService;
import com.sesac.finewiki.vo.BoardVo;
import com.sesac.finewiki.vo.MemberVo;
import com.sesac.finewiki.vo.ReplyVo;

@Controller
@RequestMapping("/member")
public class MemberInfoController {
	private static final Logger logger = LoggerFactory.getLogger(MemberInfoController.class);

	@Inject
	private MemberService memberService;

	@Inject
	private BoardService boardService;

	@Inject
	private ReplyService replyService;

	@Resource(name = "mem_imagePath")
	private String mem_imagePath;

	// 회원 프로필 이미지 수정처리
	@RequestMapping(value = "/modify/image", method = RequestMethod.POST)
	public String memberImgModify(String mem_id, MultipartFile file, HttpSession session,
			RedirectAttributes redirectAttributes) throws Exception {
		if (file == null) {
			redirectAttributes.addFlashAttribute("msg", "FAIL");
			return "redirect:/member/profile";
		}

		String uploadFile = UploadFileUtils.uploadFile(mem_imagePath, file.getOriginalFilename(), file.getBytes());

		String front = uploadFile.substring(0, 12);

		String end = uploadFile.substring(14);

		String mem_img = front + end;

		memberService.modifyMem_image(mem_id, mem_img);

		Object memberObj = session.getAttribute("login");

		MemberVo vo = (MemberVo) memberObj;

		vo.setMem_img(mem_img);

		session.setAttribute("login", vo);

		redirectAttributes.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/member/profile";

	}

	// 회원정보 수정처리
	@RequestMapping(value = "/modify/info", method = RequestMethod.POST)
	public String userInfoModify(MemberVo vo, HttpSession session, RedirectAttributes redirectAttributes)
			throws Exception {
		logger.info(vo.toString());
		MemberVo oldUserInfo = memberService.getMember(vo.getMem_id());
		logger.info(oldUserInfo.toString());
		logger.info("1");
		if (!BCrypt.checkpw(vo.getMem_pw(), oldUserInfo.getMem_pw())) {
			redirectAttributes.addFlashAttribute("msg", "FAILURE");
			logger.info("2");
			return "redirect:/member/profile";
		}
		logger.info("3");
		memberService.modifyMember(vo);
		vo.setMem_join_date(oldUserInfo.getMem_join_date());
		vo.setMem_login_date(oldUserInfo.getMem_login_date());
		vo.setMem_img(oldUserInfo.getMem_img());
		session.setAttribute("login", vo);
		redirectAttributes.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/member/profile";
	}

	// 회원 비밀번호 수정처리
	@RequestMapping(value = "/modify/pw", method = RequestMethod.POST)
	public String memberPwModify(@RequestParam("mem_id") String mem_id, @RequestParam("oldPw") String oldPw,
			@RequestParam("newPw") String newPw, HttpSession session, RedirectAttributes redirectAttributes)
			throws Exception {

		MemberVo memberInfo = memberService.getMember(mem_id);

		if (!BCrypt.checkpw(oldPw, memberInfo.getMem_pw())) {
			redirectAttributes.addFlashAttribute("msg", "FAILURE");
			return "redirect:/member/profile";
		}

		String newHashPw = BCrypt.hashpw(newPw, BCrypt.gensalt());

		memberInfo.setMem_pw(newHashPw);

		memberService.modifyPw(memberInfo);

		session.setAttribute("login", memberInfo);

		redirectAttributes.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/member/profile";
	}

	// 회원 정보 페이지
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(HttpSession session, Model model) throws Exception {

		Object memberObj = session.getAttribute("login");

		MemberVo vo = (MemberVo) memberObj;

		String mem_id = vo.getMem_id();

		List<BoardVo> memberBoardList = boardService.memberBoardList(mem_id);

		List<ReplyVo> memberReplies = replyService.memberReplies(mem_id);

		model.addAttribute("memberBoardList", memberBoardList);

		model.addAttribute("memberReplies", memberReplies);

		return "member/profile";
	}

}
