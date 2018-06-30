package com.chatback.broker.database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


public class SQLConfig
{

    private static Properties prop = new Properties();
    protected static String getProperty(String key)
    {
        String property =null;
        Properties prop = new Properties();
        InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("sql.properties");
        OutputStream output = null;

        InputStream input = null;

        try {

//            input = new FileInputStream("sql.properties");

            // load a properties file
            prop.load(resourceAsStream);
             property = prop.getProperty(key);
        }
        catch (Exception e)
        {
        }
        return property;
    }
    public static final String URL= getProperty("url");
    public static final String PORT= getProperty("port");
    public static final String USER= getProperty("user");
    public static final String PASSWORD= getProperty("password");
    public static final String DATABASE= getProperty("db");
    public static final String JDBC= getProperty("jdbc");
    public static final String DRIVER= getProperty("driver");


}
