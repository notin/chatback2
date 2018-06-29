package com.chatback.broker;


import com.chatback.pojos.converation.Message;

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
            if (resultSet.next()) {
                String message = resultSet.getString(1);
                m = Message.builder().build();
                m.setText(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return m;

    }


    public void setMessages(String gui1, String gui2, Message message)
    {
        Message m = null;
        // This SQL statement produces all table
        // names and column names in the H2 schema
        String id = " select count(*) from messages;";
        int index = getID(id);

        String sql = "INSERT INTO messages VALUES ('"+index+"','"+gui1+"','"+gui2+"', '"+message.getText()+"')";

        ResultSet resultSet = getResult(sql);


    }

    private int getID(String sql) {
        ResultSet resultSet = null;
        int index =-1;
        try {
            resultSet = connectToDatabase(sql);
            if (resultSet.next()) {
                index = resultSet.getInt(1);
//                Logger.getAnonymousLogger().info("Status : " + String.valueOf(resultSet.rowInserted()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return index;
    }
    private ResultSet getResult(String sql) {
        ResultSet resultSet = null;
        try {
            resultSet = connectToDatabase(sql);
            if (resultSet.next()) {
                Logger.getAnonymousLogger().info("Status : " + String.valueOf(resultSet.rowInserted()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
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
