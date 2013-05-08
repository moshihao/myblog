(function($) {
	var divpoup=
	"<style>#cover {width:100%; position:fixed;_position:fixed; top:10px; text-align:center; display:none;z-index:99999;}" +
	"#cover #covercontent {padding:5px 30px;-moz-border-radius:3px; -khtml-border-radius:3px; -webkit-border-radius:3px; border-radius:3px;}" +
	".covererror {background: #FFEBE8; border: solid #CC0000 1px;}.coversuccess {background: #F7FEF3; border: solid #4CBE00 1px;}" +
	".loadimg{padding-right:15px;}</style><div id=\"cover\"><span id=\"covercontent\"></span></div>";
	document.write(divpoup);
	
	$.showmsg = function(content,loadimg,time) {
		if (undefined==time||''==time) {
			time=1;
		}
		var imgsrc="";
		if (1==loadimg) {
			imgsrc="<img src=\"static/imgs/loader2.gif\" class=\"loadimg\" />";
		}
		
		$("#covercontent").html("");
		$("#cover").show();
		$("#covercontent").html(imgsrc+" "+content);
		$("#covercontent").removeClass("covererror");
		$("#covercontent").addClass("coversuccess");
		
		if (1000<time) {
			setTimeout(function () {
				$("#cover").hide();
				$("#covercontent").html("");
			}, time);
		}
	},
	
	$.errormsg = function(content, time) {
		if (undefined==time||''==time) {
			time=5500;
		}
		
		$("#covercontent").html("");
		$("#cover").show();
		$("#covercontent").html(content);
		$("#covercontent").removeClass("coversuccess");
		$("#covercontent").addClass("covererror");
		
		setTimeout(function () {
			$("#cover").hide();
			$("#covercontent").html("");
		}, time);
	},

	$.hidemsg = function() {
		$("#cover").hide();
		$("#covercontent").html("");
		$("#covercontent").removeClass("covererror");
		$("#covercontent").removeClass("coversuccess");
	}
	
})(jQuery);