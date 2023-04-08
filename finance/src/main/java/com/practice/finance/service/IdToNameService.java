package com.practice.finance.service;

import com.practice.finance.dao.IdToNameDao;
import com.practice.finance.dao.impl.IdToNameDaoImpl;
import com.practice.finance.pojo.IdToApplyReason;
import com.practice.finance.pojo.IdToApplyStatus;
import com.practice.finance.pojo.IdToApplyType;
import com.practice.finance.pojo.IdToDepartment;

import java.util.List;

/**
 * @author: 18040
 * @date: 2023/3/1 13:05
 */
public interface IdToNameService {

    /**
     * 查询所有的类型
     * @param sort 排序的字段
     * @return
     */
    public List<IdToApplyType> queryAllType(String sort);

    /**
     * 查询所有的事由
     * @param sort 排序的字段
     * @return
     */
    public List<IdToApplyReason> queryAllReason(String sort);

    /**
     * 查询所有的状态
     * @param sort 排序的字段
     * @return
     */
    public List<IdToApplyStatus> queryAllStatus(String sort);

    /**
     * 查询所有的部门
     * @param sort 排序的字段
     * @return
     */
    public List<IdToDepartment> queryAllDepartment(String sort);


    /**
     * 添加新的申请类型
     * @param name 名字
     * @return
     */
    public int addNewType(String name);

    /**
     * 添加新的申请事由
     * @param name 名字
     * @return
     */
    public int addNewReason(String name);

    /**
     * 添加新的申请状态
     * @param name 名字
     * @return
     */
    public int addNewStatus(String name);

    /**
     * 添加新的部门
     * @param name 名字
     * @return
     */
    public int addNewDepartment(String name);


    /**
     * 更新申请类型的名称
     * @param ID 索引
     * @param newName 新的名字
     * @return
     */
    public int updateTypeByID(int ID, String newName);

    /**
     * 更新申请事由的名称
     * @param ID 索引
     * @param newName 新的名字
     * @return
     */
    public int updateReasonByID(int ID, String newName);

    /**
     * 更新申请状态的名称
     * @param ID 索引
     * @param newName 新的名字
     * @return
     */
    public int updateStatusByID(int ID, String newName);

    /**
     * 更新部门的名称
     * @param ID 索引
     * @param newName 新的名字
     * @return
     */
    public int updateDepartmentByID(int ID, String newName);


    /**
     * 模糊查询申请类型
     * @param name 名字
     * @return
     */
    public List<IdToApplyType> queryTypeByName(String name);

    /**
     * 模糊查询申请事由
     * @param name 名字
     * @return
     */
    public List<IdToApplyReason> queryReasonByName(String name);

    /**
     * 模糊查询申请状态
     * @param name 名字
     * @return
     */
    public List<IdToApplyStatus> queryStatusByName(String name);

    /**
     * 模糊查询部门名称
     * @param name 名字
     * @return
     */
    public List<IdToDepartment> queryDepartmentByName(String name);


    /**
     * 通过ID删除对应申请类型
     * @param ID 索引
     * @return
     */
    public int deleteTypeByID(int ID);

    /**
     * 通过ID删除对应申请事由
     * @param ID 索引
     * @return
     */
    public int deleteReasonByID(int ID);

    /**
     * 通过ID删除对应申请状态
     * @param ID 索引
     * @return
     */
    public int deleteStatusByID(int ID);

    /**
     * 通过ID删除对应部门
     * @param ID 索引
     * @return
     */
    public int deleteDepartmentByID(int ID);


}
