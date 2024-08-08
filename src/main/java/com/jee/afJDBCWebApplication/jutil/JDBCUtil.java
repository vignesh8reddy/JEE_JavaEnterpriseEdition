package com.jee.afJDBCWebApplication.jutil;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtil {

    private JDBCUtil() {

    }

    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException, IOException {
        /* Instead of making physical connection like below code, use hikaricp to make logical connection
        FileInputStream fisObj = new FileInputStream("src\\JDBCStandaloneApplication\\properties\\db.properties");
        Properties properties = new Properties();
        properties.load(fisObj);

        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        Connection conObj = DriverManager.getConnection(url,user,password);
        return conObj;
         */

        //using hikaricp configuration for connection pooling
        HikariConfig configObj = new HikariConfig("C:\\Users\\math\\Documents\\JEE_JavaEnterpriseEdition\\src\\main\\java\\com\\jee\\afJDBCWebApplication\\properties\\db.properties");
        HikariDataSource dataSource = new HikariDataSource(configObj);
        Connection conObj = dataSource.getConnection();
        return conObj;
    }

}
