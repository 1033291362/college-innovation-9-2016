package com.xsoft.sys.sys.daoImpl;

import org.springframework.stereotype.Repository;

import com.xsoft.base.dao.daoImpl.BaseDaoImpl;
import com.xsoft.sys.sys.dao.CourseTimeDao;
import com.xsoft.sys.sys.entity.UserCourseTableTime;

/**
 * 课程时间表dao实现
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-01-29
 * @version: V1.0.0
 */
@Repository
public class CourseTimeImpl extends BaseDaoImpl<UserCourseTableTime> implements CourseTimeDao {

	@Override
	public void deleteByCourse(int courseId) {
		String sql="delete from user_course_table_time where course_id=?";
		jdbcTemplate.update(sql, courseId);
	}

	
}
