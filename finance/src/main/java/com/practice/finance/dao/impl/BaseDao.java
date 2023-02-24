package com.practice.finance.dao.impl;

import com.practice.finance.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: 18040
 * @date: 2023/2/22 16:00
 */
public abstract class BaseDao {

//    使用DbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 用来执行Insert、Update、Delete语句
     * @param sql sql语句
     * @param args 传入sql语句对应的参数值
     * @return -1，执行失败，其他表示影响的行数
     */
    public int update(String sql, Object ... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(connection);
        }
//        return -1;
    }

    /**
     * 查询返回一条JavaBean的sql语句
     * @param type 返回的对象类型
     * @param sql 执行的sql语句
     * @param args 传入sql语句对应的参数值
     * @return 返回的类型的泛型
     */
    public <T> T queryForOne(Class<T> type, String sql, Object ... args) {

        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(connection);
        }
//        return null;
    }

    /**
     * 查询返回多个JavaBean的sql语句
     * @param type 返回的对象类型
     * @param sql 执行的sql语句
     * @param args 传入sql语句对应的参数值
     * @return
     * @param <T> 返回的类型的泛型
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object ... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(connection);
        }
//        return null;
    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql 执行的sql语句
     * @param args 传入sql语句对应的参数值
     * @return
     */
    public Object queryForSingleValue(String sql, Object ... args) {

        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(connection);
        }
//        return null;

    }

}
