package com.api.weixin.action;


import java.io.IOException;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xsoft.base.action.BaseAction;
import com.xsoft.base.utils.DateUtil;
import com.xsoft.base.utils.ToolsUtil;
import com.api.weixin.biz.UserBiz;
import com.xsoft.sys.sys.entity.UserPicPath;
import com.xsoft.sys.demo.entity.SysDemo;
import com.xsoft.sys.sys.biz.UserPicPathBiz;

import com.api.weixin.entity.UserStudentSheet;
@Controller 
@RequestMapping(value = "/static")
public class UserAction extends BaseAction{
	@Autowired	
	private UserBiz UserBiz;
	@RequestMapping(value = "/enroll", method = RequestMethod.GET)
	public String login() {
        logger.info("GET请zhuce");
        
		return "sys/sys/enroll";
	}


	@RequestMapping(value = "/enroll", method = RequestMethod.POST)
	@ResponseBody
	public Object enroll(String stu_id, String stu_name, String stu_num, String web_chat_id ) {
        logger.info("POST请zhuce");
		UserStudentSheet tc=new UserStudentSheet();
System.out.print(stu_id);
tc.setStu_id(stu_id);
tc.setStu_name(stu_name);
tc.setStu_num(stu_num);
tc.setWeb_chat_id(web_chat_id);
tc.setLogin_time(DateUtil.getNow());
UserBiz.save(tc);
return sendOk();
		}
}

