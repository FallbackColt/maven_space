<%@ page import="com.practice.finance.pojo.IdToDepartment" %>
<%@ page import="com.practice.finance.pojo.IdToApplyType" %>
<%@ page import="com.practice.finance.pojo.IdToApplyReason" %>
<%@ page import="com.practice.finance.pojo.IdToApplyStatus" %>
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

          var name = $("input[name=updateInfoName]");
          var option = $("input[name=option]");
          var id = $("input[name=id]");


          // 选择相应的用户
          $("span[name=select]").click(function () {
              id.val(this.parentNode.firstElementChild.id);
              name.val(this.parentNode.children[1].innerText);
          });


          $("input[name=add]").click(function () {
              if (!name.val()) {
                  alert("输入框不能为空！");
                  return false;
              }
              option.val("0");
          });

          $("input[name=update]").click(function () {
              if (!name.val()) {
                  alert("输入框不能为空！");
                  return false;
              }
              option.val("1");
          });

          $("input[name=query]").click(function () {
              option.val("2");
          });

          $("input[name=cancelQuery]").click(function () {
              option.val("3");
          });

          $("input[name=delete]").click(function () {
              option.val("4");
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
        <span><a href="../../user/staff.jsp">首页</a></span>&nbsp;&nbsp;&nbsp;
        <span><a href="../../../index.jsp">注销</a></span>
    </div>
      <%="information:" + session.getAttribute("information")%>

    <br><br><br>

    <div class="option">
        <form action="/finance/updateIdToName" method="post">
<%--        <form action="/finance/updateIdToName" method="get">--%>
            <table>
                <tr>
                    <td><label for="updateInfoName"><%=session.getAttribute("updateName")%>:</label></td>
                    <td>
                        <input type="text" name="updateInfoName" id="updateInfoName" placeholder="<%=session.getAttribute("updateName")%>的名称">
                        <input type="text" name="option" hidden="hidden">
                        <input type="text" name="id" hidden="hidden" value="-1">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="add" value="添加">
                        <input type="submit" name="update" value="修改">
                        <input type="submit" name="query" value="查询">
                        <input type="submit" name="cancelQuery" value="取消查询">
                        <input type="submit" name="delete" value="删除">
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <div><br><br><br><br></div>

    <div class="departmentInfo">
      <div>
        <span>索引</span>
        <span><%=session.getAttribute("updateName")%></span>
        <span>操作</span>
      </div>

      <%
        if (session.getAttribute("information").equals("3")) {
            IdToDepartment[] departments = (IdToDepartment[]) session.getAttribute("departments");
            for (int i=0; i< departments.length; i++) {
      %>
        <div>
        <%= "<span id=\"" + departments[i].getId() + "\">" + (i+1) + "</span>" %>
        <%= "<span>" + departments[i].getDepartmentName() + "</span>"%>
            <span name="select" style="color: blue; cursor: pointer">选择</span>
        </div>
      <%}} else if(session.getAttribute("information").equals("4")) {
          IdToApplyType[] applyTypes = (IdToApplyType[]) session.getAttribute("applyTypes");
          for (int i=0; i< applyTypes.length; i++) {
      %>
        <div>
        <%= "<span id=\"" + applyTypes[i].getId() + "\">" + (i+1) + "</span>" %>
        <%= "<span>" + applyTypes[i].getApplyTypeName() + "</span>"%>
            <span name="select" style="color: blue; cursor: pointer">选择</span>
        </div>
      <%}} else if(session.getAttribute("information").equals("5")) {
        IdToApplyReason[] applyReasons = (IdToApplyReason[]) session.getAttribute("applyReasons");
        for (int i=0; i< applyReasons.length; i++) {
      %>
      <div>
      <%= "<span id=\"" + applyReasons[i].getId() + "\">" + (i+1) + "</span>" %>
      <%= "<span>" + applyReasons[i].getApplyReasonName() + "</span>"%>
          <span name="select" style="color: blue; cursor: pointer">选择</span>
      </div>
      <%}} else if(session.getAttribute("information").equals("6")) {%>
      <%!
          /**
           * 根据value返回title
           * @param value 申请状态id
           * @return
           */
          public String title(int value) {
              switch (value) {
                  case 8:
                      return "不同意";
                  case 7:
                      return "确认收款";
                  case 6:
                      return "已打款";
                  case 5:
                      return "已同意";
                  case 4:
                      return "已提交(总经理)";
                  case 3:
                      return "已提交(部门经理)";
                  case 2:
                      return "已提交";
                  case 1:
                      return "草稿";
                  default:
                      return Integer.toString(value);
              }
          }
      %>
      <%
        IdToApplyStatus[] applyStatuses = (IdToApplyStatus[]) session.getAttribute("applyStatuses");
        for (int i=0; i< applyStatuses.length; i++) {
      %>
      <div>
      <%= "<span id=\"" + applyStatuses[i].getId() + "\">" + (i+1) + "</span>" %>
      <%= "<span title=" + title(applyStatuses[i].getId()) + " style=\"cursor: pointer\">" + applyStatuses[i].getApplyStatus() + "</span>"%>
          <span name="select" style="color: blue; cursor: pointer">选择</span>
      </div>
      <%}}%>

    </div>
  </div>
</div>

</body>
</html>

