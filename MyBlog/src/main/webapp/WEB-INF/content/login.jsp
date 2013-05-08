<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ page import="org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter" %>
<%@ page import="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter" %>
<%@ page import="org.springframework.security.web.WebAttributes" %>

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
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
			$(document).ready(function() {
				prettyPrint();
				$("#user_mail").keydown(function(e) {
					if(13==e.keyCode) {
						$("#keycode").focus();
					}
				});
				$("#keycode").keydown(function(e) {
					if(13==e.keyCode) {
						login_handler();
					}
				});
				/*
				$("#verification").keydown(function(e) {
					if(13==e.keyCode) {
						login_handler();
					}
				});*/
				$("#btn_login").click(function() {
					login_handler();
				});
			});
		</script>
		<div id="topbar">
		<li class="logo"><a href="http://muscle1990.com">土豪_Muscle
				的博客</a></li>
		<li class="link"><a href="${ctx}/login.action">后台管理</a></li>
		<ul class="detail line"></ul>
	</div>
	
		<div id="maincontent">
			<div id="content">
				<div class="login">
					<li class="loginform">
					<form  action="${ctx}/j_spring_security_check" method="post" >
						<p class="prompt">
							用户登录， [<a href="javascript:;">尚未注册</a>？]
						</p>
						<p>
							用户名:
							<input type='text' id='j_username' name='j_username' class="text"
					<s:if test="not empty param.error">
						value='<%=session.getAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_LAST_USERNAME_KEY)%>'</s:if> />
			
						</p>
						<p>
							密码&nbsp;：
							<input type='password' id='j_password' name='j_password' class="text"/>
						</p>
						
						<p>
							<input value="登录" type="submit" class="button" class="btn"/>
						</p>
						</form>
					</li>
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
					
						
						<li>
							<a href="http://zcoson.com/detail/10033.py" title="Linux scp 命令详解">Linux scp 命令详解</a>
						</li>
						
						<li>
							<a href="http://zcoson.com/detail/10032.py" title="Linux 安装新字体">Linux 安装新字体</a>
						</li>
						
						<li>
							<a href="http://zcoson.com/detail/10031.py" title="systemctl命令用法详解">systemctl命令用法详解</a>
						</li>
						
						<li>
							<a href="http://zcoson.com/detail/10030.py" title="fedora rmvb avi 解码">fedora rmvb avi 解码</a>
						</li>
						
						<li>
							<a href="http://zcoson.com/detail/10023.py" title="ubuntu+mysql+python+nginx+django">ubuntu+mysql+python+nginx+django</a>
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
					
						
						<li>
							<a href="http://zcoson.com/list/1-5.py" title="Linux">Linux(12)</a>
						</li>
						
						<li>
							<a href="http://zcoson.com/list/1-8.py" title="html script">html script(1)</a>
						</li>
						
						<li>
							<a href="http://zcoson.com/list/1-10.py" title="perl">perl(4)</a>
						</li>
						
						<li>
							<a href="http://zcoson.com/list/1-11.py" title="Tomcat">Tomcat(1)</a>
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
					
						
						<li>
							<a href="http://secon.me/" target="_blank" title="SecOn">SecOn</a>
						</li>
						
						<li>
							<a href="http://opencdn.me/" target="_blank" title="OpenCDN">OpenCDN</a>
						</li>
						
						<li>
							<a href="http://www.zooboa.com/" target="_blank" title="zooboa">zooboa</a>
						</li>
						
						<li>
							<a href="http://www.firefoxbug.net/" target="_blank" title="firefoxbug">firefoxbug</a>
						</li>
						
					
					</ul>
				</div>
	
				<div class="item">
					<ul class="title" onclick="ShowNone(&#39;other&#39;);">
						<li class="titletxt">其他</li>
						<li class="titleline"></li>
					</ul>
					<ul id="other" class="catal">
						<!--<li><a href="http://zcoson.com/login.py">登录</a> | <a href="http://zcoson.com/register.py">注册</a>-->
						<li>网站编码：UTF-8</li>
					</ul>
				</div>
	
			</div>
		</div><div id="footer">
		<div id="copy">© 土豪_Muscle 博客</div>
	</div>
	

</body></html>