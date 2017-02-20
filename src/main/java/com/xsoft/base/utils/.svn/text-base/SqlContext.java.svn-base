package com.xsoft.base.utils;

/**
 * sql上下文
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-1-24
 * @version: V1.0.0
 */
public class SqlContext {

	// sql语句
	private StringBuilder sql;
	// sql中?对应的参数
	private Object[] params;
	
	public SqlContext() {
	}

	public SqlContext(StringBuilder sql) {
		this.sql = sql;
	}

	public SqlContext(StringBuilder sql, Object[] params) {
		this.sql = sql;
		this.params = params;
	}

	public String getSql() {
		return sql.toString();
	}

	public StringBuilder getSqlBuilder() {
		return sql;
	}

	public void setSql(StringBuilder sql) {
		this.sql = sql;
	}

	public void setSql(String sql) {
		this.sql = new StringBuilder(sql);
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

}