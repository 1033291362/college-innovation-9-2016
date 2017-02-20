package com.xsoft.sys.sys.biz;

import com.xsoft.base.biz.BaseBiz;
import com.xsoft.sys.sys.entity.Course;
import com.xsoft.sys.sys.entity.UserCourseTableTime;
import com.xsoft.sys.sys.entity.SysUser;
import com.xsoft.sys.sys.entity.UserTeacherCourse;

/**
 * 教师课程表biz
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-01-29
 * @version: V1.0.0
 */
public interface UserTeacherCourseBiz extends BaseBiz<UserTeacherCourse> {

	public void deleteByCourse(int courseId);
}
