package com.team.customer.entity;

import com.team.util.Page;

public class Customer {
	private String cid;
	private String cname;
	private String cpwd;
	private String address;
	private String sex;
	private String phone;
	private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCpwd() {
		return cpwd;
	}

	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
