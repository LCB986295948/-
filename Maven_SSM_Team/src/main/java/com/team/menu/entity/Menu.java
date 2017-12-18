package com.team.menu.entity;




import com.team.util.Page;

public class Menu {
	private String mid;
	private String mname;
	private String mdescirbe;
	private String isadmin;
	private String fid;
	private Page page;





	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMdescirbe() {
		return mdescirbe;
	}

	public void setMdescirbe(String mdescirbe) {
		this.mdescirbe = mdescirbe;
	}

	public String getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}
}
