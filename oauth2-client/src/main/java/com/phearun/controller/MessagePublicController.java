package com.phearun.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.phearun.configuration.component.ApiURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/messages")
public class MessagePublicController {

    @Autowired
    OAuth2RestOperations oAuth2RestOperations;

    @Autowired
    private ApiURL apiURL;

    @GetMapping
    public JsonNode message(){
        return oAuth2RestOperations.getForObject(apiURL.publicMessage, JsonNode.class);
    }

    @GetMapping("/{id}")
    public JsonNode findMessage(@PathVariable Integer id){
        return oAuth2RestOperations.getForObject(String.format("%s/%s", apiURL.publicMessage, id), JsonNode.class);
    }

}
