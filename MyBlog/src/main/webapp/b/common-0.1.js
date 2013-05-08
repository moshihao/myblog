function reinitIframe(id){
	var iframe = document.getElementById(id);
	try{
		var bHeight = iframe.contentWindow.document.body.scrollHeight;
		var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
		var height = Math.max(bHeight, dHeight);iframe.height = height;
	}
	catch (ex){}
}

function ShowNone(id){
	var obj = document.getElementById(id);
	if(obj.style.display=='inline'||obj.style.display=='') {
		obj.style.display='none';
	}else{
		obj.style.display='inline';
	}
}

function login_handler() {
	var usermail = $("#user_mail").val();
	if (undefined==usermail||""==usermail) {
		jQuery.errormsg("请输入邮箱帐号！"); 
		return false;
	}
	var keycode = $('#keycode').val();
	if (undefined==keycode||""==keycode) {
		jQuery.errormsg("请输入密码！"); 
		return false;
	}
	/*
	var verification = $('#verification').val();
	if (undefined==verification||""==verification) {
		jQuery.errormsg("请输入验证码！"); 
		return false;
	}*/
	jQuery.showmsg("正在登录......", 1);

	var idata={
		"keycode":keycode,
		"usermail":usermail
	}
	$.post(basePath+"loginhandler"+extend,idata,
		function(json) {
			if ("0"==json.code) {
				jQuery.errormsg(json.message);
			} else {
				jQuery.showmsg("登录成功，地址正在跳转中.....", 0, 1000);
				setTimeout(function(){location.href=basePath+'center/'}, 1000);
			}
		}, 
	"json");
}

function firend_append() {
	var friend_id = $("#friend_id").val();
	var friend_name = $("#friend_name").val();
	if (""==friend_name) {
		jQuery.errormsg("友情链接名称不可以为空");
		return ;
	}
	var friend_url = $("#friend_url").val();
	if (""==friend_url) {
		jQuery.errormsg("友情链接URL不可以为空"); 
		return ;
	}
	var state = $("#state").val();
	if (""==state) {
		jQuery.errormsg("友情链接状态不可以为空"); 
		return ;
	}
	
	var object = {"idata" : JSON.stringify({
		"friend_id":friend_id,
		"friend_name":friend_name,
		"friend_url":friend_url,
		"friend_state":state
	})};
	
	var object = {
		"friend_id":friend_id,
		"friend_name":friend_name,
		"friend_url":friend_url,
		"friend_state":state
	};
	
	$.post(basePath+"center/link/appendhandler"+extend, 
			object,
		function (odata) {
			if("0"==odata.code) {
				jQuery.errormsg(odata.message); 
			} else {
				$("#friend_id").val("");
				$("#friend_name").val("");
				$("#friend_url").val("");
				$("#state").val("Y");
				jQuery.errormsg("处理成功");
			}
		}, 
	"json");
}

function firend_object() {
	var friend_id = $("#friend_id").val();
	if ("0"==friend_id) {
		return ;
	}
	$.post(basePath+"center/link/objecthandler"+extend, 
		{"friend_id":friend_id}, 
		function (odata) {
			if("0"==odata.code) {
				jQuery.errormsg(odata.message); 
			} else {
				if (undefined==odata.data) {
					return ;
				}
				$("#friend_id").val(odata.data.friend_id);
				$("#friend_name").val(odata.data.friend_name);
				$("#friend_url").val(odata.data.friend_url);
				$("#state").val(odata.data.state);
			}
		}, 
	"json");
}

function friend_list(cur) {
	
	jQuery.showmsg("数据加载中...");
	
	$.post(basePath+"center/link/listhandler"+extend,
		{"cur":cur}, 
		function (json) {
			if("0"==json.code) {
				jQuery.errormsg(json.message);
				return ;
			}
			
			var tab_obj = $("#tab_friendList");
			tab_obj.empty();
			
			var tab_head = "<tr>" +
				"<td class='thead' align='left' width='120px;'>链接名称</td>" +
				"<td class='thead' align='left' width='300px;'>链接地址</td>" +
				"<td class='thead' align='center' width='30px;'>状态</td>" +
				"<td class='thead' align='center' width='54px;'>操作</td></tr>";
			tab_obj.append(tab_head);
			
			var list = json.data;
			for(i=0; i<list.length; i++) {
				
				var state = "";
				if ("Y"==list[i].state) {
					state = "启用";
				} else if ("N"==list[i].state) {
					state = "<span style='color:red;'>停用</span>";
				} else {
					state = "未知";
				}
				
				var setting = "<a href='"+basePath+"center/link/append-"+list[i].friend_id+extend+"'>更新</a>&nbsp;";
				setting += "<a href='javascript:firend_remove("+list[i].friend_id+",\""+list[i].friend_name+"\");'>删除</a>";
				if ("0"==list[i].user_id) {
					setting = "<span class='fcGrey'>全局链接</span>";
				}
				
				var tab_td = "<tr>" +
				"<td class='tbody'>"+list[i].friend_name+"</td>" +
				"<td class='tbody'><a href='"+list[i].friend_url+"' target='_blank'>"+list[i].friend_url+"</a></td>" +
				"<td class='tbody' align='center'>"+state+"</td>" +
				"<td class='tbody' align='center'>"+setting+"</td></tr>";
				tab_obj.append(tab_td);
			}
			
			var page_content = "<tr><td class='page pt30' colspan='4'>";
			page_content += page_handler(json.page)+"</td></tr>";
			tab_obj.append(page_content);
		}, 
	"json");
	jQuery.hidemsg();
}

function firend_remove(id,name) {
	if (undefined==id||""==id) {
		return ;
	}
	if(confirm("确认删除（"+name+"）链接吗？")) {
		$.post(basePath+"center/link/removehandler"+extend, 
			{"friend_id" : id}, 
			function (odata) {
				if("0"==odata.code) {
					jQuery.errormsg(odata.message); 
				} else {
					jQuery.showmsg("处理成功");
					friend_list(1);
				}
			}, 
		"json");
	}
}




function sort_object() {
	var sort_id = $("#sort_id").val();
	if ("0"==sort_id) {
		return ;
	}
	$.post(basePath+"center/sort/objecthandler"+extend, 
		{"sort_id":sort_id}, 
		function (odata) {
			if("0"==odata.code) {
				jQuery.errormsg(odata.message); 
			} else {
				if (undefined==odata.data) {
					return ;
				}
				$("#sort_id").val(odata.data.sort_id);
				$("#sort_name").val(odata.data.sort_name);
				$("#superior").val(odata.data.superior);
				$("#orderby").val(odata.data.orderby);
				$("#state").val(odata.data.state);
			}
		}, 
	"json");
}

function sort_list(cur) {
	jQuery.showmsg("数据加载中...");
	$.post(basePath+"center/sort/listhandler"+extend, 
		{"cur" : cur}, 
		function (json) {
			if("0"==json.code) {
				jQuery.errormsg(json.message);
				return ;
			}
			
			var tab_obj = $("#tab_sortList");
			tab_obj.empty();
			
			var tab_head = "<tr>";
			tab_head+="<td class='thead' align='left' width='230px;'>类别名称</td>";
			tab_head+="<td class='thead' align='left' width='230px;'>父名称</td>";
			tab_head+="<td class='thead' align='center' width='50px;'>数量</td>";
			tab_head+="<td class='thead' align='center' width='50px;'>全数量</td>";
			tab_head+="<td class='thead' align='center' width='60px;'>排序号</td>";
			tab_head+="<td class='thead' align='center' width='40px;'>状态</td>";
			tab_head+="<td class='thead' align='center' width='80px;'>操作</td></tr>";
			tab_obj.append(tab_head);
			
			var list = json.data;
			for(i=0; i<list.length; i++) {
				
				var state = "";
				if ("Y"==list[i].state) {
					state = "启用";
				} else if ("N"==list[i].state) {
					state = "<span style='color:red;'>停用</span>";
				} else {
					state = "未知";
				}
				
				var setting = "<a href='"+basePath+"center/sort/append-"+list[i].sort_id+extend+"'>更新</a>&nbsp;";
				if (0==list[i].superior) {
					if (list[i].sort_count==0) {
						setting += "<a href='javascript:sort_remove("+list[i].sort_id+",\""+list[i].sort_name+"\");'>删除</a>";
					}
				} else {
					if (0==list[i].all_count) {
						setting += "<a href='javascript:sort_remove("+list[i].sort_id+",\""+list[i].sort_name+"\");'>删除</a>";
					}
				}
				
				var tab_tbody = "<tr>";
				tab_tbody+="<tr><td class='tbody'>"+list[i].sort_name+"</td>";
				tab_tbody+="<td class='tbody'>"+list[i].superior_name+"</td>";
				tab_tbody+="<td class='tbody' align='center'>"+list[i].sort_count+"</td>";
				tab_tbody+="<td class='tbody' align='center'>"+list[i].all_count+"</td>";
				tab_tbody+="<td class='tbody' align='center'>"+list[i].orderby+"</td>";
				tab_tbody+="<td class='tbody' align='center'>"+state+"</td>";
				tab_tbody+="<td class='tbody' align='center'>"+setting+"</td></tr>";
				tab_obj.append(tab_tbody);
			}
			
			var page_content = "<tr><td class='page pt30' colspan='7'>";
			page_content += page_handler(json.page)+"</td></tr>";
			tab_obj.append(page_content);
		}, 
	"json");
	jQuery.hidemsg();
}


function sort_append() {
	var sort_name = $("#sort_name").val();
	if (""==sort_name) {
		jQuery.errormsg("类别名称不可以为空"); 
		return ;
	}
	var superior = $("#superior").val();
	if (""==superior) {
		jQuery.errormsg("父类别不可以为空"); 
		return ;
	}
	var state = $("#state").val();
	if (""==state) {
		jQuery.errormsg("友情链接状态不可以为空");
		return ;
	}
	var orderby = $("#orderby").val();
	if (""==orderby) {
		orderby = "2000";
	}
	var idata = {
		"state":state,
		"orderby":orderby,
		"superior":superior,
		"sort_name":sort_name,
		"sort_id":$("#sort_id").val()
	};
	
	$.post(basePath+"center/sort/appendhandler"+extend, idata, 
		function (odata) {
			if("0"==odata.code) {
				jQuery.errormsg(odata.message); 
			} else {
				$("#sort_id").val("");
				$("#sort_name").val("");
				$("#state").val("Y");
				$("#superior").val("");
				jQuery.errormsg("处理成功");
			}
		}, 
	"json");
}

function sort_remove(id,name) {
	if (undefined==id||""==id) {
		return ;
	}
	if(confirm("确认删除（"+name+"）类别吗？")) {
		$.post(basePath+"center/sort/removehandler"+extend, 
			{"sort_id" : id}, 
			function (odata) {
				if("0"==odata.code) {
					jQuery.errormsg(odata.message); 
				} else {
					jQuery.showmsg("处理成功");
					sort_list(1);
				}
			}, 
		"json");
	}
}


function essay_list(cur) {
	
	jQuery.showmsg("数据加载中...");
	
	$.post(basePath+"center/wz/listhandler"+extend, 
		{"cur":cur}, 
		function (json) {
			if("0"==json.code) {
				jQuery.errormsg(json.message);
				return ;
			}
			
			var tabData = $("#tabEssayData");
			tabData.empty();
			
			var head="<tr>";
			head+="<td class='thead' align='left' width='130px;'>标题</td>";
			head+="<td class='thead' align='left' width='100px;'>类别</td>";
			head+="<td class='thead' align='left' width='60px;'>修改时间</td>";
			head+="<td class='thead' align='center' width='40px;'>阅读</td>";
			head+="<td class='thead' align='center' width='40px;'>评论</td>";
			head+="<td class='thead' align='center' width='40px;'>状态</td>";
			head+="<td class='thead' align='center' width='60px;'>操作</td></tr>";
			tabData.append(head);
			
			var list = json.data;
			for(i=0; i<list.length; i++) {
				var state="";
				if ("Y"==list[i].state) {
					state = "启用";
				} else if ("N"==list[i].state) {
					state = "<span style='color:red;'>停用</span>";
				} else {
					state = "未知";
				}
				
				var setting = "<a href='"+basePath+"center/wz/append-"+list[i].essay_id+extend+"'>更新</a>&nbsp;";
				setting += "<a href='javascript:essay_remove("+list[i].essay_id+",\""+list[i].essay_title+"\");'>删除</a>";
				
				var body="<tr>";
				body+="<td class='tbody'><li style='width:300px;'><a title='文章预览' href='"+basePath+"center/wz/preview-"+list[i].essay_id+extend+"' target='_blank'>"+list[i].essay_title+"</a></li></td>";
				body+="<td class='tbody'><li style='width:105px;'>"+list[i].sort_name+"</li></td>";
				body+="<td class='tbody'><li style='width:143px;'>"+list[i].dateline+"</li></td>";
				body+="<td class='tbody' align='center'>"+list[i].read_count+"</td>";
				body+="<td class='tbody' align='center'>"+list[i].comment_count+"</td>";
				body+="<td class='tbody' align='center'>"+state+"</td>";
				body+="<td class='tbody' align='center'>"+setting+"</td></tr>";
				tabData.append(body);
			}
			
			var pageContent = "<tr><td class='page pt30' colspan='7'>";
			pageContent += page_handler(json.page)+"</td></tr>";
			tabData.append(pageContent);
		}, 
	"json");
	jQuery.hidemsg();
}

function essay_object(editor) {
	var essay_id = $("#essay_id").val();
	if ("0"==essay_id) {
		return ;
	}	
	$.post(basePath+"center/wz/objecthandler"+extend, 
		{"essay_id":$("#essay_id").val()}, 
		function (odata) {
			if("0"==odata.code) {
				jQuery.errormsg(odata.message); 
			} else {
				
				if (undefined==odata.data) {
					return ;
				}
				
				editor.html(odata.data.essay_content);
				$("#sort_id").val(odata.data.sort_id);
				$("#sort_id_old").val(odata.data.sort_id);
				$("#essay_id").val(odata.data.essay_id);
				$("#essay_title").val(odata.data.essay_title);
				$("#essay_tags").val(odata.data.essay_tags);
				$("#state").val(odata.data.state);
				attachedUri = odata.data.attachment;
			}
		}, 
	"json");
}

function essay_append(editor) {
	var essayId = $("#essay_id").val();
	var essayTitle = $("#essay_title").val();
	if (""==essayTitle) {
		jQuery.errormsg("文章[标题]不可以为空"); 
		return ;
	}
	var essayTags = $("#essay_tags").val();
	if (""==essayTags) {
		jQuery.errormsg("文章[标签]不可以为空"); 
		return ;
	}
	var essayContent = editor.html();
	if (""==essayContent) {
		jQuery.errormsg("文章[内容]不可以为空"); 
		return ;
	}
	var sortId = $("#sort_id").val();
	if (""==sortId) {
		jQuery.errormsg("文章[类别]不可以为空"); 
		return ;
	}
	var state = $("#state").val();
	if (""==state) {
		jQuery.errormsg("文章[状态]不可以为空"); 
		return ;
	}
	
	var idata = {
		"state":state,
		"sort_id":sortId,
		"essay_id":essayId,
		"essay_tags":essayTags,
		"attachment":attachedUri,
		"essay_title":essayTitle,
		"essay_content":essayContent
	};
	
	$.post(basePath+"center/wz/appendhandler"+extend,idata,
		function (odata) {
			if("0"==odata.code) {
				jQuery.errormsg(odata.message); 
			} else {
				$("#state").val("Y");
				$("#essay_id").val("");
				$("#essay_title").val("");
				$("#essay_content").val("");
				$("#essay_tags").val("");
				editor.html("");
				jQuery.errormsg("处理成功");
			}
		}, 
	"json");
}

function essay_remove(id,title) {
	if (undefined==id||""==id) {
		return ;
	}
	if(confirm("确认删除（"+title+"）文章吗？")) {
		$.post(basePath+"center/wz/removehandler"+extend, 
			{"essay_id" : id}, 
			function (odata) {
				if("0"==odata.code) {
					jQuery.errormsg(odata.message); 
				} else {
					jQuery.showmsg("处理成功");
					essay_list(1);
				}
			}, 
		"json");
	}
}
