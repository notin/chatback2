package com.chatback.utils;

import com.chatback.errorhandler.MyErrorHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Caller
{
    Logger logger = Logger.getAnonymousLogger();
    private RestTemplate restTemplate;
    public Caller()
    {
        Arrays.stream(logger.getHandlers()).forEach(x->x.setLevel(Level.INFO));
    }

    public <T> T makeCall(String base, String param, String postBody, HttpMethod method, Class<T> clazz, String token) {
        T response = null;
        JsonConverter jsonConverter = new JsonConverter();
        restTemplate = setupRestTemplate();

        HttpHeaders httpHeaders = getHttpHeaders(token);

        HttpEntity<String> entity = new HttpEntity<String>(postBody, httpHeaders);

        UriComponentsBuilder uriComponentsBuilder = getUriComponentsBuilder(base, param);
        Map<String, Object> map = null;

        String baseForExchange = uriComponentsBuilder.toUriString();

        loggingCall(postBody, baseForExchange);
        ResponseEntity returned = restTemplate.exchange(baseForExchange, method, entity, String.class);

        logger.info(jsonConverter.toJson(returned));

        response = jsonConverter.getResponse(clazz, response, returned.getBody().toString());
        return response;
    }

    protected void loggingCall(String postBody, String baseForExchange) {
        logger.info(baseForExchange);
        if(postBody!=null)
        {
            logger.info(postBody);
        }
    }

    private <T> T getResponse(Class<T> clazz, T response, String responce, ObjectMapper mapper) {
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

    private UriComponentsBuilder getUriComponentsBuilder(String base, String param) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance();
        uriComponentsBuilder.scheme("https").host(base);
        if (param != null || param != "") {
            uriComponentsBuilder.path(param);
        }
        return uriComponentsBuilder;
    }

    private HttpHeaders getHttpHeaders(String token) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//        httpHeaders.add("Authorization", token);
        httpHeaders.add("cookie", token);


        for(String key : httpHeaders.keySet())
        {
            logger.info(key+":"+httpHeaders.get(key));

        }
        return httpHeaders;
    }

    private RestTemplate setupRestTemplate() {
        restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new MyErrorHandler());
        return restTemplate;
    }
}
