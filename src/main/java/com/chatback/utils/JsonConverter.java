package com.chatback.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Logger;

public class JsonConverter
{
    static Logger logger = Logger.getAnonymousLogger();
    static ObjectMapper mapper = new ObjectMapper();

    public JsonConverter()
    {
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    }

    public static  <T> T  getResponse(Class<T> clazz, T response, String responce)
    {
        try
        {
            response = mapper.readValue(responce, clazz);
        }
        catch (Exception e)
        {
           Logger.getAnonymousLogger().info(e.getMessage());
        }
        return response;
    }

    public static String  toJson(Object object)
    {
        String jsonInString = "";
        try {
           jsonInString =  mapper.writeValueAsString(object);
        }
        catch (Exception e)
        {
            logger.info(e.getMessage());
        }
        return jsonInString;
    }
}
