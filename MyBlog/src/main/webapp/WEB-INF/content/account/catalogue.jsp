<%@ page contentType="text/html;charset=UTF-8"%>			
			<div id="catalogue">
				<!-- 最新文章 -->
				<div class="item">
					<ul class="title" onclick="ShowNone(&#39;lastessay&#39;)">
						<li class="titletxt">最新文章</li>
						<li class="titleline"></li>
					</ul>
					
					<ul id="lastessay" class="catal">
					
  
						<s:iterator value="lastPostMap" id="column">  
						<li>
							<a href="${ctx}/account/post!input.action?uuid=<s:property value="value"/>&tags=views" title="<s:property value="key"/>"><s:property value="key"/></a>
						</li>
						</s:iterator>  
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
							<a href="./list_files/list.htm" title="Linux">Linux(12)</a>
						</li>
						
						<li>
							<a href="http://zcoson.com/list/8-1.py" title="html script">html script(1)</a>
						</li>
						
						<li>
							<a href="http://zcoson.com/list/10-1.py" title="perl">perl(4)</a>
						</li>
						
						<li>
							<a href="http://zcoson.com/list/11-1.py" title="Tomcat">Tomcat(1)</a>
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
						<li>J2EE中间件技术 第三次作业</li>
					</ul>
				</div>
	
			</div>
		</div>
	
		<div id="footer">
			<div id="copy">© 2011 博客</div>
		</div>
	