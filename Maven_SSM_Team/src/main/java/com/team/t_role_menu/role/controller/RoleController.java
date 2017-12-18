package com.team.role.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.role.entity.Role;
import com.team.role.service.RoleService;
import com.team.util.Page;

import net.sf.json.JSONArray;

@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;

	// 查询全部
	@RequestMapping(value="/roleall",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String query(String pageno,String pagesize) throws Exception {
		Page page=new Page();
		page.setPageno(pageno);
		page.setPagesize(pagesize);
		Role role=new Role();
		role.setPage(page);
		List<Map> list = roleService.query(page);
		JSONArray json = JSONArray.fromObject(list);
		String param = json.toString();
		return param;
	}

	// 条件查询
	@RequestMapping(value="/role",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String queryBy(String rid, String rname, String rdescirbe,String pagesize,String pageno) throws Exception {
		Page page=new Page();
		page.setPageno(pageno);
		page.setPagesize(pagesize);
		Role role = new Role();
		role.setRdescirbe(rdescirbe);
		role.setRid(rid);
		role.setRname(rname);
		role.setPage(page);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("role", role);
		List<Map> list = roleService.queryBy(map);
		JSONArray json = JSONArray.fromObject(list);
		String param = json.toString();
		return param;
	}

	// 添加
	@RequestMapping("/roleinsert")
	@ResponseBody
	public String insert(String rname, String rdescirbe) throws Exception {

		Role role = new Role();
		role.setRdescirbe(rdescirbe);
		role.setRname(rname);
		Integer i = roleService.insert(role);
		return i.toString();
	}

	// 修改
	@RequestMapping("/roleupdate")
	@ResponseBody
	public String update(String rid, String rname, String rdescirbe) throws Exception {

		Role role = new Role();
		role.setRdescirbe(rdescirbe);
		role.setRid(rid);
		role.setRname(rname);
		Integer i = roleService.update(role);
		return i.toString();
	}

	// 删除
	@RequestMapping("/roledelete")
	@ResponseBody
	public String delete(String rid) {
		Role role = new Role();
		role.setRid(rid);
		Integer i = roleService.delete(role);
		return i.toString();
	}
}
