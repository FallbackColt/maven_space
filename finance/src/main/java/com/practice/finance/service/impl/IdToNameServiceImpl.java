package com.practice.finance.service.impl;

import com.practice.finance.dao.IdToNameDao;
import com.practice.finance.dao.impl.IdToNameDaoImpl;
import com.practice.finance.pojo.IdToApplyReason;
import com.practice.finance.pojo.IdToApplyStatus;
import com.practice.finance.pojo.IdToApplyType;
import com.practice.finance.pojo.IdToDepartment;
import com.practice.finance.service.IdToNameService;

import java.util.List;

/**
 * @author: 18040
 * @date: 2023/3/1 13:05
 */
public class IdToNameServiceImpl implements IdToNameService {

    private IdToNameDao idToNameDao = new IdToNameDaoImpl();

    @Override
    public List<IdToApplyType> queryAllType(String sort) {
        return idToNameDao.queryAllType(sort);
    }

    @Override
    public List<IdToApplyReason> queryAllReason(String sort) {
        return idToNameDao.queryAllReason(sort);
    }

    @Override
    public List<IdToApplyStatus> queryAllStatus(String sort) {
        return idToNameDao.queryAllStatus(sort);
    }

    @Override
    public List<IdToDepartment> queryAllDepartment(String sort) {
        return idToNameDao.queryAllDepartment(sort);
    }

    @Override
    public int addNewType(String name) {
        return idToNameDao.addNewType(name);
    }

    @Override
    public int addNewReason(String name) {
        return idToNameDao.addNewReason(name);
    }

    @Override
    public int addNewStatus(String name) {
        return idToNameDao.addNewStatus(name);
    }

    @Override
    public int addNewDepartment(String name) {
        return idToNameDao.addNewDepartment(name);
    }

    @Override
    public int updateTypeByID(int ID, String newName) {
        return idToNameDao.updateTypeByID(ID, newName);
    }

    @Override
    public int updateReasonByID(int ID, String newName) {
        return idToNameDao.updateReasonByID(ID, newName);
    }

    @Override
    public int updateStatusByID(int ID, String newName) {
        return idToNameDao.updateStatusByID(ID, newName);
    }

    @Override
    public int updateDepartmentByID(int ID, String newName) {
        return idToNameDao.updateDepartmentByID(ID, newName);
    }

    @Override
    public List<IdToApplyType> queryTypeByName(String name) {
        return idToNameDao.queryTypeByName(name);
    }

    @Override
    public List<IdToApplyReason> queryReasonByName(String name) {
        return idToNameDao.queryReasonByName(name);
    }

    @Override
    public List<IdToApplyStatus> queryStatusByName(String name) {
        return idToNameDao.queryStatusByName(name);
    }

    @Override
    public List<IdToDepartment> queryDepartmentByName(String name) {
        return idToNameDao.queryDepartmentTypeByName(name);
    }

    @Override
    public int deleteTypeByID(int ID) {
        return idToNameDao.deleteTypeByID(ID);
    }

    @Override
    public int deleteReasonByID(int ID) {
        return idToNameDao.deleteReasonByID(ID);
    }

    @Override
    public int deleteStatusByID(int ID) {
        return idToNameDao.deleteStatusByID(ID);
    }

    @Override
    public int deleteDepartmentByID(int ID) {
        return idToNameDao.deleteDepartmentByID(ID);
    }

}
