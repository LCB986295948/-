package com.team.t_user_role.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.team.t_user_role.entity.T_User_Role;
import com.team.t_user_role.service.T_User_RoleService;
import com.team.util.Page;

import net.sf.json.JSONArray;

@Controller
public class T_User_RoleController {
	@Autowired
	private T_User_RoleService t_user_roleService;

	// 查询全部
	@RequestMapping("/t_user_roleall")
	@ResponseBody
	public String query(String pageno,String pagesize) throws Exception {
		T_User_Role t_user_role = new T_User_Role();
		Page page=new Page();
		page.setPageno(pageno);
		page.setPagesize(pagesize);
		t_user_role.setPage(page);
		List<Map> list = t_user_roleService.query(t_user_role);
		JSONArray json = JSONArray.fromObject(list);
		String param = json.toString();
		param = new String(param.getBytes("ISO-8859-1"), "UTF-8");
		return param;
	}

	// 条件查询
	@RequestMapping("/t_user_role")
	@ResponseBody
	public String queryBy(String urid, String userid, String rid,String pagesize,String pageno) throws Exception {
		T_User_Role t_user_role = new T_User_Role();
		Page page=new Page();
		page.setPageno(pageno);
		page.setPagesize(pagesize);
		t_user_role.setPage(page);
		t_user_role.setRid(rid);
		t_user_role.setUrid(urid);
		t_user_role.setUserid(userid);
		Map<String,Object> map=new HashMap<>();
		map.put("t_user_role", t_user_role);
		List<Map> list = t_user_roleService.queryBy(map);
		JSONArray json = JSONArray.fromObject(list);
		String param = json.toString();
		param = new String(param.getBytes("ISO-8859-1"), "UTF-8");
		return param;
	}

	// 添加
	@RequestMapping("/t_user_roleinsert")
	@ResponseBody
	public String insert(String userid, String rid) throws Exception {
		T_User_Role t_user_role = new T_User_Role();
		t_user_role.setRid(rid);
		t_user_role.setUserid(userid);
		Integer i = t_user_roleService.insert(t_user_role);
		return i.toString();
	}

	// 修改
	@RequestMapping("/t_user_roleupdate")
	@ResponseBody
	public String update(String urid, String userid, String rid) throws Exception {
		if (userid != null) {
			userid = new String(userid.getBytes("ISO-8859-1"), "UTF-8");
		}
		if (rid != null) {
			rid = new String(rid.getBytes("ISO-8859-1"), "UTF-8");
		}
		T_User_Role t_user_role = new T_User_Role();
		t_user_role.setRid(rid);
		t_user_role.setUserid(userid);
		t_user_role.setUrid(urid);
		Integer i = t_user_roleService.update(t_user_role);
		return i.toString();
	}

	// 删除
	@RequestMapping("/t_user_roledelete")
	@ResponseBody
	public String delete(String urid) {
		T_User_Role t_user_role = new T_User_Role();
		t_user_role.setUrid(urid);
		Integer i = t_user_roleService.delete(t_user_role);
		return i.toString();
	}
}
