package com.team.t_role_menu.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.t_role_menu.entity.T_Role_Menu;
import com.team.t_role_menu.service.T_Role_MenuService;
import com.team.util.Page;

import net.sf.json.JSONArray;
@Controller
public class T_Role_MenuController {
	@Autowired
	private T_Role_MenuService t_role_menuService;

	// 查询全部
	@RequestMapping("/t_role_menuall")
	@ResponseBody
	public String query(String pageno,String pagesize) throws Exception {
		Page page=new Page();
		page.setPageno(pageno);
		page.setPagesize(pagesize);
		T_Role_Menu t_role_menu = new T_Role_Menu();
		t_role_menu.setPage(page);
	
		List<Map> list = t_role_menuService.query(t_role_menu);
		JSONArray json = JSONArray.fromObject(list);
		String param = json.toString();
		param = new String(param.getBytes("ISO-8859-1"), "UTF-8");
		return param;
	}

	// 条件查询
	@RequestMapping("/t_role_menu")
	@ResponseBody
	public String queryBy(String rmid, String roleid, String menuid,String pagesize,String pageno) throws Exception {
		Page page=new Page();
		page.setPageno(pageno);
		page.setPagesize(pagesize);
		T_Role_Menu t_role_menu = new T_Role_Menu();
		t_role_menu.setMenuid(menuid);
		t_role_menu.setRmid(rmid);
		t_role_menu.setRoleid(roleid);
		t_role_menu.setPage(page);
		Map<String,Object> map=new HashMap<>();
		map.put("t_role_menu", t_role_menu);
		List<Map> list = t_role_menuService.queryBy(map);
		JSONArray json = JSONArray.fromObject(list);
		String param = json.toString();
		param = new String(param.getBytes("ISO-8859-1"), "UTF-8");
		return param;
	}

	// 添加
	@RequestMapping("/t_role_menuinsert")
	@ResponseBody
	public String insert(String roleid, String menuid) {
		T_Role_Menu t_role_menu = new T_Role_Menu();
		t_role_menu.setMenuid(menuid);
		t_role_menu.setRoleid(roleid);
		Integer i = t_role_menuService.insert(t_role_menu);
		return i.toString();
	}

	// 修改
	@RequestMapping("/t_role_menuupdate")
	@ResponseBody
	public String update(String roleid, String menuid, String rmid) {
		T_Role_Menu t_role_menu = new T_Role_Menu();
		t_role_menu.setMenuid(menuid);
		t_role_menu.setRmid(rmid);
		t_role_menu.setRoleid(roleid);
		Integer i = t_role_menuService.update(t_role_menu);
		return i.toString();
	}

	// 删除
	@RequestMapping("/t_role_menudelete")
	@ResponseBody
	public String delete(String rmid) {
		T_Role_Menu t_role_menu = new T_Role_Menu();
		t_role_menu.setRmid(rmid);
		Integer i = t_role_menuService.delete(t_role_menu);
		return i.toString();
	}

}
