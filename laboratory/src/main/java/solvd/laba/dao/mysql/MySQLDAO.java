package solvd.laba.dao.mysql;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class MySQLDAO {
    private static BasicDataSource dataSource = null;
    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/laboratorydb?useSSL=false");
        dataSource.setUsername("Ramiro");
        dataSource.setPassword("xqnncpcplpm337");

        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxTotal(12);
    }

    public static Connection getConnection() throws SQLException {
       return dataSource.getConnection();
    }




}
