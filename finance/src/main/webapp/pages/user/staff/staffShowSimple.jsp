<%@ page import="com.practice.finance.pojo.ExpenseSimple" %>
<%@ page import="com.practice.finance.pojo.IdToApplyStatus" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>财务管理系统</title>
    <base href="http://localhost:8000/finance/pages/user/staff/">
    <link type="text/css" rel="stylesheet" href="../../../css/style.css" >
    <script type="text/javascript" src="../../../script/jquery-3.6.3.js"></script>
    <script type="text/javascript">
        $(function () {

            $("img[title='查看']").click(function () {
                // 获取该条记录对应的id索引
                this.parentNode.children[0].value = this.parentNode.parentNode.parentNode.firstElementChild.attributes[0].nodeValue
                this.parentNode.children[1].value = "2"
                this.parentNode.lastElementChild.click()
            });

            $("img[title='修改']").click(function () {
                // 获取该条记录对应的id索引
                this.parentNode.children[0].value = this.parentNode.parentNode.parentNode.firstElementChild.attributes[0].nodeValue
                this.parentNode.children[1].value = "1"
                this.parentNode.lastElementChild.click()
            });

            $("img[title='删除']").click(function () {
                // 获取该条记录对应的id索引
                if (confirm("是否删除索引为" + this.parentNode.parentNode.parentNode.firstElementChild.innerText + "的申请报销记录吗？")) {
                    this.parentNode.children[0].value = this.parentNode.parentNode.parentNode.firstElementChild.attributes[0].nodeValue
                    this.parentNode.children[1].value = "0"
                    if (this.id=="delete0") {
                        this.parentNode.children[2].value = "0"
                    } else if (this.id=="delete1") {
                        this.parentNode.children[2].value = "1"
                    }

                    this.parentNode.lastElementChild.click();
                } else {
                    return false;
                }
            });


            $("img[title='确认']").click(function () {
                // 获取该条记录对应的id索引
                // alert(this.parentNode.parentNode.parentNode.firstElementChild.attributes[0].nodeValue)
                if (confirm("确认收到索引为" + this.parentNode.parentNode.parentNode.firstElementChild.innerText + "申请报销的打款吗？")) {
                    this.parentNode.children[0].value = this.parentNode.parentNode.parentNode.firstElementChild.attributes[0].nodeValue
                    this.parentNode.children[1].value = "3"
                    this.parentNode.children[2].value = "1"
                    this.parentNode.lastElementChild.click();
                } else {
                    return false;
                }
            });

            $("img[title='审批']").click(function () {
                // 获取该条记录对应的id索引
                this.parentNode.children[0].value = this.parentNode.parentNode.parentNode.firstElementChild.attributes[0].nodeValue;
                this.parentNode.children[1].value = "4";
                this.parentNode.children[2].value = "7";
                this.parentNode.lastElementChild.click();
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
            <span><a href="../staff.jsp">首页</a></span>&nbsp;&nbsp;&nbsp;
            <span><a href=/finance/logout>注销</a></span>
        </div>


        <br><br><br><br><br><br>


        <div class="simple">
            <div>
                <span>索引</span>
                <span>状态</span>
                <span>时间</span>
                <span>审批人</span>
                <span>抄送</span>
                <span>操作</span>
            </div>


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
                    ExpenseSimple[] expenseSimpleSelectedArray = (ExpenseSimple[]) session.getAttribute("expenseSimpleSelectedArray");
                    for (int i=0; i< expenseSimpleSelectedArray.length; i++) {
                %>
            <div>
                <%
                    String applyStatusName = "";
                    for (IdToApplyStatus idToApplyStatus:
                        (IdToApplyStatus[]) application.getAttribute("applyStatuses")) {
                        if (idToApplyStatus.getId() == expenseSimpleSelectedArray[i].getApplyStatus()) {
                            applyStatusName = idToApplyStatus.getApplyStatus();
                        }
                    }
                %>

                <%= "<span name=\""%><%=expenseSimpleSelectedArray[i].getId()%><%="\">" + (i+1) + "</span>" %>
                <%= "<span title=" + title(expenseSimpleSelectedArray[i].getApplyStatus()) + " style=\"cursor: pointer\">" + applyStatusName + "</span>" %>
                <%= "<span>" + expenseSimpleSelectedArray[i].getApplyTime().toString().replace("T", ",") + "</span>" %>
                <%= "<span>" + expenseSimpleSelectedArray[i].getApproveName() + "</span>" %>
                <%= "<span>" + expenseSimpleSelectedArray[i].getSendDuplicate() + "</span>" %>


                <span>
                    <%="<form action=\"/finance/getExpenseInfo\" method=\"post\">"%>
                        <%
                            if (session.getAttribute("information").equals("0")) {
                        %>
                        <input type="text" hidden="hidden" name="id">
                        <input type="text" hidden="hidden" name="expenseStatus">
                        <input type="text" hidden="hidden" name="select">
                        <img src="../../../imgs/icox1.gif" title="查看" style="cursor: pointer">
                        <img src="../../../imgs/icox2.gif" title="修改" style="cursor: pointer">
                        <img src="../../../imgs/icox3.gif" title="删除" id="delete0" style="cursor: pointer">
                        <input type="submit" hidden="hidden">
                        <%} else if (session.getAttribute("information").equals("1")){%>
                        <input type="text" hidden="hidden" name="id">
                        <input type="text" hidden="hidden" name="expenseStatus">
                        <input type="text" hidden="hidden" name="select">
                        <img src="../../../imgs/icox1.gif" title="查看" style="cursor: pointer">
                        <img src="../../../imgs/icox2.gif" title="确认" style="cursor: pointer">
                        <img src="../../../imgs/icox3.gif" title="删除" id="delete1" style="cursor: pointer">
                        <input type="submit" hidden="hidden">
                        <%} else if (session.getAttribute("information").equals("7")){%>
                        <input type="text" hidden="hidden" name="id">
                        <input type="text" hidden="hidden" name="expenseStatus">
                        <input type="text" hidden="hidden" name="select">
                        <img src="../../../imgs/icox1.gif" title="审批" style="cursor: pointer">
                        <input type="submit" hidden="hidden">
                        <%}%>
                    <%="</form>"%>

                </span>
            </div>
                <%}%>

        </div>
    </div>
</div>

</body>
</html>