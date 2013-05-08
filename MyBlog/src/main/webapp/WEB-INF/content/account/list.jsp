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
			<div id="content">
				<div id="informations" class="informations">
					<table id="tabEssayData" cellspacing="0" class="data_table">
						<tbody>
							<tr>
								<td class="thead" align="left" width="130px;">标题</td>
								<td class="thead" align="left" width="100px;">类别</td>
								<td class="thead" align="center" width="40px;">阅读</td>
							</tr>
								<s:iterator value="postPage.result">
							<tr>
								<td class="tbody">
									<li style="width:300px;">
										<a href="${ctx}/account/post!input.action?uuid=${uuid}&tags=views"
							title="标题">${title}</a>
									</li>
								</td>
								<td class="tbody">
									<li style="width:105px;">编辑</li>
								</td>
								<td class="tbody" align="center">${views}</td>
							</tr>
								</s:iterator>
						</tbody>
					</table>
				</div>
			</div>
		
</body></html>