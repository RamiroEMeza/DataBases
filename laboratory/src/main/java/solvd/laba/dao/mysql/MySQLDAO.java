package solvd.laba.dao.mysql;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public abstract class MySQLDAO {
    private static BasicDataSource dataSource = null;

    static {

        Properties properties = new Properties();
        try (InputStream inputStream = Files.newInputStream(Paths.get("./src/main/resources/workbench/db.properties"))) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(properties.getProperty("driver"));
        dataSource.setUrl(properties.getProperty("url2"));
        dataSource.setUsername(properties.getProperty("username2"));
        dataSource.setPassword(properties.getProperty("password2"));

        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxTotal(12);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


}
