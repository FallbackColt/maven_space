package com.book.test;

import com.book.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author: 18040
 * @date: 2023/2/20 18:17
 */
public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils() {
        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }
    }

}
