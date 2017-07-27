<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="/Wild_Hibernate4_MySQL/" />
<title>Wild_Hibernate4_MySQL</title>
<script type="text/javascript" src="page/js/jquery-1.9.1.js"></script>
</head>
<script type="text/javascript">
	function testee(){
		$.post("user/logins", function(data) {
			alert(data);
			if (data > 0) {
				alert("成功！");
			} else {
				alert("shibai!");
			}
		});
		}
</script>
<body>${result }

<form action="">
	<input type="button" onclick="testee()" value="快点击我...">
</form>
</body>
</html>
