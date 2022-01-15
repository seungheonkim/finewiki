package com.sesac.finewiki.vo;

public class BoardVo {
	private int data_no, board_no, hit, goodno;
	private String mem_nick, title, content, regdate;

	public BoardVo() {
		// TODO Auto-generated constructor stub
	}

	public BoardVo(int data_no, int board_no, int hit, int goodno, String mem_nick, String title, String content,
			String regdate) {
		super();
		this.data_no = data_no;
		this.board_no = board_no;
		this.hit = hit;
		this.goodno = goodno;
		this.mem_nick = mem_nick;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
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

	public int getGoodno() {
		return goodno;
	}

	public void setGoodno(int goodno) {
		this.goodno = goodno;
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

	@Override
	public String toString() {
		return "BoardVo [data_no=" + data_no + ", board_no=" + board_no + ", hit=" + hit + ", goodno=" + goodno
				+ ", mem_nick=" + mem_nick + ", title=" + title + ", content=" + content + ", regdate=" + regdate + "]";
	}

}