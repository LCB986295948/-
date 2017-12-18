package com.team.goods.service;

import java.util.List;
import java.util.Map;

public interface GoodsService {

	//查询全部
	List<Map> query(Object object);

	// 条件查询
	List<Map> queryBy(Map<String,Object> map);

	// ���
	Integer insert(Object object);

	// �޸�
	Integer update(Object object);

	// ɾ��
	Integer delete(Object object);
}
