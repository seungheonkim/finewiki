package com.sesac.finewiki.vo;

public class MemberVo {
	private String mem_id, mem_name, mem_email, mem_pw, mem_birth, mem_nick;

	public MemberVo() {

	}

	public MemberVo(String mem_id, String mem_name, String mem_email, String mem_pw, String mem_birth,
			String mem_nick) {
		super();
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_email = mem_email;
		this.mem_pw = mem_pw;
		this.mem_birth = mem_birth;
		this.mem_nick = mem_nick;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
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

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
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

	@Override
	public String toString() {
		return "MemberVo [mem_id=" + mem_id + ", mem_name=" + mem_name + ", mem_email=" + mem_email + ", mem_pw="
				+ mem_pw + ", mem_birth=" + mem_birth + ", mem_nick=" + mem_nick + "]";
	}

}
