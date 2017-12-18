package com.team.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.dao.Dao;
import com.team.user.entity.User;
import com.team.user.service.UserService;

@Service("userService")
public class UserServicrImpl implements UserService {
	@Autowired
	private Dao dao;

	// ��ѯȫ��
	@Override
	public List<Map> query(Object object) {
		return dao.query("UserDaoMapper.query",object);
	}

	// ������ѯ
	@Override
	public List<Map> queryBy(Map<String,Object> map) {
		return dao.queryBy("UserDaoMapper.queryBy", map);
	}

	// ���
	@Override
	public Integer insert(Object object) {
		return dao.insert("UserDaoMapper.insert", object);
	}

	// �޸�
	@Override
	public Integer update(Object object) {
		return dao.update("UserDaoMapper.update", object);
	}

	// ɾ��
	@Override
	public Integer delete(Object object) {
		return dao.delete("UserDaoMapper.delete", object);
	}

}
