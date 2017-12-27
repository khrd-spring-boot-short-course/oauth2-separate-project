package com.phearun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.phearun.configuration.component.ApiURL;
import com.phearun.model.Message;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private OAuth2RestOperations oAuth2RestOperations;
    private ApiURL apiURL;

    @Autowired
    public MessageController(OAuth2RestOperations oAuth2RestOperations, ApiURL apiURL) {
        this.oAuth2RestOperations = oAuth2RestOperations;
        this.apiURL = apiURL;
    }
    
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

