package com.xsoft.sys.demo.action;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.xsoft.sys.demo.biz.SysDemoBiz;
import com.xsoft.sys.demo.entity.SysDemo;
import com.xsoft.sys.sys.biz.UserCourseTableTimeBiz;

/**
 * crud测试action
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-05-29
 * @version: V1.0.0
 */
@Controller 
@RequestMapping(value = "/${adminPath}/sysDemo")
public class SysDemoAction extends BaseAction {

	@Autowired
	private SysDemoBiz sysDemoBiz;

	@RequestMapping(value = "")
	public String index() {
		return "sys/demo/sys_demo";
	}

	/**
	 * 添加
	 */
	@RequestMapping(value = "/saveSysDemo", method = RequestMethod.POST)
	@ResponseBody
	public Object saveSysDemo(HttpServletRequest request, @ModelAttribute SysDemo sysDemo) {
		sysDemo.setId(ToolsUtil.getUUID());
		sysDemo.setCreateTime(DateUtil.getNow());
		sysDemoBiz.save(sysDemo);
		return sendOk();
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "/updateSysDemo", method = RequestMethod.POST)
	@ResponseBody
	public Object updateSysDemo(HttpServletRequest request, @ModelAttribute SysDemo sysDemo) {
		sysDemoBiz.update(sysDemo);
		return sendOk();
	}

	/**
	 * 删除
	 * 
	 * @param ids
	 *            id字符串多个使用,分隔
	 */
	@RequestMapping(value = "/deleteSysDemo", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteSysDemo(HttpServletRequest request, @RequestParam String ids) {
		sysDemoBiz.delete(ids.split(","));
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
	@RequestMapping(value = "/findSysDemo", method = RequestMethod.POST)
	@ResponseBody
	public Object findSysDemo(HttpServletRequest request, int page, int rows, Map<String, Object> params) {
		return sysDemoBiz.queryPage(page, rows, params);
	}
	@Autowired
	private UserCourseTableTimeBiz UserCourseTableTimeBiz;
 
	
	@RequestMapping(value = "/findUserCourseTableTime", method = RequestMethod.POST)
	@ResponseBody
	public Object findSysDemo(HttpServletRequest request, Map<String, Object> params) {

		return UserCourseTableTimeBiz.queryAll();
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void parserUploadFile3(MultipartFile file) throws IOException {
		File file1 =new File("D:/dachuan/");    
		//如果文件夹不存在则创建    
		if  (!file1 .exists()  && !file1.isDirectory())      
		{       
		    System.out.println("//不存在");  
		    file1.mkdir();    
		} else   
		{  
		    System.out.println("//目录存在");  
		}  
		String realPath = "D:/dachuan/";
		
		file.transferTo(new File(realPath+file.getOriginalFilename()));
	
	
	}
}
    