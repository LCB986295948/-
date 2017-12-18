package com.team.order.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.order.entity.Order;
import com.team.order.service.OrderService;
import com.team.util.Page;

import net.sf.json.JSONArray;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;

	// 查询全部
	@RequestMapping(value="/orderall",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String query(String pageno,String pagesize) throws Exception {
		Page page=new Page();
		page.setPageno(pageno);
		page.setPagesize(pagesize);
		Order order=new Order();
		order.setPage(page);
		List<Map> list = orderService.query(page);
		JSONArray json = JSONArray.fromObject(list);
		String param = json.toString();
		return param;
	}

	// 条件查询
	@RequestMapping(value="/order",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String queryBy(String orderid, String address, String time, String state, String userid, String cid,String pagesize,String pageno)
			throws Exception {
		Page page=new Page();
		page.setPageno(pageno);
		page.setPagesize(pagesize);
		Order order = new Order();
		order.setAddress(address);
		order.setCid(cid);
		order.setOrderid(orderid);
		order.setState(state);
		order.setTime(time);
		order.setUserid(userid);
		order.setPage(page);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("order", order);
		List<Map> list = orderService.queryBy(map);
		JSONArray json = JSONArray.fromObject(list);
		String param = json.toString();
		return param;
	}

	// 添加
	@RequestMapping(value="/orderinsert",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String insert(String address, String state, String odescirbe, String userid, String cid) throws Exception {

		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM--dd HH:mm");
		String time = sim.format(new Date()).toString();
		Order order = new Order();
		order.setAddress(address);
		order.setCid(cid);
		order.setOdescirbe(odescirbe);
		order.setState(state);
		order.setTime(time);
		order.setUserid(userid);
		Integer i = orderService.insert(order);
		return i.toString();
	}

	// 修改
	@RequestMapping(value="/orderupdate",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String update(String address, String state, String odescirbe, String orderid) throws Exception {

		Order order = new Order();
		order.setAddress(address);
		order.setOdescirbe(odescirbe);
		order.setState(state);
		order.setOrderid(orderid);
		Integer i = orderService.update(order);
		return i.toString();
	}

	// 删除
	@RequestMapping(value="/orderdelete",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String delete(String orderid) {
		Order order = new Order();
		order.setOrderid(orderid);
		Integer i = orderService.delete(order);
		return i.toString();
	}
}
