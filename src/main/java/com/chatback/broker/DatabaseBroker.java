package com.chatback.broker;


import com.chatback.pojos.converation.Message;
import org.mariadb.jdbc.MariaDbConnection;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.util.logging.Logger;

import static java.sql.DriverManager.getConnection;
import static java.sql.DriverManager.registerDriver;

public class DatabaseBroker
{
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";

    public Message getMessages(int id)
    {
        Message m = null;
        // This SQL statement produces all table
        // names and column names in the H2 schema
        String sql = "select conversation from messages where id = "+id;

        ResultSet resultSet = null;
        try {
            resultSet = connectToDatabase(sql);
             m = (Message)resultSet.getObject(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    return m;

    }

    private ResultSet connectToDatabase(String sql) throws Exception
    {
        ResultSet set = null;

//        MariaDbConnection connection = new MariaDbConnection();
//        MariaDbDataSource mariaDbDataSource = new MariaDbDataSource("localhost");
//        mariaDbDataSource.setPort(3307);
//        mariaDbDataSource.setUserName("root");
//        mariaDbDataSource.setPassword("installedSQL9");
//        mariaDbDataSource.setDatabaseName("test2");
//        Connection c = mariaDbDataSource.getConnection();
        Class.forName("org.mariadb.jdbc.Driver");

        Connection c = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3307/test2", "root", "installedSQL9");
        Statement statement = c.createStatement();

        set = statement.executeQuery(sql);

        return set;
    }
//     insert into messages values (1,'test1','test2', 'this is the first');
}
