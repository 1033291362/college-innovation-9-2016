package com.xsoft.base.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * String辅助类
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-1-24
 * @version: V1.0.0
 */
public class StringUtil extends StringUtils {
	
	/**
	 * 非空判断
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNotBlank(Object obj) {
		return !isBlank(obj);
	}

	/**
	 * 为空判断
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isBlank(Object obj) {
		if (obj == null || StringUtils.isBlank(obj.toString())) {
			return true;
		}
		return false;
	}

}
