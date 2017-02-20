package com.xsoft.base.dao.daoImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.xsoft.base.dao.BaseDao;
import com.xsoft.base.exception.SqlException;
import com.xsoft.base.utils.SqlContext;
import com.xsoft.base.utils.SqlUtil;
import com.xsoft.base.vo.PageVo;

/**
 * 基础dao实现
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-1-24
 * @version: V1.0.0
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	// 类对象
	private Class<T> beanClass;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		Type superclass = getClass().getGenericSuperclass();
		ParameterizedType type = (ParameterizedType) superclass;
		beanClass = (Class<T>) type.getActualTypeArguments()[0];
	}

	@Override
	public Integer saveBackId(T bean) {
		save(bean);
		return jdbcTemplate.queryForObject("SELECT last_insert_id() as id", Integer.class);
	}

	@Override
	public void save(T bean) {
		update(SqlUtil.getInsert(bean));
	}

	@Override
	public void update(T bean) {
		update(SqlUtil.getUpdate(bean));
	}

	@Override
	public void update(T bean, String... wheres) {
		update(SqlUtil.getUpdate(bean, wheres));
	}

	@Override
	public void delete(T bean) {
		update(SqlUtil.getDelete(bean));
	}

	@Override
	public void delete(T bean, String... wheres) {
		update(SqlUtil.getDelete(bean, wheres));
	}

	@Override
	public void delete(Object[] ids) {
		update(SqlUtil.getDelete(beanClass, ids));
	}

	@Override
	public void delete(Object[] ids, Object... wheres) {
		update(SqlUtil.getDelete(beanClass, ids, wheres));
	}

	@Override
	public T getById(Object id) {
		SqlContext sqlContext = SqlUtil.getByKey(beanClass, id);
		return queryForObject(sqlContext.getSql(), sqlContext.getParams());
	}

	@Override
	public T getByParams(String field, Object parmas) {
		return getByParams(new String[] { field }, parmas);
	}

	@Override
	public T getByParams(String[] fields, Object... parmas) {
		SqlContext sqlContext = SqlUtil.getByParams(beanClass, fields, parmas);
		return queryForObject(sqlContext.getSql(), sqlContext.getParams());
	}
	
	@Override
	public List<Map<String, Object>> queryAll() {
		return queryList(SqlUtil.getSelect(beanClass));
	}

	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> params) {
		return queryList(SqlUtil.getSelect(beanClass, params));
	}

	@Override
	public List<Map<String, Object>> queryList(String field, Object parmas) {
		return queryList(new String[] { field }, parmas);
	}

	@Override
	public List<Map<String, Object>> queryList(String[] fields, Object... parmas) {
		return queryList(SqlUtil.getByParams(beanClass, fields, parmas));
	}

	@Override
	public PageVo queryPage(int page, int rows, Map<String, Object> params) {
		SqlContext sqlContext = SqlUtil.getSelect(beanClass, page, rows, params);
		PageVo pageVo = new PageVo();
		pageVo.setList(queryList(sqlContext));
		pageVo.setTotal(queryInt(SqlUtil.getCount(sqlContext)));
		return pageVo;
	}

	@Override
	public PageVo queryPage(Class<T> clazz, int page, int rows, Map<String, Object> params) {
		SqlContext sqlContext = SqlUtil.getSelect(beanClass, page, rows, params);
		PageVo pageVo = new PageVo();
		pageVo.setList(queryList(sqlContext, clazz));
		pageVo.setTotal(queryInt(SqlUtil.getCount(sqlContext)));
		return pageVo;
	}
	
	/********************************************************************************
	 * 业务层 禁止写sql语句，以下方法仅供子类调用
	 ********************************************************************************/

	/**
	 * 查询
	 * 
	 * @param sql
	 *            查询语句
	 * @param clazz
	 *            封装对象
	 * @param params
	 *            查询条件
	 * @return 返回查询结果
	 */
	protected List<T> queryForList(String sql, Class<T> clazz, Object... params) {
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(clazz), params);
	}

	/**
	 * 查询
	 * 
	 * @param params
	 *            查询条件
	 * @return 返回查询结果
	 */
	protected List<Map<String, Object>> queryForList(String sql, Object... params) {
		return jdbcTemplate.queryForList(sql, params);
	}

	/**
	 * 查询
	 * 
	 * @param page
	 *            sql
	 * @param params
	 *            查询参数
	 * @return 返回查询结果
	 */
	protected T queryForObject(String sql, Object... params) {
		try {
			return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(beanClass), params);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/**
	 * 分页查询
	 * 
	 * @param sql
	 *            查询语句
	 * @param page
	 *            当前页码
	 * @param rows
	 *            每页条数
	 * @param params
	 *            查询参数
	 * @return 返回查询结果
	 */
	protected PageVo queryForPage(String sql, int page, int rows, Object... params) {
		PageVo pageVo = new PageVo();
		pageVo.setList(queryForList(SqlUtil.getSelect(sql, page, rows), params));
		pageVo.setTotal(queryInt(SqlUtil.getCount(sql), params));
		return pageVo;
	}
	
	/********************************************************************************
	 * 私有方法
	 ********************************************************************************/

	/**
	 * 更新
	 * 
	 * @param sqlContext
	 *            sql上下文
	 */
	private void update(SqlContext sqlContext) {
		String sql = null;
		try {
			sql = sqlContext.getSql();
			jdbcTemplate.update(sql, sqlContext.getParams());
		} catch (Exception e) {
			throw new SqlException(e, sql);
		}
	}

	/**
	 * 查询
	 * 
	 * @param sqlContext
	 *            sql上下文
	 */
	private List<Map<String, Object>> queryList(SqlContext sqlContext) {
		String sql = null;
		try {
			sql = sqlContext.getSql();
			return jdbcTemplate.queryForList(sql, sqlContext.getParams());
		} catch (Exception e) {
			throw new SqlException(e, sql);
		}
	}

	/**
	 * 查询
	 * 
	 * @param sqlContext
	 *            sql上下文
	 */
	private List<T> queryList(SqlContext sqlContext, Class<T> clazz) {
		String sql = null;
		try {
			sql = sqlContext.getSql();
			return queryForList(sql, clazz, sqlContext.getParams());
		} catch (Exception e) {
			throw new SqlException(e, sql);
		}
	}

	/**
	 * 查询
	 * 
	 * @param sqlContext
	 *            sql上下文
	 */
	private int queryInt(SqlContext sqlContext) {
		String sql = null;
		try {
			sql = sqlContext.getSql();
			return jdbcTemplate.queryForObject(sql, Integer.class, sqlContext.getParams());
		} catch (Exception e) {
			throw new SqlException(e, sql);
		}
	}

	/**
	 * 查询
	 * 
	 * @param params
	 *            查询参数
	 */
	private int queryInt(String sql, Object... params) {
		try {
			return jdbcTemplate.queryForObject(sql, Integer.class, params);
		} catch (Exception e) {
			throw new SqlException(e, sql);
		}
	}

}