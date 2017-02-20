package com.xsoft.sys.sys.daoImpl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xsoft.base.dao.daoImpl.BaseDaoImpl;
import com.xsoft.base.vo.PageVo;
import com.xsoft.sys.sys.dao.SysUserDao;
import com.xsoft.sys.sys.entity.SysUser;

/**
 * 系统用户表dao实现
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-01-29
 * @version: V1.0.0
 */
@Repository
public class SysUserDaoImpl extends BaseDaoImpl<SysUser> implements SysUserDao {

	@Override
	public PageVo queryPage(int page, int rows, Map<String, Object> params) {
		String sql = "select id,roleId,name,phone,username,email,createTime,lastTime from sys_user order by createTime desc";
		return queryForPage(sql, page, rows);
	}

}
