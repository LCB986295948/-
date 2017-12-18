package com.team.t_user_role.service;

import java.util.List;
import java.util.Map;

public interface T_User_RoleService {

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
