package com.team.user.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.user.entity.User;
import com.team.user.service.UserService;
import com.team.util.Page;

import net.sf.json.JSONArray;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	// ��ѯȫ��
	@RequestMapping(value="/userall",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String query(String pageno,String pagesize) throws Exception {
		Page page=new Page();
		page.setPageno(pageno);
		page.setPagesize(pagesize);
		User user=new User();
		user.setPage(page);
		List<Map> list = userService.query(user);
		JSONArray json = JSONArray.fromObject(list);
		String param = json.toString();
		return param;
	}

	// ������ѯ
	@RequestMapping(value="/user",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String queryBy(String username, String password, String id,String pageno,String pagesize) throws Exception {
		Page page=new Page();
		page.setPageno(pageno);
		page.setPagesize(pagesize);
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		user.setUsername(username);
		user.setPage(page);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("user",user);
		List<Map> list = userService.queryBy(map);
		JSONArray json = JSONArray.fromObject(list);
		String param = json.toString();
		param = new String(param.getBytes("ISO-8859-1"), "UTF-8");
		return param;
	}

	// ���
	@RequestMapping(value="/userinsert",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String insert(String username, String password) throws Exception {

		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		Integer i = userService.insert(user);
		return i.toString();
	}

	// �޸�
	@RequestMapping(value="/userupdate",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String update(String username, String password, String id) throws Exception {

		User user = new User();
		user.setId(id);
		user.setPassword(password);
		user.setUsername(username);
		Integer i = userService.update(user);
		return i.toString();
	}

	// ɾ��
	@RequestMapping(value="/userdelete",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String delete(String id) {
		User user = new User();
		user.setId(id);
		Integer i = userService.delete(user);
		return i.toString();
	}
}
