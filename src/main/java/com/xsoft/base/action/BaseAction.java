package com.xsoft.base.action;

import java.beans.PropertyEditorSupport;
import java.util.Date;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.xsoft.base.utils.DateUtil;
import com.xsoft.base.vo.CodeVo;
import com.xsoft.base.vo.DataVo;

/**
 * 基础action
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 程旭(cxmail@qq.com)
 * @createDate 2016-1-27
 * @version: V1.0.0
 */
public class BaseAction {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 初始化数据绑定
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		// 日期类型自动转换
		binder.registerCustomEditor(Date.class,  new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(DateUtil.parseDate(text));
			}
		});

		//防止XSS攻击
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
			}
			@Override
			public String getAsText() {
				Object value = getValue();
				return value != null ? value.toString() : "";
			}
		});
	}

	/**
	 * 返回成功代码{code:1}
	 */
	protected CodeVo sendOk() {
		return new CodeVo(1);
	}

	/**
	 * 返回失败代码{code:0}
	 */
	protected static CodeVo sendError() {
		return new CodeVo(0);
	}

	/**
	 * 返回指定代码{code:code}
	 */
	protected CodeVo sendCode(int code) {
		return new CodeVo(code);
	}

	/**
	 * 返回失败信息{code:0,data:error}
	 */
	protected DataVo sendError(String error) {
		return new DataVo(0, error);
	}

	/**
	 * 返回失败信息{code:code,data:error}
	 */
	protected DataVo sendError(int code, String error) {
		return new DataVo(code, error);
	}

	/**
	 * 返回成功数据{code:1,data:obj}
	 */
	protected DataVo sendData(Object obj) {
		return new DataVo(1, obj);
	}

	/**
	 * 返回成功数据{code:code,data:obj}
	 */
	protected DataVo sendData(int code, Object obj) {
		return new DataVo(code, obj);
	}

}
