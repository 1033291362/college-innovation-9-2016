package com.xsoft.sys.sys.daoImpl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xsoft.base.dao.daoImpl.BaseDaoImpl;
import com.xsoft.base.vo.PageVo;
import com.xsoft.sys.sys.dao.TeacherCourseDao;
import com.xsoft.sys.sys.entity.UserTeacherCourse;

/**
 * 教师课程表dao实现
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-01-29
 * @version: V1.0.0
 */
@Repository
public class TeacherCourseDaoImpl extends BaseDaoImpl<UserTeacherCourse> implements TeacherCourseDao {

	@Override
	public PageVo queryPage(int page, int rows, Map<String, Object> params) {
		String sql = "select tc.course_id id,tc.course_name courseName,tc.teacher_id teacherId,tc.class_name className,ct.course_time_id courseTimeId,ct.start_time startTime,ct.end_time endTime from user_teacher_course tc LEFT JOIN user_course_table_time ct on tc.course_id=ct.course_id";
		return queryForPage(sql, page, rows);
	}
	
	@Override
	public void deleteByCourse(int courseId) {
		String sql="delete from user_teacher_course where course_id=?";
		jdbcTemplate.update(sql, courseId);
	}
}
