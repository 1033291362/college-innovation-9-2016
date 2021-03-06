package com.xsoft.sys.sys.dao;

import com.xsoft.base.dao.BaseDao;
import com.xsoft.sys.sys.entity.UserCourseTableTime;

/**
 * 课程时间表dao
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-01-29
 * @version: V1.0.0
 */
public interface CourseTimeDao extends BaseDao<UserCourseTableTime> {

	public void deleteByCourse(int courseId);
}
