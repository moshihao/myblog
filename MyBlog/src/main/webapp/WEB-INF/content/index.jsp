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
</head>
<body>
	<div id="topbar">
		<li class="logo"><a href="http://muscle1990.com">土豪_Muscle
				的博客</a></li>
		<li class="link"><a href="${ctx}/login.action">后台管理</a></li>
		<ul class="detail line"></ul>
	</div>

	<div id="maincontent">
		<p>
		<div id="content">
			<div id="informations" class="informations">
				<div>
					<ul class="info_ul">
						<li class="title"><a href="http://zcoson.com/detail/10032.py">Linux
								安装新字体</a></li>
					</ul>
					<ul class="detail">
						<li class="icon-calendar"><span>2013-05-02 08:12:04</span></li>
						<li class="icon-copy"><a href="http://zcoson.com/list/5-1.py"
							title="查看分类：Linux">Linux</a></li>
						<li class="icon-tags"><a href="javascript:;"
							title="查看标签：linux 字体">linux 字体</a></li>
						<li class="icon-eye-open"><a href="javascript:;"
							title="文章浏览次数">9 Read</a></li>
					</ul>
					<ul class="content_ul">
						<li><p>
								<strong>Linux 安装新字体</strong><strong></strong>
							</p> sssssssss<br></li>
					</ul>
					<ul class="detail line"></ul>

				</div>
				<div>
					<ul class="info_ul">
						<li class="title"><a href="http://zcoson.com/detail/10032.py">Linux
								安装新字体</a></li>
					</ul>
					<ul class="detail">
						<li class="icon-calendar"><span>2013-05-02 08:12:04</span></li>
						<li class="icon-copy"><a href="http://zcoson.com/list/5-1.py"
							title="查看分类：Linux">Linux</a></li>
						<li class="icon-tags"><a href="javascript:;"
							title="查看标签：linux 字体">linux 字体</a></li>
						<li class="icon-eye-open"><a href="javascript:;"
							title="文章浏览次数">9 Read</a></li>
					</ul>
					<ul class="content_ul">
						<li><p>
								<strong>Linux 安装新字体</strong><strong></strong>
							</p> sssssssss<br></li>
					</ul>
					<ul class="detail line"></ul>

				</div>
			</div>
		</div>

		<div id="catalogue">
			<!-- 最新文章 -->
			<div class="item">
				<ul class="title" onclick="ShowNone(&#39;lastessay&#39;)">
					<li class="titletxt">最新文章</li>
					<li class="titleline"></li>
				</ul>
				<ul id="lastessay" class="catal">


					<li><a href="http://zcoson.com/detail/10033.py"
						title="Linux scp 命令详解">Linux scp 命令详解</a></li>

					<li><a href="http://zcoson.com/detail/10032.py"
						title="Linux 安装新字体">Linux 安装新字体</a></li>

					<li><a href="http://zcoson.com/detail/10031.py"
						title="systemctl命令用法详解">systemctl命令用法详解</a></li>

					<li><a href="http://zcoson.com/detail/10030.py"
						title="fedora rmvb avi 解码">fedora rmvb avi 解码</a></li>

					<li><a href="http://zcoson.com/detail/10023.py"
						title="ubuntu+mysql+python+nginx+django">ubuntu+mysql+python+nginx+django</a>
					</li>


				</ul>
			</div>
			<!-- 类别 -->
			<div class="item">
				<ul class="title" onclick="ShowNone(&#39;essaysort&#39;)">
					<li class="titletxt">文章类别</li>
					<li class="titleline"></li>
				</ul>
				<ul id="essaysort" class="catal">


					<li><a href="http://zcoson.com/list/5-1.py" title="Linux">Linux(12)</a>
					</li>

					<li><a href="http://zcoson.com/list/8-1.py"
						title="html script">html script(1)</a></li>

					<li><a href="http://zcoson.com/list/10-1.py" title="perl">perl(4)</a>
					</li>

					<li><a href="http://zcoson.com/list/11-1.py" title="Tomcat">Tomcat(1)</a>
					</li>


				</ul>
			</div>
			<!-- 友情链接 -->
			<div class="item">
				<ul class="title" onclick="ShowNone(&#39;friend&#39;)">
					<li class="titletxt">链接</li>
					<li class="titleline"></li>
				</ul>
				<ul id="friend" class="catal">


					<li><a href="http://muscle1990.com/" target="_blank"
						title="SecOn">muscle1990.com</a></li>


				</ul>
			</div>

			<div class="item">
				<ul class="title" onclick="ShowNone(&#39;other&#39;);">
					<li class="titletxt">其他</li>
					<li class="titleline"></li>
				</ul>
				<ul id="other" class="catal">
					<!--<li><a href="http://zcoson.com/login.py">登录</a> | <a href="http://zcoson.com/register.py">注册</a>-->
					<li>J2EE与中间件开发课程作业</li>
				</ul>
			</div>

		</div>
	</div>
	<div id="footer">
		<div id="copy">© 土豪_Muscle 博客</div>
	</div>


</body>
</html>