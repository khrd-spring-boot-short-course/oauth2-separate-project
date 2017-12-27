package com.phearun.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;

@Controller
public class LoginController {
	
	@Autowired
	private OAuth2RestOperations oAuth2RestOperations;
	
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password){
		System.out.println("login");
		
		System.out.println("username:" +  username);
		System.out.println("password:" + password);
		
		oAuth2RestOperations.getOAuth2ClientContext().getAccessTokenRequest().set("username", "user");
    	oAuth2RestOperations.getOAuth2ClientContext().getAccessTokenRequest().set("password", "user");
		
    	System.out.println(oAuth2RestOperations.getForObject("http://localhost:8082/api/me", JsonNode.class));
		
		return "redirect:/";
	} 
	
	@GetMapping("/login")
	public String loginPage(){
		return "mylogin";
	}
	
}
