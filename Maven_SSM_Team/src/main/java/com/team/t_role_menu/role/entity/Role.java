package com.team.role.entity;

import com.team.util.Page;

public class Role {

	private String rid;
	private String rname;
	private String rdescirbe;
	private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRdescirbe() {
		return rdescirbe;
	}

	public void setRdescirbe(String rdescirbe) {
		this.rdescirbe = rdescirbe;
	}
}
