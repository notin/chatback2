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

    public static final String URL= getProperty("url");
    public static final String PORT= getProperty("port");
    public static final String USER= getProperty("user");
    public static final String PASSWORD= getProperty("password");
    public static final String DATABASE= getProperty("db");
    public static final String JDBC= getProperty("jdbc");
    public static final String DRIVER= getProperty("driver");


}
