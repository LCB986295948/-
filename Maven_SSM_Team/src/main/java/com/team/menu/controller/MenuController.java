package com.team.menu.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.menu.entity.Menu;
import com.team.menu.service.MenuService;
import com.team.user.entity.User;
import com.team.util.Page;

import net.sf.json.JSONArray;

@Controller
public class MenuController {
	@Autowired
	private MenuService menuService;

	// 查询全部
	@RequestMapping(value="/menuall",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String query(String pageno,String pagesize) throws Exception {
		Page page=new Page();
		page.setPageno(pageno);
		page.setPagesize(pagesize);
		Menu menu=new Menu();
		menu.setPage(page);
		List<Map> list = menuService.query(page);
		JSONArray json = JSONArray.fromObject(list);
		String param = json.toString();
		return param;
	}

	// 条件查询
	@RequestMapping(value="/menu",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String queryBy(String isadmin,String userid,String pagesize,String pageno,String mid) throws Exception {
		Page page=new Page();
		page.setPageno(pageno);
		page.setPagesize(pagesize);
		Menu menu = new Menu();
		menu.setIsadmin(isadmin);
		menu.setMid(mid);
		menu.setPage(page);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("menu", menu);
		map.put("userid", userid);
		List<Map> list = menuService.queryBy(map);
		JSONArray json = JSONArray.fromObject(list);
		String param = json.toString();
		return param;
	}

	// 添加
	@RequestMapping(value="/menuinsert",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String insert(String mname, String mdescirbe, String isadmin) throws Exception {

		Menu menu = new Menu();
		menu.setMname(mname);
		menu.setMdescirbe(mdescirbe);
		menu.setIsadmin(isadmin);
		menu.setFid(null);
		Integer i = menuService.insert(menu);
		return i.toString();
	}

	// 修改
	@RequestMapping(value="/menuupdate",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String update(String mname, String mdescirbe, String isadmin, String fid, String mid) throws Exception {

		Menu menu = new Menu();
		menu.setMname(mname);
		menu.setMdescirbe(mdescirbe);
		menu.setIsadmin(isadmin);
		menu.setFid(fid);
		menu.setMid(mid);
		Integer i = menuService.update(menu);
		return i.toString();
	}

	// 删除
	@RequestMapping("/menudelete")
	@ResponseBody
	public String delete(String mid) {
		Menu menu = new Menu();
		menu.setMid(mid);
		Integer i = menuService.delete(menu);
		return i.toString();
	}
}
