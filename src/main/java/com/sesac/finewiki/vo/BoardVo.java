package com.sesac.finewiki.vo;

public class BoardVo {
	private int data_no, board_no, hit;
	private String mem_nick, title, content, regdate;
	private int replyCnt;
	private String memberImg;
	private MemberVo vo;
	
	public BoardVo() {
		// TODO Auto-generated constructor stub
	}

	public BoardVo(int data_no, int board_no, int hit, String mem_nick, String title, String content, String regdate,
			int replyCnt, String memberImg, MemberVo vo) {
		super();
		this.data_no = data_no;
		this.board_no = board_no;
		this.hit = hit;
		this.mem_nick = mem_nick;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.replyCnt = replyCnt;
		this.memberImg = memberImg;
		this.vo = vo;
	}

	public int getData_no() {
		return data_no;
	}

	public void setData_no(int data_no) {
		this.data_no = data_no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getMem_nick() {
		return mem_nick;
	}

	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getReplyCnt() {
		return replyCnt;
	}

	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}

	public String getMemberImg() {
		return memberImg;
	}

	public void setMemberImg(String memberImg) {
		this.memberImg = memberImg;
	}

	public MemberVo getMemberVo() {
		return vo;
	}

	public void setMemberVo(MemberVo vo) {
		this.vo = vo;
	}

	@Override
	public String toString() {
		return "BoardVo [data_no=" + data_no + ", board_no=" + board_no + ", hit=" + hit + ", mem_nick=" + mem_nick
				+ ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", replyCnt=" + replyCnt
				+ ", memberImg=" + memberImg + ", vo=" + vo + "]";
	}
	
}
