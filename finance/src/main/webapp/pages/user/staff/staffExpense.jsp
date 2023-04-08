<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.practice.finance.pojo.IdToApplyType" %>
<%@ page import="com.practice.finance.pojo.IdToApplyReason" %>
<%@ page import="com.practice.finance.pojo.IdToDepartment" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>财务管理系统</title>
    <base href="http://localhost:8000/finance/pages/user/staff">
    <link type="text/css" rel="stylesheet" href="../../css/style.css" >
    <script type="text/javascript" src="../../script/jquery-3.6.3.js"></script>
    <script type="text/javascript">
        $(function () {
            $("input[name=apply]").click(function () {
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

            $("input[name=back]").click(function () {
                window.location.href = "staff.jsp";
            })
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

        <br><br><br><br>

        <div>
            <form class="expense" action="/finance/applyExpense" method="post">
                <table>
                    <tr>
                        <th colspan="2">报销申请表单</th>
                    </tr>
                    <tr>
                        <td>申请类型：</td>
                        <td>
                            <select name="applyType">
                                <option value=0>-----申请类型-----</option>
                                <%for (IdToApplyType idToApplyType:
                                            (IdToApplyType[]) application.getAttribute("applyTypes")) {%>
                                <%= "<option value=" + idToApplyType.getId() + ">" + idToApplyType.getApplyTypeName() + "</option>"%>
                                <%}%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>申请事由：</td>
                        <td>
                            <select name="applyReason">
                                <option value=0>-----申请事由-----</option>
                                <%for (IdToApplyReason idToApplyReason:
                                        (IdToApplyReason[]) application.getAttribute("applyReasons")) {%>
                                <%= "<option value=" + idToApplyReason.getId() + ">" + idToApplyReason.getApplyReasonName() + "</option>"%>
                                <%}%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>所在部门：</td>
                        <td>
                            <select name="department">
                                <option value=0>-----所在部门-----</option>
                                <%for (IdToDepartment idToDepartment:
                                        (IdToDepartment[]) application.getAttribute("departments")) {
                                    if (idToDepartment.getId() == ((int) session.getAttribute("department"))) {
                                %>
                                    <%= "<option value=" + idToDepartment.getId() + " selected=\"selected\">" + idToDepartment.getDepartmentName() + "</option>"%>
                                <%} else {%>
                                <%= "<option value=" + idToDepartment.getId() + ">" + idToDepartment.getDepartmentName() + "</option>"%>
                                <%}
                                }%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="approveNameInput">审批人：</label></td>
                        <td>
                            <input type="text" id="approveNameInput" name="approveName" placeholder="默认为直属上级" value="<%=session.getAttribute("superior")%>">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="sendDuplicateInput">抄送：</label></td>
                        <td>
                            <input type="text" id="sendDuplicateInput" name="sendDuplicate" placeholder="抄送的上级的用户名">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="expenseMoneyInput">报销金额：</label></td>
                        <td>
                            <input type="text" id="expenseMoneyInput" name="expenseMoney" placeholder="请输入金额">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="describeInput">报销描述：</label></td>
                        <td>
                            <textarea rows="7" cols="50" id="describeInput" name="describe" placeholder="请描述报销缘由"></textarea><br>
                        </td>
                    </tr>
                    <tr>
                        <td>报销凭证：</td>
                        <td>
                            <input type="file" accept="image/*" name="expenseVoucher">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" name="apply" value="提交审批">
                            <input type="submit" name="save" value="保存草稿">
                            <input type="button" name="back" value="返回">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

</body>
</html>