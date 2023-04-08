package com.practice.finance.web;

import com.practice.finance.pojo.IdToApplyReason;
import com.practice.finance.pojo.IdToApplyStatus;
import com.practice.finance.pojo.IdToApplyType;
import com.practice.finance.pojo.IdToDepartment;
import com.practice.finance.service.IdToNameService;
import com.practice.finance.service.impl.IdToNameServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

public class InitService extends HttpServlet {


    private IdToNameService idToNameService = new IdToNameServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init(getServletConfig());
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        ServletContext context = config.getServletContext();

        // 查找四个ID映射表
        List<IdToApplyType> applyTypes = idToNameService.queryAllType("id");
        List<IdToApplyReason> applyReasons = idToNameService.queryAllReason("id");
        List<IdToApplyStatus> applyStatuses = idToNameService.queryAllStatus("id");
        List<IdToDepartment> departments = idToNameService.queryAllDepartment("id");

        IdToApplyType[] idToApplyTypes = applyTypes.toArray(new IdToApplyType[0]);
        IdToApplyReason[] idToApplyReasons = applyReasons.toArray(new IdToApplyReason[0]);
        IdToApplyStatus[] idToApplyStatuses = applyStatuses.toArray(new IdToApplyStatus[0]);
        IdToDepartment[] idToDepartments = departments.toArray(new IdToDepartment[0]);

        context.setAttribute("applyTypes", idToApplyTypes);
        context.setAttribute("applyReasons", idToApplyReasons);
        context.setAttribute("applyStatuses", idToApplyStatuses);
        context.setAttribute("departments", idToDepartments);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
