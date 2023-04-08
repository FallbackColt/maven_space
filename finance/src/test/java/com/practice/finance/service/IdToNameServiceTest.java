package com.practice.finance.service;

import com.practice.finance.pojo.IdToApplyReason;
import com.practice.finance.pojo.IdToApplyStatus;
import com.practice.finance.pojo.IdToApplyType;
import com.practice.finance.pojo.IdToDepartment;
import com.practice.finance.service.impl.IdToNameServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class IdToNameServiceTest {

    IdToNameService idToNameService = new IdToNameServiceImpl();

    @Test
    public void queryAllType() {
        List<IdToApplyType> applyTypes = idToNameService.queryAllType("id");
        System.out.println(applyTypes);
    }

    @Test
    public void queryAllReason() {
        List<IdToApplyReason> applyReasons = idToNameService.queryAllReason("id");
        System.out.println(applyReasons);
    }

    @Test
    public void queryAllStatus() {
        List<IdToApplyStatus> statuses = idToNameService.queryAllStatus("id");
        System.out.println(statuses);
    }

    @Test
    public void queryAllDepartment() {
        List<IdToDepartment> departments = idToNameService.queryAllDepartment("id");
        System.out.println(departments);
    }
}