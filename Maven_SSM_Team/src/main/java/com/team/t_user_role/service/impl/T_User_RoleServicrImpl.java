package com.team.t_user_role.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.team.dao.Dao;
import com.team.t_user_role.service.T_User_RoleService;


@Service("t_user_roleService")
public class T_User_RoleServicrImpl implements T_User_RoleService {
	@Autowired
	private Dao dao;

	// ��ѯȫ��
	@Override
	public List<Map> query(Object object) {
		return dao.query("T_User_RoleDaoMapper.query",object);
	}

	// ������ѯ
	@Override
	public List<Map> queryBy(Map<String,Object> map) {
		return dao.queryBy("T_User_RoleDaoMapper.queryBy", map);
	}

	// ���
	@Override
	public Integer insert(Object object) {
		return dao.insert("T_User_RoleDaoMapper.insert", object);
	}

	// �޸�
	@Override
	public Integer update(Object object) {
		return dao.update("T_User_RoleDaoMapper.update", object);
	}

	// ɾ��
	@Override
	public Integer delete(Object object) {
		return dao.delete("T_User_RoleDaoMapper.delete", object);
	}

}
