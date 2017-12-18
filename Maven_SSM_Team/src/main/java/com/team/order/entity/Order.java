package com.team.order.entity;

import com.team.util.Page;

public class Order {
	private String orderid;
	private String address;
	private String time;
	private String state;
	private String odescirbe;
	private String userid;
	private String cid;
	private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOdescirbe() {
		return odescirbe;
	}

	public void setOdescirbe(String odescirbe) {
		this.odescirbe = odescirbe;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

}
