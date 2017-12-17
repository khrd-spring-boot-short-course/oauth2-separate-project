package com.phearun.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.phearun.configuration.component.ApiURL;
import com.phearun.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    OAuth2RestOperations oAuth2RestOperations;

    @Autowired
    private ApiURL apiURL;

    @RequestMapping
    public JsonNode findAll(){
        return oAuth2RestOperations.getForObject(apiURL.message, JsonNode.class);
    }

    @PostMapping
    public JsonNode save(Message message){
        System.out.println(message);
        return oAuth2RestOperations.postForObject(apiURL.message, message, JsonNode.class);
    }
}
