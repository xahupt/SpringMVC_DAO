package com.percy.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author percy
 * @create 2019-02-15  下午7:43
 * @descreption:
 **/
public class DataBaseConnection {
    private final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DBURL = "jdbc:mysql:///supermarket?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Hongkong";
    private final String DBUSER = "root";
    private final String DBPASSWORD = "china0420";
    private  Connection connection;


    public DataBaseConnection() {
        try {
            Class.forName(DBDRIVER);
            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close(){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
