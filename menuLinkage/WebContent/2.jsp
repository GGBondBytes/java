<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
<script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$.buildLinkageSeclect();
	})
</script>
<script type="text/javascript">
	$.buildLinkageSeclect=function(){
		$.ajax({
			url : "SchoolServlet",
			type : "post",
			data : null,
			success : function(result) {
				var data = eval("("+result+")");//将收到的json文本转换成JavaScript对象
				var option = "<option value='000' selected='selected'>院系名称</option>";
				$("#school").append(option);
				$.each(data,function(index,o){   //遍历处理data,fnction(index,value)中index是当前元素的位置,value是值。
					var option = "<option value='"+o.sid+"'>"+o.sname+"</option>"
					$("#school").append(option);  //在被选元素的结尾（仍然在内部）插入指定内容。
				});
			}
		})
		$("#school").change(function() {
			$("#major").empty();//清空专业下拉列表框的内容
			var id = $("#school").val();
			if(parseInt(id)==000){
				$("#major").hide();//隐藏专业下拉列表框
			}else{
				$.ajax({
					url : "MajorServlet",
					type : "post",
					data : {id:id},
					success : function(result) {
						var data = eval("("+result+")");
						var option = "<option value='000' selected='selected'>专业名称</option>";
						$("#major").append(option);
						$.each(data,function(i,o){
							var option = "<option value='"+o.mid+"'>"+o.mname+"</option>"
							$("#major").append(option);
							$("#major").show();//显示专业下拉列表框
						});
					}
				})
			}
		})
	}
</script>
</head>
<body>
<select name="school" id="school"></select>
<select name="major" id="major" style="display: none;"></select>
</body>
</html>