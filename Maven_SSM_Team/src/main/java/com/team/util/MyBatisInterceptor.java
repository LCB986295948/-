package com.team.util;

import java.sql.Connection;
import java.util.Properties;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import com.team.user.entity.User;



@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class,Integer.class })})
public class MyBatisInterceptor implements Interceptor{
     String dialect;
     
	@Override
	public Object intercept(Invocation arg0) throws Throwable {
		RoutingStatementHandler rsh=(RoutingStatementHandler) arg0.getTarget();
		BaseStatementHandler delegate=(BaseStatementHandler) ReflectHelper.getValueByFieldName(rsh, "delegate");
		MappedStatement ms=(MappedStatement) ReflectHelper.getValueByFieldName(delegate,  "mappedStatement");
		
		BoundSql boundSql = delegate.getBoundSql();
		String s=boundSql.getSql();
		Object parameterObject = boundSql.getParameterObject();
		if(parameterObject instanceof Page) {
			String pageno=((Page) parameterObject).getPageno();
			String pagesize=((Page) parameterObject).getPagesize();
			if(pageno!=null&pagesize!=null) {
			String sql=(s+(" WHERE Rownum BETWEEN ("+pageno+"-1)*"+pagesize+" AND "+pageno+"*"+pagesize+" "));
			ReflectHelper.setValueByFieldName(boundSql, "sql", sql);
			}
		}
		return arg0.proceed();
	}

	@Override
	public Object plugin(Object arg0) {
		return Plugin.wrap(arg0, this);
	}

	@Override
	public void setProperties(Properties arg0) {
		dialect=arg0.get("dialect").toString();
		System.out.println("dialect:"+dialect);
	}

}
