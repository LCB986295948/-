package com.team.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team.dao.Dao;

@Repository("daoImpl")
public class DaoImpl implements Dao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// ��ѯȫ��
	public List<Map> query(String str,Object object) {
		return sqlSessionTemplate.selectList(str,object);
	}

	// ������ѯ
	public List<Map> queryBy(String str, Map<String,Object> map) {
		return sqlSessionTemplate.selectList(str, map);
	}

	// ���
	public Integer insert(String str, Object object) {
		return sqlSessionTemplate.insert(str, object);
	}

	// �޸�
	public Integer update(String str, Object object) {
		return sqlSessionTemplate.update(str, object);
	}

	// ɾ��
	public Integer delete(String str, Object objec) {
		return sqlSessionTemplate.delete(str, objec);
	}

}
