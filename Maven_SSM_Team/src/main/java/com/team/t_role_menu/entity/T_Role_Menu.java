package com.team.t_role_menu.entity;

import com.team.util.Page;

public class T_Role_Menu {

	private String rmid;
	private String roleid;
	private String menuid;
	private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getRmid() {
		return rmid;
	}

	public void setRmid(String rmid) {
		this.rmid = rmid;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
}
