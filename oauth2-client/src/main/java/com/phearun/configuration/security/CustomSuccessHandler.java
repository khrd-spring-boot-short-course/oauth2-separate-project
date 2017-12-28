package com.phearun.configuration.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

	private OAuth2RestOperations oAuth2RestOperations;
	
	public CustomSuccessHandler(OAuth2RestOperations oAuth2RestOperations) {
		this.oAuth2RestOperations = oAuth2RestOperations;
	}
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		System.out.println("=> login success!");
		CustomUserDetail user = (CustomUserDetail) authentication.getPrincipal();
		
		//TODO: Setting up ResourceOwnerPasswordCredential
		oAuth2RestOperations.getOAuth2ClientContext().getAccessTokenRequest().set("username", user.getUsername());
    	oAuth2RestOperations.getOAuth2ClientContext().getAccessTokenRequest().set("password", user.getPassword());

    	//TODO: initialize request to make it remembers the request
		JsonNode jsonNode = oAuth2RestOperations.getForObject("http://localhost:8082/api/private/messages", JsonNode.class);
		System.out.println(jsonNode);

		response.sendRedirect(request.getContextPath());
	}
}
