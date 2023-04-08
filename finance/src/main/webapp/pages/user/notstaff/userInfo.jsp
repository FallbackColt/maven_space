<%@ page import="com.practice.finance.pojo.IdToDepartment" %>
<%@ page import="com.practice.finance.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>财务管理系统</title>
  <base href="http://localhost:8000/finance/pages/user/notstaff/">
  <link type="text/css" rel="stylesheet" href="../../../css/style.css" >
  <script type="text/javascript" src="../../../script/jquery-3.6.3.js"></script>
  <script type="text/javascript">
    $(function () {

      // 选择相应的用户
      $("span[name=select]").click(function () {
        $("input[name=id]").val(this.parentNode.firstElementChild.id);

        $("input[name=username]").val(this.parentNode.children[1].innerText);
        $("input[name=username]")[0].disabled = "disabled";
        $("input[name=name]").val(this.parentNode.children[2].innerText);
        $("input[name=name]")[0].disabled = "disabled";
        var a = this.parentNode.children[3].innerText
        $("option").each(function () {
          if (this.innerText==a) {
            this.selected = "selected"
          }
        });
        $("input[name=superior]").val(this.parentNode.children[4].innerText);
        $("input[name=account]").val(this.parentNode.children[5].innerText);
      });

      $("input[name=add]").click(function () {
        if($("input[name=username]").val()) {
          alert("请输入用户名");
          return false;
        }
        if($("input[name=name]").val()) {
          alert("请输入姓名");
          return false;
        }
        if($("option[disabled=disabled]").value=="0") {
          alert("请选择所在部门");
          return false;
        }

        $("input[name=option]").val("0");
      });

      $("input[name=update]").click(function () {

        $("input[name=option]").val("1");
      });

      $("input[name=query]").click(function () {
        $("input[name=option]").val("2");
      });

      $("input[name=cancelQuery]").click(function () {
        $("input[name=option]").val("3");
      });

      $("input[name=delete]").click(function () {
        $("input[name=option]").val("4");
      });



    });
  </script>
</head>
<body>
<div class="mainBody">
  <div class="logined">
    <div>
      <span name="placeholder"></span>
      <span>你好：<%=session.getAttribute("username")%>，</span>
      <span><a href="../../pages/user/staff.jsp">首页</a></span>&nbsp;&nbsp;&nbsp;
      <span><a href="../../index.jsp">注销</a></span>
    </div>

    <br><br><br>

    <div class="option">
     <form action="http://localhost:8000/finance/updateUserInfo" method="post">
       <table>
         <tr>
           <td><label for="username">用户名：</label></td>
           <td>
             <input type="text" name="username" id="username" placeholder="5到12位字母，数字或下划线">
           </td>
         </tr>
         <tr>
           <td><label for="name">姓名:</label></td>
           <td>
             <input type="text" name="name" id="name" placeholder="输入真实姓名">
           </td>
         </tr>
         <tr>
           <td>职位:</td>
           <td>
             <select name="department">
               <option value=0>----默认部门----</option>
               <%for (IdToDepartment idToDepartment:
                       (IdToDepartment[]) application.getAttribute("departments")) {
               %>
               <%= "<option value=" + idToDepartment.getId() + ">" + idToDepartment.getDepartmentName() + "</option>"%>
               <%}%>
             </select>
           </td>
         </tr>
         <tr>
           <td><label for="superior">直属上级:</label></td>
           <td>
             <input type="text" name="superior" id="superior" placeholder="请输入直属上级的用户名">
           </td>
         </tr>
         <tr>
           <td><label for="account">打款账号:</label></td>
           <td>
             <input type="text" name="account" id="account" placeholder="请输入打款账号">
           </td>
         </tr>
         <tr>
           <td colspan="2">
             <input type="text" hidden="hidden" name="id" value="-1">
             <input type="text" hidden="hidden" name="option">
             <input type="submit" value="添加" name="add">
             <input type="submit" value="修改" name="update">
             <input type="submit" value="查询" name="query">
             <input type="submit" value="取消查询" name="cancelQuery">
             <input type="submit" value="删除" name="delete">
           </td>
         </tr>
       </table>
     </form>
    </div>

    <div><br><br><br><br></div>

    <div class="userInfo">
      <div>
        <span>索引</span>
        <span>用户名</span>
        <span>姓名</span>
        <span>职位</span>
        <span>直属上级</span>
        <span>打款账号</span>
        <span>操作</span>
      </div>

      <%
        User[] users = (User[]) session.getAttribute("users");
        for (int i=0; i< users.length; i++) {
      %><div>

      <%= "<span id=\"" + users[i].getId() + "\">" + (i+1) + "</span>" %>
      <%= "<span>" + users[i].getUsername() + "</span>" %>
      <%= "<span>" + users[i].getName() + "</span>" %>
      <%for (IdToDepartment idToDepartment:
              (IdToDepartment[]) application.getAttribute("departments")) {
        if (idToDepartment.getId() == users[i].getDepartment()) {
      %>
      <%= "<span value=" + idToDepartment.getId() + "\">" + idToDepartment.getDepartmentName() + "</span>"%>
      <%}
      }%>
      <%= "<span>" + users[i].getSuperior() + "</span>" %>
      <%= "<span>" + users[i].getAccount() + "</span>" %>
      <span name="select" style="color: blue; cursor: pointer">选择</span>
    </div>
      <%}%>
    </div>
  </div>
</div>

</body>
</html>