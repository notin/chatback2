package com.chatback.broker;


import com.chatback.pojos.converation.Message;
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
        String sql = "select table_name, column_name " +
                "from information_schema.columns " +
                "order by " +
                "table_catalog, " +
                "table_schema, " +
                "table_name, " +
                "ordinal_position";

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

        MariaDbDataSource mariaDbDataSource = new MariaDbDataSource("jdbc:mariadb://localhost:3307/db");
        mariaDbDataSource.setUserName("root");
        mariaDbDataSource.setPassword("installeSQL9");
        Connection c = mariaDbDataSource.getConnection();
        Statement statement = c.createStatement();

        set = statement.executeQuery(sql);

        return set;
    }
}
