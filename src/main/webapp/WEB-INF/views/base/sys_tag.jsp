<%-- 标签 --%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="/WEB-INF/tlds/jstl.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/tlds/functions.tld"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/tlds/fmt.tld"%>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiro.tld"%>
<%@ taglib prefix="xsoft" uri="/WEB-INF/tlds/xsoft.tld"%>
<%-- 项目路径 --%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<%-- 管理后台路径 --%>
<c:set var="adminPath" value="${basePath}/${xsoft:getAdminPath()}" />
<%-- 静态文件路径 --%>
<c:set var="staticPath" value="${basePath}/static" />