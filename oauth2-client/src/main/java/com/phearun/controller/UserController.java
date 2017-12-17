package com.phearun.controller;

import com.phearun.configuration.component.ApiURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class UserController {

	@Autowired
	private OAuth2RestOperations restTemplate;

	@Autowired
	private ApiURL apiURL;

	@RequestMapping("/")
	public JsonNode home() {
		return restTemplate.getForObject(apiURL.resource, JsonNode.class);
	}

	@GetMapping("/access_token")
	public OAuth2AccessToken oAuth2AccessToken(){
		return restTemplate.getAccessToken();
	}
}
