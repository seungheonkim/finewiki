package com.sesac.finewiki.vo;

import java.sql.Date;

public class MemberVo {
	private String mem_id;
	private String mem_pw;
	private String mem_name;
	private String mem_email;
	private String mem_birth;
	private String mem_nick;
	private Date mem_join_date;
	private Date mem_login_date;
	private String mem_signature;
	private String mem_img;
	private int mem_point;

	public MemberVo() {

	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_birth() {
		return mem_birth;
	}

	public void setMem_birth(String mem_birth) {
		this.mem_birth = mem_birth;
	}

	public String getMem_nick() {
		return mem_nick;
	}

	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}

	public Date getMem_join_date() {
		return mem_join_date;
	}

	public void setMem_join_date(Date mem_join_date) {
		this.mem_join_date = mem_join_date;
	}

	public Date getMem_login_date() {
		return mem_login_date;
	}

	public void setMem_login_date(Date mem_login_date) {
		this.mem_login_date = mem_login_date;
	}

	public String getMem_signature() {
		return mem_signature;
	}

	public void setMem_signature(String mem_signature) {
		this.mem_signature = mem_signature;
	}

	public String getMem_img() {
		return mem_img;
	}

	public void setMem_img(String mem_img) {
		this.mem_img = mem_img;
	}

	public int getMem_point() {
		return mem_point;
	}

	public void setMem_point(int mem_point) {
		this.mem_point = mem_point;
	}

	@Override
	public String toString() {
		return "MemberVo [mem_id=" + mem_id + ", mem_pw=" + mem_pw + ", mem_name=" + mem_name + ", mem_email="
				+ mem_email + ", mem_birth=" + mem_birth + ", mem_nick=" + mem_nick + ", mem_join_date=" + mem_join_date
				+ ", mem_login_date=" + mem_login_date + ", mem_signature=" + mem_signature + ", mem_img=" + mem_img
				+ ", mem_point=" + mem_point + "]";
	}

}
