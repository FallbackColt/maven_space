<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>财务管理系统</title>
    <base href="http://localhost:8000/finance/pages/user/">
    <link type="text/css" rel="stylesheet" href="../../css/style.css" >
    <script type="text/javascript" src="../../script/jquery-3.6.3.js"></script>
    <script type="text/javascript">

        $(function (){
            var menu1 = $(".menu1 div:nth-child(7)");
            var menu2 = $(".menu1 div:nth-child(7) ul");

            menu1.mouseenter(function () {
                menu2.css("display", "flex");
            });

            menu1.mouseleave(function () {
                menu2.css("display", "none");
            });
            var select = $("input[name=select]");
            $("p").click(function (){
                if (this.innerText === "已发起") {
                    select.val("0")
                    $("input[type=submit]").click()
                } else if (this.innerText === "填写报销单") {
                    window.location.href = "staff/staffExpense.jsp";
                } else if (this.innerText === "报销确认") {
                    select.val("1")
                    $("input[type=submit]").click()
                } else if (this.innerText === "人员管理") {
                    select.val("2")
                    $("input[type=submit]").click()
                } else if (this.innerText === "部门管理") {
                    select.val("3")
                    $("input[type=submit]").click()
                } else if (this.innerText === "审批管理") {
                    select.val("7")
                    $("input[type=submit]").click()
                } else if (this.innerText === "报销统计") {
                    // window.location.href = "staff/staffExpense.jsp";
                }
            });


            $("li").click(function (){
                if (this.innerText === "申请类型管理") {
                    select.val("4")
                    $("input[type=submit]").click()
                } else if (this.innerText === "申请事由管理") {
                    select.val("5")
                    $("input[type=submit]").click()
                } else if (this.innerText === "申请状态管理") {
                    select.val("6")
                    $("input[type=submit]").click()
                }
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
            <span><a href="staff.jsp">首页</a></span>&nbsp;&nbsp;&nbsp;
            <span><a href="/finance/logout">注销</a></span>
        </div>

        <br><br><br><br>

        <%
            String display = "display: none";
            int status = (int) session.getAttribute("department");

            if (status!=4) {
                display = "";
            }
        %>

        <div>
            <div class="menu1">
                <div>
                    <p>已发起</p>
                </div>
                <div>
                    <p>填写报销单</p>
                </div>
                <div>
                    <p>报销确认</p>
                </div>
                <div style="<%=display%>">
                    <p>人员管理</p>
                </div>
                <div style="<%=display%>">
                    <p>部门管理</p>
                </div>
                <div style="<%=display%>">
                    <p>审批管理</p>
                </div>
                <div style="<%=display%>">
                    <p>报销申请管理</p>
                    <ul class="menu2">
                        <li>申请类型管理</li>
                        <li>申请事由管理</li>
                        <li>申请状态管理</li>
                    </ul>
                </div>
                <div style="<%=display%>">
                    <p>报销统计</p>
                </div>
                <form action="/finance/setSessionInformation" method="post">
                    <input type="text" hidden="hidden" name="select" value="">
                    <input type="submit" hidden="hidden">
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>