package com.team.goods.entity;

import com.team.util.Page;

public class Goods {
	private String gid;
	private String gname;
	private String gprice;
	private String ggenre;
	private String gdescirbe;
	private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGprice() {
		return gprice;
	}

	public void setGprice(String gprice) {
		this.gprice = gprice;
	}

	public String getGgenre() {
		return ggenre;
	}

	public void setGgenre(String ggenre) {
		this.ggenre = ggenre;
	}

	public String getGdescirbe() {
		return gdescirbe;
	}

	public void setGdescirbe(String gdescirbe) {
		this.gdescirbe = gdescirbe;
	}

}
