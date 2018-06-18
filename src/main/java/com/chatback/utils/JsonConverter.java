package com.chatback.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Logger;

public class JsonConverter
{
    Logger logger = Logger.getAnonymousLogger();
    ObjectMapper mapper = new ObjectMapper();

    public JsonConverter()
    {
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    }

    public  <T> T getResponse(Class<T> clazz, T response, String responce)
    {
        try
        {
            response = mapper.readValue(responce, clazz);
        }
        catch (Exception e)
        {
            com.sun.istack.internal.logging.Logger.getLogger(this.getClass()).info(e.getMessage());
        }
        return response;
    }

    public String toJson(Object object)
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
