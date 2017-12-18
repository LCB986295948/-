package com.team.dao;

import java.util.List;
import java.util.Map;

public interface Dao {

	// ��ѯ����
	List<Map> query(String str,Object object);

	// ��������ѯ
	List<Map> queryBy(String str, Map<String,Object> map);

	// ���
	Integer insert(String str, Object object);

	// �޸�
	Integer update(String str, Object object);

	// ɾ��
	Integer delete(String str, Object object);
}
