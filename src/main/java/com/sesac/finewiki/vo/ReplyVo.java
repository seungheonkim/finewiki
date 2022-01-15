package com.sesac.finewiki.vo;

import java.sql.Date;

public class ReplyVo {
	private Integer reply_no;
	private Integer data_no;
	private String reply_text;
	private String reply_writer;
	private Date reg_date;
	private Date update_date;

	public ReplyVo() {
		// TODO Auto-generated constructor stub
	}

	public ReplyVo(Integer reply_no, Integer data_no, String reply_text, String reply_writer, Date reg_date,
			Date update_date) {
		super();
		this.reply_no = reply_no;
		this.data_no = data_no;
		this.reply_text = reply_text;
		this.reply_writer = reply_writer;
		this.reg_date = reg_date;
		this.update_date = update_date;
	}

	public Integer getReply_no() {
		return reply_no;
	}

	public void setReply_no(Integer reply_no) {
		this.reply_no = reply_no;
	}

	public Integer getData_no() {
		return data_no;
	}

	public void setData_no(Integer data_no) {
		this.data_no = data_no;
	}

	public String getReply_text() {
		return reply_text;
	}

	public void setReply_text(String reply_text) {
		this.reply_text = reply_text;
	}

	public String getReply_writer() {
		return reply_writer;
	}

	public void setReply_writer(String reply_writer) {
		this.reply_writer = reply_writer;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	@Override
	public String toString() {
		return "ReplyVo [reply_no=" + reply_no + ", data_no=" + data_no + ", reply_text=" + reply_text
				+ ", reply_writer=" + reply_writer + ", reg_date=" + reg_date + ", update_date=" + update_date + "]";
	}

}
