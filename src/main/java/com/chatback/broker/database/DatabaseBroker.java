package com.chatback.broker.database;


import com.chatback.pojos.prompt.Prompts;
import com.chatback.pojos.user.User;
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

    public Prompts getPropmpts()
    {
        Prompts m = null;
        // This SQL statement produces all table
        // names and column names in the H2 schema

        String sql = "select conversation from prompt where id = ";

        ResultSet resultSet = null;
        try {
            resultSet = connectToDatabase(sql);
            if (resultSet.next()) {
                //TODO: make table and connect
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;

    }

    public void createUserRecord(User user)
    {
        // This SQL statement produces all table
        // names and column names in the H2 schema
        String id = " select count(*) from users;";
        int index = getID(id);

        String sql = "INSERT INTO users VALUES ('"+user.getUsername()+"','"+user.getAge()+"', '"+user.getGender()+"', '"+user.getGender()+"')";

        ResultSet resultSet = getResult(sql);
    }

    public User getUserDetails(String username)
    {
        // This SQL statement produces all table
        // names and column names in the H2 schema

        String sql = "SELECT * from users where username = '"+username+"';";
        ResultSet resultSet = null;
        User user = null;
        try
        {

            resultSet = connectToDatabase(sql);
            if (resultSet.next()) {
                String userName = resultSet.getString(1);
                int age = resultSet.getInt(2);
                String gender = resultSet.getString(3);
                String preferedGender = resultSet.getString(4);

                user = User.builder().build();
                user.setUsername(username);
                user.setAge(age);
                user.setGender(gender);
                user.setPreferedGenderOfPartner(preferedGender);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
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
        Class.forName(SQLConfig.DRIVER);
        Connection c = DriverManager.getConnection(
                SQLConfig.JDBC+"://"+SQLConfig.URL+":"+SQLConfig.PORT+"/"+SQLConfig.DATABASE, SQLConfig.USER, SQLConfig.PASSWORD);
        Statement statement = c.createStatement();
        set = statement.executeQuery(sql);

        return set;
    }

}
