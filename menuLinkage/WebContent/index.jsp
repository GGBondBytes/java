<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
		$.ajax({
			url : "SchoolServlet",
			type : "post",
			async : true,
			dataType : "json",
			success : function(schools) {
				if(schools.length>0){
					$("#schools").empty();
				}
				for(var i=0;i<schools.length;i++){
					
					$("#schools").append("<option value="+schools[i]["sid"]+">"+schools[i]["sname"]+"</option>");
				}
			},
			error : function(exception) {
				alert("错误提示： " + exception.status + " " + exception.statusText);
			}
		});
	
	 $("#schools").change(function(){
		 var sid=$("#schools").val();
		 $.ajax({
				url : "MajorServlet",
				type : "post",
				async : true,
				data :"sid="+sid,
				dataType : "json",
				success : function(majors) {
					if(majors.length>0){
						$("#majors").empty();
					}
					for(var i=0;i<schools.length;i++){
						$("#majors").append("<option value="+majors[i]["mid"]+">"+majors[i]["mname"]+"</option>");
					}
				},
				error : function(exception) {
					alert("错误提示： " + exception.status + " " + exception.statusText);
			}
		});
	});
});

</script>
</head>
<body>
	
	<select id="schools">
	<option >---请选择学院---</option>
	</select>
	<select id="majors">
	<option value="0">---请选择专业---</option>
	</select>
</body>
</html>