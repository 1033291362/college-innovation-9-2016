package com.xsoft.sys.sys.action;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsoft.base.action.BaseAction;
import com.xsoft.sys.sys.biz.CourseTimeBiz;
import com.xsoft.sys.sys.biz.UserTeacherCourseBiz;
import com.xsoft.sys.sys.entity.UserCourseTableTime;
import com.xsoft.sys.sys.entity.UserTeacherCourse;

/**
 * 课程表action
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-01-29
 * @version: V1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/sysCourse")
public class CourseAction extends BaseAction {

	@Autowired
	private CourseTimeBiz courseTimeBiz;
	@Autowired
	private UserTeacherCourseBiz teacherCourseBiz;

	@RequestMapping(value = "")
	public String index() {
		return "sys/sys/sys_course";
	}

	/**
	 * 添加
	 */
	@RequestMapping(value = "/saveSysCourse")
	@ResponseBody
	public Object saveSysCourse(@RequestParam String courseName,@RequestParam String teacherId,@RequestParam String className,@RequestParam Date startTime,@RequestParam Date endTime) {
		UserTeacherCourse tc=new UserTeacherCourse();
		tc.setCourse_name(courseName);
		tc.setTeacher_id(Integer.parseInt(teacherId));
		tc.setClass_name(className);
		tc.setCourse_num("0");
		int courseId=teacherCourseBiz.saveBackId(tc);
		UserCourseTableTime ct=new UserCourseTableTime();
		ct.setCourse_id(courseId);
		ct.setStart_time(startTime);
		ct.setEnd_time(endTime);
		courseTimeBiz.save(ct);
		return sendOk();
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "/updateSysCourse")
	@ResponseBody
	public Object updateSysCourse(@RequestParam String id,@RequestParam String courseTimeId,@RequestParam String courseName,@RequestParam String teacherId,@RequestParam String className,@RequestParam Date startTime,@RequestParam Date endTime) {
		UserTeacherCourse tc=new UserTeacherCourse();
		tc.setCourse_id(Integer.parseInt(id));
		tc.setCourse_name(courseName);
		tc.setTeacher_id(Integer.parseInt(teacherId));
		tc.setClass_name(className);
		tc.setCourse_num("0");
		teacherCourseBiz.update(tc);
		UserCourseTableTime ct=new UserCourseTableTime();
		ct.setCourse_time_id(Integer.parseInt(courseTimeId));
		ct.setCourse_id(Integer.parseInt(id));
		ct.setStart_time(startTime);
		ct.setEnd_time(endTime);
		courseTimeBiz.update(ct);
		return sendOk();
	}

	/**
	 * 删除
	 * 
	 * @param ids
	 *            id字符串多个使用,分隔
	 */
	@RequestMapping(value = "/deleteSysCourse", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteSysCourse(String ids) {
		String str[]=ids.split(",");
		if(str.length>0){
			for(int i=0;i<str.length;i++){
				if(str[i]!=null && !"".equals(str[i])){
					teacherCourseBiz.deleteByCourse(Integer.parseInt(str[i]));
					courseTimeBiz.deleteByCourse(Integer.parseInt(str[i]));
				}
			}
		}
		return sendOk();
	}

	/**
	 * 分页查询
	 * 
	 * @param request
	 *            HttpServletRequest对象
	 * @param page
	 *            当前页码
	 * @param rows
	 *            每页条数
	 * @param params
	 *            查询参数
	 * @return 返回查询结果json
	 */
	@RequestMapping(value = "/findSysCourse", method = RequestMethod.POST)
	@ResponseBody
	public Object findSysCourse(int page, int rows, Map<String, Object> params) {
		return teacherCourseBiz.queryPage(page, rows, params);
	}

}