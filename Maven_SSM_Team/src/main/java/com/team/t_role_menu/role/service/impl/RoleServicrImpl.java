package com.team.role.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.team.dao.Dao;
import com.team.role.service.RoleService;


@Service("roleService")
public class RoleServicrImpl implements RoleService {
	@Autowired
	private Dao dao;

	// ��ѯȫ��
	@Override
	public List<Map> query(Object object) {
		return dao.query("RoleDaoMapper.query",object);
	}

	// ������ѯ
	@Override
	public List<Map> queryBy(Map<String,Object> map) {
		return dao.queryBy("RoleDaoMapper.queryBy", map);
	}

	// ���
	@Override
	public Integer insert(Object object) {
		return dao.insert("RoleDaoMapper.insert", object);
	}

	// �޸�
	@Override
	public Integer update(Object object) {
		return dao.update("RoleDaoMapper.update", object);
	}

	// ɾ��
	@Override
	public Integer delete(Object object) {
		return dao.delete("RoleDaoMapper.delete", object);
	}

}
