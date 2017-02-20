package com.xsoft.base.biz.bizImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.xsoft.base.biz.BaseBiz;
import com.xsoft.base.dao.BaseDao;
import com.xsoft.base.vo.PageVo;

/**
 * 基础biz
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-1-27
 * @version: V1.0.0
 */
public class BaseBizImpl<T> implements BaseBiz<T> {

	/**
	 * 注入BaseDao
	 */
	@Autowired
	protected BaseDao<T> baseDao;

	@Override
	public Integer saveBackId(T bean) {
		return baseDao.saveBackId(bean);
	}

	@Override
	public void save(T bean) {
		baseDao.saveBackId(bean);
	}

	@Override
	public void update(T bean) {
		baseDao.update(bean);
	}

	@Override
	public void update(T bean, String... wheres) {
		baseDao.update(bean, wheres);
	}

	@Override
	public void delete(T bean) {
		baseDao.delete(bean);
	}

	@Override
	public void delete(T bean, String... wheres) {
		baseDao.delete(bean, wheres);
	}

	@Override
	public void delete(Object[] ids) {
		baseDao.delete(ids);
	}

	@Override
	public void delete(Object[] ids, Object... wheres) {
		baseDao.delete(ids, wheres);
	}

	@Override
	public T getById(Object id) {
		return baseDao.getById(id);
	}

	@Override
	public T getByParams(String field, Object parmas) {
		return baseDao.getByParams(field, parmas);
	}

	@Override
	public T getByParams(String[] fields, Object... parmas) {
		return baseDao.getByParams(fields, parmas);
	}

	@Override
	public List<Map<String, Object>> queryAll() {
		return baseDao.queryAll();
	}

	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> params) {
		return baseDao.queryList(params);
	}

	@Override
	public List<Map<String, Object>> queryList(String field, Object params) {
		return baseDao.queryList(field, params);
	}

	@Override
	public List<Map<String, Object>> queryList(String[] fields, Object... params) {
		return baseDao.queryList(fields, params);
	}

	@Override
	public PageVo queryPage(int page, int rows, Map<String, Object> params) {
		return baseDao.queryPage(page, rows, params);
	}

}
