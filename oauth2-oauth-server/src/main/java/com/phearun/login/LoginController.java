package com.phearun.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(types = AuthorizationRequest.class)
//@SessionAttributes("authorizationRequest")
public class LoginController {

	@GetMapping("/login")
	public String loginPage(){
		System.out.println("login page!!!");
		return "mylogin";
	}
	
	@Autowired
	private ClientDetailsService clientDetailService;
	
	//custom approval page
	@GetMapping("/oauth/confirm_access")
	public String getAccessConfirmation(Model model, @ModelAttribute AuthorizationRequest clientAuth) throws Exception{
		System.out.println("page: /oauth/confirm_access");
		ClientDetails client = clientDetailService.loadClientByClientId(clientAuth.getClientId());
		System.out.println(client);
		
		System.out.println(clientAuth.getClientId());
		
		model.addAttribute("clientAuth", clientAuth);
		
		return "confirm_access";
	}
	
}
