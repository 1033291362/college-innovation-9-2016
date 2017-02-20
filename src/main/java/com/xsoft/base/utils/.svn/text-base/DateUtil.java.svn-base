package com.xsoft.base.utils;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * 日期工具类
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-1-24
 * @version: V1.0.0
 */
public class DateUtil extends DateUtils {

	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM" };

	/**
	 * 获取日期字符串
	 * 
	 * @return （yyyy-MM-dd）
	 */
	public static String format(Date date, String pattern) {
		return DateFormatUtils.format(date, pattern);
	}

	/**
	 * 获取日期字符串
	 * 
	 * @return （yyyy-MM-dd）
	 */
	public static String format(Date date) {
		return format(date, "yyyy-MM-dd");
	}

	/**
	 * 获取日期字符串
	 * 
	 * @return （yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取当前日期
	 * 
	 * @param pattern
	 *            自定义日期格式
	 * @return
	 */
	public static String formatDate(String pattern) {
		return format(new Date(), pattern);
	}

	/**
	 * 获取当前日期字符串
	 * 
	 * @return （yyyy-MM-dd）
	 */
	public static String getDate() {
		return format(new Date(), "yyyy-MM-dd");
	}

	/**
	 * 获取当前时间字符串
	 * 
	 * @return （HH:mm:ss）
	 */
	public static String getTime() {
		return format(new Date(), "HH:mm:ss");
	}

	/**
	 * 获取当前日期时间字符串
	 * 
	 * @return （yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取当前年字符串
	 * 
	 * @return （yyyy）
	 */
	public static String getYear() {
		return format(new Date(), "yyyy");
	}

	/**
	 * 获取当前月字符串
	 * 
	 * @return （MM）
	 */
	public static String getMonth() {
		return format(new Date(), "MM");
	}

	/**
	 * 获取当前日字符串
	 * 
	 * @return （dd）
	 */
	public static String getDay() {
		return format(new Date(), "dd");
	}

	/**
	 * 获取当前星期字符串
	 * 
	 * @return 星期几
	 */
	public static String getWeek() {
		return format(new Date(), "E");
	}
	
	/**
	 * 获取当前日期
	 * 
	 * @return
	 */
	public static Date getNow() {
		return new Date();
	}

	/**
	 * 日期型字符串转化
	 * 
	 * @param str
	 *            日期型字符串"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm"
	 * @return
	 */
	public static Date parseDate(String str) {
		if (str == null) {
			return null;
		}
		try {
			return parseDate(str, parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 *            开始时间
	 * @param after
	 *            结束时间
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}
}
