package com.team.customer.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.customer.entity.Customer;
import com.team.customer.service.CustomerService;
import com.team.util.Page;

import net.sf.json.JSONArray;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	// 查询全部
	@RequestMapping(value="/customerall",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String query(String pageno,String pagesize) throws Exception {
		Page page=new Page();
		page.setPageno(pageno);
		page.setPagesize(pagesize);
		Customer customer=new Customer();
		customer.setPage(page);
		List<Map> list = customerService.query(customer);
		JSONArray json = JSONArray.fromObject(list);
		String param = json.toString();
		return param;
	}

	// 条件查询
	@RequestMapping(value="/customer",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String queryBy(String cid, String cname, String cpwd, String phone,String pageno,String pagesize) throws Exception {
		Page page=new Page();
		page.setPageno(pageno);
		page.setPagesize(pagesize);
		Customer customer = new Customer();
		customer.setCid(cid);
		customer.setCname(cname);
		customer.setCpwd(cpwd);
		customer.setPhone(phone);
		customer.setPage(page);
		Map<String,Object> map=new HashMap<>();
		map.put("customer", customer);
		List<Map> list = customerService.queryBy(map);
		JSONArray json = JSONArray.fromObject(list);
		String param = json.toString();
		return param;
	}

	// 添加
	@RequestMapping(value="/customerinsert",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String insert(String address, String cname, String cpwd, String sex, String phone) throws Exception {
		if (address != null) {
			address = new String(address.getBytes("ISO-8859-1"), "UTF-8");
		}
		if (cname != null) {
			cname = new String(cname.getBytes("ISO-8859-1"), "UTF-8");
		}
		if (cpwd != null) {
			cpwd = new String(cpwd.getBytes("ISO-8859-1"), "UTF-8");
		}
		if (sex != null) {
			sex = new String(sex.getBytes("ISO-8859-1"), "UTF-8");
		}
		Customer customer = new Customer();
		customer.setAddress(address);
		customer.setCname(cname);
		customer.setCpwd(cpwd);
		customer.setPhone(phone);
		customer.setSex(sex);
		Integer i = customerService.insert(customer);
		return i.toString();
	}

	// 修改
	@RequestMapping(value="/customerupdate",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String update(String address, String cid, String cpwd, String sex, String phone,String cname) throws Exception {
		if (address != null) {
			address = new String(address.getBytes("ISO-8859-1"), "UTF-8");
		}
		if (cpwd != null) {
			cpwd = new String(cpwd.getBytes("ISO-8859-1"), "UTF-8");
		}
		if (sex != null) {
			sex = new String(sex.getBytes("ISO-8859-1"), "UTF-8");
		}
		if(cname!=null) {
			cname = new String(cname.getBytes("ISO-8859-1"), "UTF-8");
		}
		Customer customer = new Customer();
		customer.setAddress(address);
		customer.setCid(cid);
		customer.setCpwd(cpwd);
		customer.setPhone(phone);
		customer.setCname(cname);
		customer.setSex(sex);
		Integer i = customerService.update(customer);
		return i.toString();
	}

	// 删除
	@RequestMapping(value="/customerdelete",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String delete(String cid) {
		Customer customer = new Customer();
		customer.setCid(cid);
		Integer i = customerService.delete(customer);
		return i.toString();
	}
}
