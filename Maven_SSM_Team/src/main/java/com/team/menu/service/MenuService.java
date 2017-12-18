package com.team.menu.service;

import java.util.List;
import java.util.Map;

import com.team.menu.entity.Menu;

public interface MenuService {

	// 查询全部
	List<Map> query(Object object);

	// 条件查询
	List<Map> queryBy(Map<String,Object> map);

	//添加
	Integer insert(Object object);

	// 修改
	Integer update(Object object);

	// 删除
	Integer delete(Object object);
}
