package com.practice.finance.dao.impl;

import com.practice.finance.dao.IdToNameDao;
import com.practice.finance.pojo.IdToApplyReason;
import com.practice.finance.pojo.IdToApplyStatus;
import com.practice.finance.pojo.IdToApplyType;
import com.practice.finance.pojo.IdToDepartment;

import java.util.List;

/**
 * @author: 18040
 * @date: 2023/3/1 12:56
 */
public class IdToNameDaoImpl extends BaseDao implements IdToNameDao {

    @Override
    public List<IdToApplyType> queryAllType(String sort) {
        String sql = "select * from idToApplyType ORDER BY `" + sort + "`";
        return queryForList(IdToApplyType.class, sql);
    }

    @Override
    public List<IdToApplyReason> queryAllReason(String sort) {
        String sql = "select * from idToApplyReason ORDER BY `" + sort + "`";
        return queryForList(IdToApplyReason.class, sql);
    }

    @Override
    public List<IdToApplyStatus> queryAllStatus(String sort) {
        String sql = "select * from idToApplyStatus ORDER BY `" + sort + "`";
        return queryForList(IdToApplyStatus.class, sql);
    }

    @Override
    public List<IdToDepartment> queryAllDepartment(String sort) {
        String sql = "select * from idToDepartment ORDER BY `" + sort + "`";
        return queryForList(IdToDepartment.class, sql);
    }


    @Override
    public int addNewType(String name) {
        String sql = "insert into idToApplyType(`applyTypeName`) value(?)";
        return update(sql, name);
    }

    @Override
    public int addNewReason(String name) {
        String sql = "insert into idToApplyReason(`applyReasonName`) value(?)";
        return update(sql, name);
    }

    @Override
    public int addNewStatus(String name) {
        String sql = "insert into idToApplyStatus(`applyStatus`) value(?)";
        return update(sql, name);
    }

    @Override
    public int addNewDepartment(String name) {
        String sql = "insert into idToDepartment(`departmentName`) value(?)";
        return update(sql, name);
    }

    @Override
    public List<IdToApplyType> queryTypeByName(String name) {
        String sql = "select * from idToApplyType where `applyTypeName` like ?";
        return queryForList(IdToApplyType.class, sql, "%"+name+"%");
    }

    @Override
    public List<IdToApplyReason> queryReasonByName(String name) {
        String sql = "select * from idToApplyReason where `applyReasonName` like ?";
        return queryForList(IdToApplyReason.class, sql, "%"+name+"%");
    }

    @Override
    public List<IdToApplyStatus> queryStatusByName(String name) {
        String sql = "select * from idToApplyStatus where `applyStatus` like ?";
        return queryForList(IdToApplyStatus.class, sql, "%"+name+"%");
    }

    @Override
    public List<IdToDepartment> queryDepartmentTypeByName(String name) {
        String sql = "select * from idToDepartment where `departmentName` like ?";
        return queryForList(IdToDepartment.class, sql, "%"+name+"%");
    }


    @Override
    public int updateTypeByID(int ID, String newName) {
        String sql = "UPDATE idToApplyType set `applyTypeName`=? where `id`=?";
        return update(sql, newName, ID);
    }

    @Override
    public int updateReasonByID(int ID, String newName) {
        String sql = "UPDATE idToApplyReason set `applyReasonName`=? where `id`=?";
        return update(sql, newName, ID);
    }

    @Override
    public int updateStatusByID(int ID, String newName) {
        String sql = "UPDATE idToApplyStatus set `applyStatus`=? where `id`=?";
        return update(sql, newName, ID);
    }

    @Override
    public int updateDepartmentByID(int ID, String newName) {
        String sql = "UPDATE idToDepartment set `departmentName`=? where `id`=?";
        return update(sql, newName, ID);
    }

    @Override
    public int deleteTypeByID(int ID) {
        String sql = "delete from idToApplyType where `id` =?";
        return update(sql, ID);
    }

    @Override
    public int deleteReasonByID(int ID) {
        String sql = "delete from idToApplyReason where `id` =?";
        return update(sql, ID);
    }

    @Override
    public int deleteStatusByID(int ID) {
        String sql = "delete from idToApplyStatus where `id` =?";
        return update(sql, ID);
    }

    @Override
    public int deleteDepartmentByID(int ID) {
        String sql = "delete from idToDepartment where `id` =?";
        return update(sql, ID);
    }
}
