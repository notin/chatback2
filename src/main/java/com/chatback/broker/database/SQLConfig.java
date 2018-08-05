package com.chatback.broker.database;

import com.chatback.controllers.Controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Logger;


public class SQLConfig
{
    protected static String getProperty(String key)
    {
        String property = null;
        Properties prop = new Properties();
        InputStream resourceAsStream = getResourceAsStream();

        try
        {
            prop.load(resourceAsStream);
            property = prop.getProperty(key);
        }
        catch (Exception e)
        {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        return property;
    }

    private static InputStream getResourceAsStream()
    {
        InputStream inputStream = null;
        if (Controller.IP.equalsIgnoreCase( "192.168.0.15"))
        {
                inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("sql.properties");
        }
        else if (Controller.IP.startsWith("172"))
        {
            inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("herokusql.properties");
        }
        return inputStream;
    }

    public static final String URL = "if0ck476y7axojpg.cbetxkdyhwsb.us-east-1.rds.amazonaws.com";
    public static final String PORT = "3306";
    public static final String USER = "ps1gvzc08kc0w43m";
    public static final String PASSWORD = "okyne5mslj3lhvdh";
    public static final String DATABASE = "m8jvzarz997wp3wj";
    public static final String JDBC = "jdbc=jdbc:mariadb";
    public static final String DRIVER = "org.mariadb.jdbc.Driver";


}
