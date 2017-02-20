package com.xsoft.base.constant;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.DefaultResourceLoader;

import com.xsoft.base.utils.PropertiesLoader;
import com.xsoft.base.utils.SpringContextUtil;
import com.xsoft.base.utils.StringUtil;

/**
 * 全局变量
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-5-27
 * @version: V1.0.0
 */
public class Xsoft {

	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = new HashMap<String, String>();
	
	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader loader = new PropertiesLoader("config.properties");

	/**
	 * 显示/隐藏
	 */
	public static final String SHOW = "1";
	public static final String HIDE = "0";

	/**
	 * 是/否
	 */
	public static final String YES = "1";
	public static final String NO = "0";
	
	/**
	 * 对/错
	 */
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	
	/**
	 * 上传文件基础虚拟路径
	 */
	public static final String UPLOAD_BASE_URL = "/upload/";
	
	/**
	 * 获取配置
	 */
	private static String getConfig(String key) {
		String value = map.get(key);
		if (value == null){
			value = loader.getValue(key);
			map.put(key, value != null ? value : StringUtil.EMPTY);
		}
		return value;
	}
	
	/**
	 * 获取管理端根路径
	 * @see ${xsoft:getAdminPath()}
	 */
	public static String getAdminPath() {
		return getConfig("adminPath");
	}
	
	/**
	 * 页面获取常量
	 * @see ${xsoft:getConst('YES')}
	 */
	public static Object getConst(String field) {
		try {
			return Xsoft.class.getField(field).get(null);
		} catch (Exception e) {
			// 异常代表无配置，这里什么也不做
		}
		return null;
	}

	/**
	 * 获取上传文件的根目录
	 * @return
	 */
	public static String getUserfilesBaseDir() {
		String dir = getConfig("userfiles.basedir");
		if (StringUtil.isBlank(dir)){
			try {
				dir = SpringContextUtil.getApplicationContext().getResource("/").toString();
			} catch (Exception e) {
				return "";
			}
		}
		if(!dir.endsWith("/")) {
			dir += "/";
		}
		return dir;
	}
	
    /**
     * 获取工程路径
     * @return
     */
    public static String getProjectPath(){
    	// 如果配置了工程路径，则直接返回，否则自动获取。
		String projectPath = Xsoft.getConfig("projectPath");
		if (StringUtil.isNotBlank(projectPath)){
			return projectPath;
		}
		try {
			File file = new DefaultResourceLoader().getResource("").getFile();
			if (file != null){
				while(true){
					File f = new File(file.getPath() + File.separator + "src" + File.separator + "main");
					if (f == null || f.exists()){
						break;
					}
					if (file.getParentFile() != null){
						file = file.getParentFile();
					}else{
						break;
					}
				}
				projectPath = file.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return projectPath;
    }
	
}
