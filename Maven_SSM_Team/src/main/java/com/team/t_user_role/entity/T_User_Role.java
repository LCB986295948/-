package com.team.t_user_role.entity;

import com.team.util.Page;

public class T_User_Role {
	private String urid;
	private String userid;
	private String rid;
	private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getUrid() {
		return urid;
	}

	public void setUrid(String urid) {
		this.urid = urid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

}
