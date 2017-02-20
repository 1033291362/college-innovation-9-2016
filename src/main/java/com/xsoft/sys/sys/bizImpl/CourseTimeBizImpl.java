package com.xsoft.sys.sys.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xsoft.base.biz.bizImpl.BaseBizImpl;
import com.xsoft.sys.sys.biz.CourseTimeBiz;
import com.xsoft.sys.sys.dao.CourseTimeDao;
import com.xsoft.sys.sys.entity.UserCourseTableTime;

/**
 * 课程时间表biz实现
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-01-29
 * @version: V1.0.0
 */
@Service
public class CourseTimeBizImpl extends BaseBizImpl<UserCourseTableTime> implements CourseTimeBiz {
	
	@Autowired
	private CourseTimeDao courseTimeDao;

	@Override
	public void deleteByCourse(int courseId) {
		courseTimeDao.deleteByCourse(courseId);
	}

}
