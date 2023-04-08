<%@ page contentType="text/html;charset=UTF-8" language=    "java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>财务管理系统</title>
  <link type="text/css" rel="stylesheet" href="../css/style.css" >
  <script type="text/javascript" src="../script/jquery-3.6.3.js"></script>
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

        // 检测新的密码
        if ($("#newPassword").val()!==$("#rePassword").val()) {
          alert("请确顶两次输入的密码是否一致！");
          return false;
        }
      });

      $("input[type=button]").click(function () {
         window.location.href="/finance";
      });

    });

  </script>
</head>
<body>
<div><h1>修改密码</h1></div>
<div class="mainBody">
  <form class="login" action="/finance/updatePassword" method="post">
    <div>
      <div>
        <label for="username">账号:</label>
        <input type="text" name="username" id="username" placeholder="5到12位字母，数字或下划线">
      </div>
      <div>
        <label for="password">密码:</label>
        <input type="password" name="password" id="password" placeholder="5到12位字母，数字或下划线">
      </div>
      <div>
        <label for="newPassword">新的密码:</label>
        <input type="password" name="newPassword" id="newPassword" placeholder="请输入新的密码">
      </div>
      <div>
        <label for="rePassword">确认密码:</label>
        <input type="password" id="rePassword" placeholder="确认密码">
      </div>
      <div>
        <input type="submit" value="修改">
        <input type="button" value="返回">
      </div>
    </div>
  </form>

</div>

</body>
</html>