package com.team.goods.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.goods.entity.Goods;
import com.team.goods.service.GoodsService;
import com.team.util.Page;

import net.sf.json.JSONArray;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;

	// 查询全部
	@RequestMapping(value="/goodsall",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String query(String pageno,String pagesize) throws Exception {
		Page page=new Page();
		page.setPageno(pageno);
		page.setPagesize(pagesize);
		Goods goods=new Goods();
		goods.setPage(page);
		List<Map> list = goodsService.query(page);
		JSONArray json = JSONArray.fromObject(list);
		String param = json.toString();
		return param;
	}

	// 条件查询
	@RequestMapping(value="/goods",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String queryBy(String gid, String gname, String ggenre,String pageno,String pagesize) throws Exception {
		Page page=new Page();
		page.setPageno(pageno);
		page.setPagesize(pagesize);
		Goods goods = new Goods();
		goods.setGid(gid);
		goods.setGgenre(ggenre);
		goods.setGname(gname);
		goods.setPage(page);
		Map<String,Object> map =new HashMap<>();
		map.put("goods", goods);
		List<Map> list = goodsService.queryBy(map);
		JSONArray json = JSONArray.fromObject(list);
		String param = json.toString();
		return param;
	}

	// 添加
	@RequestMapping(value="/goodsinsert",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String insert(String gname, String gprice, String ggenre, String gdescirbe) throws Exception {
	
		Goods goods = new Goods();
		goods.setGdescirbe(gdescirbe);
		goods.setGgenre(ggenre);
		goods.setGname(gname);
		goods.setGprice(gprice);
		Integer i = goodsService.insert(goods);
		return i.toString();
	}

	// 修改
	@RequestMapping(value="/goodsupdate",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String update(String gname, String gprice, String ggenre, String gdescirbe, String gid) throws Exception {
		
		Goods goods = new Goods();
		goods.setGdescirbe(gdescirbe);
		goods.setGgenre(ggenre);
		goods.setGname(gname);
		goods.setGprice(gprice);
		goods.setGid(gid);
		Integer i = goodsService.update(goods);
		return i.toString();
	}

	// 删除
	@RequestMapping(value="/goodsdelete",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String delete(String gid) {
		Goods goods = new Goods();
		goods.setGid(gid);
		Integer i = goodsService.delete(goods);
		return i.toString();
	}
}
