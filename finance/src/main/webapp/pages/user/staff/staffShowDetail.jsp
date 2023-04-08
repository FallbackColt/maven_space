<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.practice.finance.pojo.*" %>

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
            $("input[name=agree]").click(function () {
                var text = prompt("请输入同意的理由：", "")
                if (text || text == "") {
                    this.parentNode.firstElementChild.value = "agree"
                    this.parentNode.children[1].value = text
                } else {
                    return;
                }
            });

            $("input[name=notAgree]").click(function () {
                var text = prompt("请输入同意的理由：", "")
                if (text || text == "") {
                    this.parentNode.firstElementChild.value = "notAgree"
                    this.parentNode.children[1].value = text
                } else {
                    return;
                }
            });

            $("input[name=applySave]").click(function () {
                if($("select[name=applyType]")[0].options[0].selected) {
                    alert("请选择申请类型");
                    return false;
                }
                if($("select[name=applyReason]")[0].options[0].selected) {
                    alert("请选择申请事由");
                    return false;
                }
                if($("select[name=department]")[0].options[0].selected) {
                    alert("请选择所在部门");
                    return false;
                }
                if(!$("#approveNameInput")[0].value) {
                    alert("请填写审批人");
                    return false;
                }
                if(!$("#sendDuplicateInput")[0].value) {
                    alert("请填写抄送人");
                    return false;
                }
                if(!$("#expenseMoneyInput")[0].value) {
                    alert("请填写报销金额");
                    return false;
                }
                if(!$("#describeInput")[0].value) {
                    alert("请填写报销描述");
                    return false;
                }
            });

            $("input[name=saveAgain]").click(function () {

            });



            $("input[name=back]").click(function () {
                window.location.href ="staffShowSimple.jsp";
            });
        });
    </script>
</head>
<body>
<div class="mainBody">



    <%

        String option = " disabled=\"disabled\" ";
        int status = (int) session.getAttribute("checkExpenseStatus");

        if (status==1) {
            option = "";
        }

        ExpenseDetail expenseDetail = (ExpenseDetail) session.getAttribute("expenseDetail");
        ExpenseSimple expenseSimple = (ExpenseSimple) session.getAttribute("expenseSimple");
    %>
    <div class="logined">
        <div>
            <span name="placeholder"></span>
            <span>你好：<%=session.getAttribute("username")%>，</span>
            <span><a href="../staff.jsp">首页</a></span>&nbsp;&nbsp;&nbsp;
            <span><a href="/finance/logout">注销</a></span>
        </div>

        <br><br><br><br>

        <div>
            <form class="expense" action="/finance/applyExpense" method="post">
<%--            <form class="expense" action="/finance/applyExpense" method="get">--%>
                <table>
                    <tr>
                        <th colspan="2">报销申                                                                           请表单</th>
                    </tr>
                    <tr>
                        <td>申请类型：</td>
                        <td>
                            <select name="applyType">
                                <option value=0 disabled="<%=option%>" selected="selected">-----申请类型-----</option>
                                <%for (IdToApplyType idToApplyType: (IdToApplyType[]) application.getAttribute("applyTypes")) {
                                    if (idToApplyType.getId()==expenseDetail.getApplyType()) {
                                %>
                                <%="<option value=" + idToApplyType.getId() + " selected=\"selected\">" + idToApplyType.getApplyTypeName() + "</option>"%>
                                <%} else {%>
                                <%= "<option value=" + idToApplyType.getId() + option + ">" + idToApplyType.getApplyTypeName() + "</option>"%>
                                <%}
                                }%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>申请事由：</td>
                        <td>
                            <select name="applyReason">
                                <option value=0 disabled="<%=option%>" selected="selected">-----申请事由-----</option>
                                <%for (IdToApplyReason idToApplyReason: (IdToApplyReason[]) application.getAttribute("applyReasons")) {
                                    if (idToApplyReason.getId()==expenseDetail.getApplyReason()) {
                                %>
                                <%= "<option value=" + idToApplyReason.getId() + " selected=\"selected\">" + idToApplyReason.getApplyReasonName() + "</option>"%>
                                <%} else {%>
                                <%= "<option value=" + idToApplyReason.getId() + option + ">" + idToApplyReason.getApplyReasonName() + "</option>"%>
                                <%}
                                }%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>所在部门：</td>
                        <td>
                            <select name="department">
                                <option value=0 disabled="<%=option%>" selected="selected">-----所在部门-----</option>
                                <%for (IdToDepartment idToDepartment:
                                        (IdToDepartment[]) application.getAttribute("departments")) {
                                    if (idToDepartment.getId() == expenseDetail.getDepartment()) {
                                %>
                                <%= "<option value=" + idToDepartment.getId() + " selected=\"selected\"" + option + ">" + idToDepartment.getDepartmentName() + "</option>"%>
                                <%} else {%>
                                <%= "<option value=" + idToDepartment.getId() + option + ">" + idToDepartment.getDepartmentName() + "</option>"%>
                                <%}
                                }%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="approveNameInput">审批人：</label></td>
                        <td>
                            <input type="text" id="approveNameInput" name="approveName" <%=option%> placeholder="默认为直属上级" value="<%=expenseSimple.getApproveName()%>">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="sendDuplicateInput">抄送：</label></td>
                        <td>
                            <input type="text" id="sendDuplicateInput" name="sendDuplicate" <%=option%> placeholder="抄送的上级的用户名" value="<%=expenseSimple.getSendDuplicate()%>">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="expenseMoneyInput">报销金额：</label></td>
                        <td>
                            <input type="text" id="expenseMoneyInput" name="expenseMoney" <%=option%> placeholder="请输入金额" value="<%=expenseDetail.getExpenseMoney()%>">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="describeInput">报销描述：</label></td>
                        <td>
                            <textarea rows="7" cols="50" id="describeInput" name="describe" <%=option%> placeholder="请描述报销缘由"><%=expenseDetail.getExpenseText()%></textarea><br>
                        </td>
                    </tr>
                    <tr>
                        <td>报销凭证：</td>
                        <td>
                            <input type="file" accept="image/*" name="expenseVoucher"> <br>
                            <img src="../../../imgs/test.png" alt="图片丢失" <%=option%> style="font-size: 80%">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <%
                                if (session.getAttribute("information").equals("7")) {
                            %>
                            <input type="text" name="agreement" hidden="hidden">
                            <input type="text" name="text" hidden="hidden">
                            <input type="submit" name="agree" value="同意">
                            <input type="submit" name="notAgree" value="不同意">
                            <input type="button" name="back" value="返回">
                            <%} else {%>
                            <input type="submit" name="applySave" value="提交">
                            <input type="submit" name="saveAgain" value="保存">
                            <input type="button" name="back" value="返回">
                            <%}%>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>


</body>
</html>