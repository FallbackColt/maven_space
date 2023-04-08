<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>财务管理系统</title>
<base href="http://localhost:8000/finance/">
<link type="text/css" rel="stylesheet" href="css/style.css" >
<script type="text/javascript" src="script/jquery-3.6.3.js"></script>
<script type="text/javascript">
	$(function () {
		$("input[type=submit]").click(function () {
			var patt = /^\w{5,12}$/;

			// 检测用户名
			if (!patt.test($("#username").val())) {
				alert("用户名不合法！");
				return false;
			}

			// 检测密码
			if (!patt.test($("#password").val())) {
				alert("密码不合法！");
				return false;
			}

			// 检测验证码
			if ($("#verify").val()!=="123456") {
				alert("验证码错误！");
				return false;
			}

		});

		$("#updatePassword").click(function () {
			window.location.href="pages/updatePassword.jsp";
		});

	});

</script>
</head>
<body>
	<div><h1>财务管理系统</h1></div>
	<div class="mainBody">
		<form class="login" action="/finance/login" method="post">
			<div>
				<div>
					<label for="username">账号:</label>
					<input type="text" name="username" id="username" placeholder="请输入用户名">
					<span></span>
				</div>
				<div>
					<label for="password">密码:</label>
					<input type="password" name="password" id="password" placeholder="请输入密码">
					<span></span>
				</div>
                <div>
                    <label for="verify">验证码:</label>
                    <input type="text" name="password" id="verify" placeholder="请输入验证码">
                    <span></span>
                </div>
                <div>
                    <img src="imgs/code.bmp">
                    <input type="button" value="获取验证码" id="verifyButton" style="width: 10%">
                    <span></span>
                </div>
				<div>
					<input type="submit" value="登录">
					<input type="button" value="修改密码" id="updatePassword" style="font-size: 79.5%">
				</div>
			</div>
		</form>

<%--					<%= application.getAttribute("LoginFrame") %>--%>
<%--					<%= ((IdToApplyType[]) application.getAttribute("applyTypes"))[0].getId() %>--%>
<%--					<%= ((IdToApplyType[]) application.getAttribute("applyTypes"))[0].getApplyTypeName() %>--%>
<%--					<%= ((IdToApplyType[]) application.getAttribute("applyTypes"))[1].getApplyTypeName() %>--%>
<%--					<%= ((IdToApplyType[]) application.getAttribute("applyTypes"))[2].getApplyTypeName() %>--%>
<%--					<%= application.getAttribute("applyReasons") %>--%>
<%--					<%= application.getAttribute("applyStatuses") %>--%>
<%--					<%= application.getAttribute("departments") %>--%>

<%--		<%for (IdToApplyType applyType : ((IdToApplyType[]) application.getAttribute("applyTypes"))) {%>--%>
<%--			<%="applyType: " + applyType + ""%>--%>
<%--		<%}%>--%>

		</div>


	</div>

</body>
</html>