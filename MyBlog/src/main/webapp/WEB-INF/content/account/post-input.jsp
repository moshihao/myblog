<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ page
	import="org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter"%>
<%@ page
	import="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter"%>
<%@ page import="org.springframework.security.web.WebAttributes"%>
<%@ include file="/common/header.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page
	import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>土豪_Muscle 的博客</title>
<link rel="stylesheet" type="text/css" href="${ctx}/b/style.css">
<script type="text/javascript" src="${ctx}/b/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="${ctx}/b/common-0.1.js"></script>
<script type="text/javascript" src="${ctx}/b/json2.js"></script>
<script type="text/javascript" src="${ctx}/b/jcover-0.1.js"></script>
<script charset="utf-8" src="${ctx}/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="${ctx}/kindeditor/lang/zh_CN.js"></script>
<script>
        KindEditor.ready(function(K) {
                window.editor = K.create('#editor_1');
        });
</script>
</head>
<body>
	<div id="topbar">
		<li class="logo"><a href="${ctx}/">土豪_Muscle
				的博客</a></li>
		<li class="link"><a href="${ctx}/account/post.action?tags=list">后台管理</a></li>
		<ul class="detail line"></ul>
	</div>

	<div id="maincontent">
		<p>
		<div id="content">
		<s:if test="tags ==null">
		<form id="inputForm" action="post!save.action" method="post">
		<input type="hidden" name="uuid" value="${uuid}"/>
		<div>
		<tr>
				<td>标题:</td>
				<td><input type="text" name="title" size="40" id="title" value="${title}"/></td>
			</tr><p>
			<tr>
				<td>类别:</td>
				<td><input type="text" id="status" name="status" size="40" value="${status}"/></td>
				<td>关键字:</td>
				<td><input type="text" id="keyword" name="keyword" size="40" value="${keyword}"/></td>
			</tr><p>
		<tr><td>
		<textarea id="editor_1" name="content" style="width:670px;height:450px;visibility:hidden;">${content}</textarea></td>
		</tr><tr>
				<td colspan="2">
						<input class="button" type="submit" value="提交"/>
					<input class="button" type="button" value="返回" onclick="history.back()"/>
				</td>
			</tr></div>
		</form></s:if><s:else>
		<div id="informations" class="informations">
		<div>
					<ul class="info_ul">
						<li class="title"><a href="${ctx}/account/post!input.action?uuid=${uuid}&tags=view"
							title="文章浏览次数">${title}</a></li>
					</ul>
					<ul class="detail">
						<li class="icon-calendar"><span><a href=""
							title="文章浏览次数">${inputTime}</a></span></li>
						<li class="icon-copy"><a href=""
							title="文章浏览次数">${status}</a></li>
						<li class="icon-eye-open"><a href="javascript:;"
							title="文章浏览次数">${views} views</a></li>
					</ul>
					
					<ul class="content_ul">
						<li ><p>
								
							</p>${content}</li>
					</ul></td>
					<ul class="detail line"></ul>

				</div>
		</div>
</s:else>
		</div>
		<%@ include file="catalogue.jsp"%>
</body>
</html>