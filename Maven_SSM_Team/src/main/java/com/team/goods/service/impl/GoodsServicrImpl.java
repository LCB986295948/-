package com.team.goods.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.dao.Dao;
import com.team.goods.service.GoodsService;
import com.team.order.service.OrderService;


@Service("goodsService")
public class GoodsServicrImpl implements GoodsService {
	@Autowired
	private Dao dao;

	// ��ѯȫ��
	@Override
	public List<Map> query(Object object) {
		return dao.query("GoodsDaoMapper.query",object);
	}

	// ������ѯ
	@Override
	public List<Map> queryBy(Map<String,Object> map) {
		return dao.queryBy("GoodsDaoMapper.queryBy", map);
	}

	// ���
	@Override
	public Integer insert(Object object) {
		return dao.insert("GoodsDaoMapper.insert", object);
	}

	// �޸�
	@Override
	public Integer update(Object object) {
		return dao.update("GoodsDaoMapper.update", object);
	}

	// ɾ��
	@Override
	public Integer delete(Object object) {
		return dao.delete("GoodsDaoMapper.delete", object);
	}

}
