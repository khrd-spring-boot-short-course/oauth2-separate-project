package com.phearun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.phearun.configuration.component.ApiURL;

@RestController
public class UserController {

	private OAuth2RestOperations oAuth2RestOperations;
	private ApiURL apiURL;

	@Autowired
	public UserController(OAuth2RestOperations oAuth2RestOperations, ApiURL apiURL) {
		this.oAuth2RestOperations = oAuth2RestOperations;
		this.apiURL = apiURL;
	}

	@RequestMapping("/me")
	public JsonNode home() {
		return oAuth2RestOperations.getForObject(apiURL.resource, JsonNode.class);
	}

	@GetMapping("/access_token")
	public OAuth2AccessToken oAuth2AccessToken(){
		return oAuth2RestOperations.getAccessToken();
	}

}
