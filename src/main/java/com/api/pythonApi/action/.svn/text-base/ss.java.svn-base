package com.api.pythonApi.action;


import java.io.File;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xsoft.base.action.BaseAction;
import com.xsoft.base.utils.DateUtil;
import com.xsoft.sys.sys.biz.UserCourseTableTimeBiz;
import com.xsoft.sys.sys.entity.UserPicPath;
import com.xsoft.sys.sys.biz.UserPicPathBiz;
@Controller
@RequestMapping(value = "/static/wjt")

public class ss extends BaseAction {
	


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
	@Autowired	
	private UserCourseTableTimeBiz userCourseTableTimeBiz;
	@Autowired	
	private UserPicPathBiz UserPicPathBiz;
    
	@RequestMapping(value = "/findUserCourseTableTime", method = RequestMethod.POST)
	@ResponseBody
	public Object findSysDemo(HttpServletRequest request, Map<String, Object> params) {

		return userCourseTableTimeBiz.queryAll();
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void parserUploadFile3(MultipartFile file) throws IOException {
		File file1 =new File("D:/dachuan/");    
		//如果文件夹不存在则创建    
		if  (!file1 .exists()  && !file1.isDirectory())      
		{       
		    System.out.println("//不存在");  
		    file1.mkdir();    
		}
		else   
		{  
		    System.out.println("//目录存在");  
		}  
		String realPath = "D:/dachuan/";
		
		file.transferTo(new File(realPath+file.getOriginalFilename()));
	
	}
	@RequestMapping(value = "/savepicpath", method = RequestMethod.POST)
	@ResponseBody
	public Object savepicpath(HttpServletRequest request,@RequestParam String pic_id,@RequestParam String pic_ip,@RequestParam String pic_path,@RequestParam String course_id)
{		
UserPicPath tc=new UserPicPath();
tc.setPic_id(pic_id);
tc.setPic_ip(pic_ip);
tc.setPic_path(pic_path);
tc.setCourse_id(course_id);
System.out.println(pic_id);
System.out.println(pic_path); 
tc.setAdd_time(DateUtil.getNow());
System.out.println(tc.getCourse_id());

System.out.println(tc.getPic_path());

System.out.println(tc.getPic_id());

System.out.println(tc.getAdd_time());

System.out.println(tc.getPic_ip());
UserPicPathBiz.save(tc);
return sendOk();
		}}
 