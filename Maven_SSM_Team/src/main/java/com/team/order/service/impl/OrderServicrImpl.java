package com.team.order.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.dao.Dao;
import com.team.order.service.OrderService;


@Service("orderService")
public class OrderServicrImpl implements OrderService {
	@Autowired
	private Dao dao;

	// ��ѯȫ��
	@Override
	public List<Map> query(Object object) {
		return dao.query("OrderDaoMapper.query",object);
	}

	// ������ѯ
	@Override
	public List<Map> queryBy(Map<String,Object> map) {
		return dao.queryBy("OrderDaoMapper.queryBy", map);
	}

	// ���
	@Override
	public Integer insert(Object object) {
		return dao.insert("OrderDaoMapper.insert", object);
	}

	// �޸�
	@Override
	public Integer update(Object object) {
		return dao.update("OrderDaoMapper.update", object);
	}

	// ɾ��
	@Override
	public Integer delete(Object object) {
		return dao.delete("OrderDaoMapper.delete", object);
	}

}
