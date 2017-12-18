package com.team.menu.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.team.dao.Dao;
import com.team.menu.entity.Menu;
import com.team.menu.service.MenuService;


@Service("menuService")
public class MenuServicrImpl implements MenuService {
	@Autowired
	private Dao dao;

	// ��ѯȫ��
	@Override
	public List<Map> query(Object object) {
		return dao.query("MenuDaoMapper.query",object);
	}

	// ������ѯ
	@Override
	public List<Map> queryBy(Map<String,Object> map) {
		return dao.queryBy("MenuDaoMapper.queryBy",map);
	}

	// ���
	@Override
	public Integer insert(Object object) {
		return dao.insert("MenuDaoMapper.insert", object);
	}

	// �޸�
	@Override
	public Integer update(Object object) {
		return dao.update("MenuDaoMapper.update", object);
	}

	// ɾ��
	@Override
	public Integer delete(Object object) {
		return dao.delete("MenuDaoMapper.delete", object);
	}

}
