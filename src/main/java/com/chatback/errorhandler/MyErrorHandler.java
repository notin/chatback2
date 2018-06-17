package com.chatback.errorhandler;

import com.chatback.utils.JsonConverter;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;

@Component
public class MyErrorHandler implements ResponseErrorHandler {

    java.util.logging.Logger logger = java.util.logging.Logger.getAnonymousLogger();
    JsonConverter jsonConverter = new JsonConverter();
    public MyErrorHandler()
    {
        Arrays.stream(logger.getHandlers()).forEach(x->x.setLevel(Level.INFO));
    }
    public void handleError(ClientHttpResponse response) throws IOException
    {
        logger.info("error "+ response.getStatusText().toLowerCase()+" has occurred");
        logger.info(jsonConverter.toJson(response.getBody()));
    }


    public boolean hasError(ClientHttpResponse response) throws IOException
    {
        Boolean error = false;
         if(!response.getStatusCode().is2xxSuccessful())
         {
             error = true;
         }
         return error;
    }
}