package com.practice.finance.web;

import com.practice.finance.pojo.*;
import com.practice.finance.service.IdToNameService;
import com.practice.finance.service.impl.IdToNameServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author: 18040
 * @date: 2023/3/12 15:35
 */
public class UpdateIdToName extends HttpServlet {

    private IdToNameService idToNameService = new IdToNameServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        String option = request.getParameter("option");
        String updateInfoName = request.getParameter("updateInfoName");
        int information = Integer.parseInt((String) session.getAttribute("information"));


        switch (information) {
//            case 2:
//                // 人员管理
//                break;
            case 3:
                // 部门管理
                switch (option) {
                    case "0":
                        idToNameService.addNewDepartment(updateInfoName);
                        session.setAttribute("departments", idToNameService.queryAllDepartment("id").toArray(new IdToDepartment[0]));
                        break;
                    case "1":
                        idToNameService.updateDepartmentByID(id, updateInfoName);
                        session.setAttribute("departments", idToNameService.queryAllDepartment("id").toArray(new IdToDepartment[0]));
                        break;
                    case "2":
                        session.setAttribute("departments", idToNameService.queryDepartmentByName(updateInfoName).toArray(new IdToDepartment[0]));
                        break;
                    case "3":
                        session.setAttribute("departments", idToNameService.queryAllDepartment("id").toArray(new IdToDepartment[0]));
                        break;
                    case "4":
                        idToNameService.deleteDepartmentByID(id);
                        session.setAttribute("departments", idToNameService.queryAllDepartment("id").toArray(new IdToDepartment[0]));
                        break;
                }
                break;
            case 4:
                // 申请类型管理
                switch (option) {
                    case "0":
                        idToNameService.addNewType(updateInfoName);
                        session.setAttribute("applyTypes", idToNameService.queryAllType("id").toArray(new IdToApplyType[0]));
                        break;
                    case "1":
                        idToNameService.updateTypeByID(id, updateInfoName);
                        session.setAttribute("applyTypes", idToNameService.queryAllType("id").toArray(new IdToApplyType[0]));
                        break;
                    case "2":
                        session.setAttribute("applyTypes", idToNameService.queryTypeByName(updateInfoName).toArray(new IdToApplyType[0]));
                        break;
                    case "3":
                        session.setAttribute("applyTypes", idToNameService.queryAllType("id").toArray(new IdToApplyType[0]));
                        break;
                    case "4":
                        idToNameService.deleteTypeByID(id);
                        session.setAttribute("applyTypes", idToNameService.queryAllType("id").toArray(new IdToApplyType[0]));
                        break;
                }
                break;
            case 5:
                // 申请事由管理
                switch (option) {
                    case "0":
                        idToNameService.addNewReason(updateInfoName);
                        session.setAttribute("applyReasons", idToNameService.queryAllReason("id").toArray(new IdToApplyReason[0]));
                        break;
                    case "1":
                        idToNameService.updateReasonByID(id, updateInfoName);
                        session.setAttribute("applyReasons", idToNameService.queryAllReason("id").toArray(new IdToApplyReason[0]));
                        break;
                    case "2":
                        session.setAttribute("applyReasons", idToNameService.queryReasonByName(updateInfoName).toArray(new IdToApplyReason[0]));
                        break;
                    case "3":
                        session.setAttribute("applyReasons", idToNameService.queryAllReason("id").toArray(new IdToApplyReason[0]));
                        break;
                    case "4":
                        idToNameService.deleteReasonByID(id);
                        session.setAttribute("applyReasons", idToNameService.queryAllReason("id").toArray(new IdToApplyReason[0]));
                        break;
                }
                break;
            case 6:
                // 申请状态管理
                switch (option) {
                    case "0":
                        idToNameService.addNewStatus(updateInfoName);
                        session.setAttribute("applyStatuses", idToNameService.queryAllStatus("id").toArray(new IdToApplyStatus[0]));
                        break;
                    case "1":
                        idToNameService.updateStatusByID(id, updateInfoName);
                        session.setAttribute("applyStatuses", idToNameService.queryAllStatus("id").toArray(new IdToApplyStatus[0]));
                        break;
                    case "2":
                        session.setAttribute("applyStatuses", idToNameService.queryStatusByName(updateInfoName).toArray(new IdToApplyStatus[0]));
                        break;
                    case "3":
                        session.setAttribute("applyStatuses", idToNameService.queryAllStatus("id").toArray(new IdToApplyStatus[0]));
                        break;
                    case "4":
                        idToNameService.deleteStatusByID(id);
                        session.setAttribute("applyStatuses", idToNameService.queryAllStatus("id").toArray(new IdToApplyStatus[0]));
                        break;
                }
                break;
        }
//        resp.sendRedirect("/finance/setSessionInformation");
        response.sendRedirect("/finance/pages/user/notstaff/updateInfo.jsp");
    }
}
