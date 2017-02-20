package com.xsoft.base.biz;

import java.util.List;
import java.util.Map;

import com.xsoft.base.vo.PageVo;

/**
 * 基础biz
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-1-27
 * @version: V1.0.0
 */
public interface BaseBiz<T> {

	/**
	 * 添加并返回保存后的id
	 * 
	 * @param bean
	 *            实体
	 * @return 返回保存后的id
	 */
	Integer saveBackId(T bean);

	/**
	 * 添加
	 * 
	 * @param bean
	 *            实体
	 */
	void save(T bean);

	/**
	 * 修改实体（修改条件为实体对象@key字段）
	 * 
	 * @param bean
	 *            实体
	 */
	void update(T bean);

	/**
	 * 修改实体
	 * 
	 * @param bean
	 *            实体
	 * @param wheres
	 *            修改条件:实体字段
	 */
	void update(T bean, String... wheres);

	/**
	 * 删除实体（删除条件为实体对象@key字段）
	 * 
	 * @param bean
	 *            实体
	 */
	void delete(T bean);

	/**
	 * 删除实体
	 * 
	 * @param bean
	 *            实体
	 * @param wheres
	 *            删除条件:实体字段
	 */
	void delete(T bean, String... wheres);

	/**
	 * 批量的删除
	 * 
	 * @param ids
	 *            id数组
	 */
	void delete(Object[] ids);

	/**
	 * 批量的删除
	 * 
	 * @param ids
	 *            id数组
	 * @param wheres
	 *            删除条件:实体字段
	 */
	void delete(Object[] ids, Object... wheres);

	/**
	 * 通过@key字段查询
	 * 
	 * @param id
	 *            主键id
	 * 
	 * @return 指定对象
	 */
	T getById(Object id);

	/**
	 * 通过字段查询
	 * 
	 * @param field
	 *            指定查询字段
	 * 
	 * @param parmas
	 *            参数值
	 * 
	 * @return 指定对象
	 */
	T getByParams(String field, Object parmas);

	/**
	 * 通过字段查询
	 * 
	 * @param fields
	 *            指定查询字段
	 * 
	 * @param parmas
	 *            参数值
	 * @return 指定对象
	 */
	T getByParams(String[] fields, Object... parmas);

	/**
	 * 查询全部
	 * 
	 * @param page
	 *            分页对象
	 * @param params
	 *            查询参数
	 * @return 返回查询结果
	 */
	List<Map<String, Object>> queryAll();

	/**
	 * 查询
	 * 
	 * @param page
	 *            分页对象
	 * @param params
	 *            查询条件
	 * @return 返回查询结果
	 */
	List<Map<String, Object>> queryList(Map<String, Object> params);

	/**
	 * 通过字段查询
	 * 
	 * @param field
	 *            指定查询字段
	 * 
	 * @param params
	 *            参数值
	 * 
	 * @return 指定对象
	 */
	List<Map<String, Object>> queryList(String field, Object params);

	/**
	 * 通过字段查询
	 * 
	 * @param fields
	 *            指定查询字段
	 * 
	 * @param params
	 *            参数值
	 * @return 指定对象
	 */
	List<Map<String, Object>> queryList(String[] fields, Object... params);

	/**
	 * 分页查询
	 * 
	 * @param page
	 *            当前页码
	 * @param rows
	 *            每页条数
	 * @param params
	 *            查询参数
	 * @return 返回查询结果(集合为map)
	 */
	PageVo queryPage(int page, int rows, Map<String, Object> params);

}
