package com.phearun.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import com.phearun.configuration.component.ClientDetails;

@Configuration
@EnableOAuth2Client
public class OAuth2ClientConfiguration {

    @Autowired
    private ClientDetails clientDetails;

    @Bean
    public OAuth2RestOperations oAuth2RestOperations(@Qualifier("oauth2ClientContext") OAuth2ClientContext oauth2ClientContext) {
        return new OAuth2RestTemplate(resourceOwnerPasswordResourceDetails(), oauth2ClientContext);
    }

    private OAuth2ProtectedResourceDetails authorizationCodeResourceDetails() {
        AuthorizationCodeResourceDetails resource = new AuthorizationCodeResourceDetails();
        resource.setClientId(clientDetails.clientID);
        resource.setClientSecret(clientDetails.clientSecret);
        resource.setAccessTokenUri(clientDetails.accessTokenUri);
        resource.setUserAuthorizationUri(clientDetails.userAuthorizationUri);
        resource.setScope(Arrays.asList("trust"));
        return resource;
    }
    
    private OAuth2ProtectedResourceDetails resourceOwnerPasswordResourceDetails() {
        ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
        resource.setClientId(clientDetails.clientID);
        resource.setClientSecret(clientDetails.clientSecret);
        resource.setAccessTokenUri(clientDetails.accessTokenUri);
        //resource.setUsername("user");
        //resource.setPassword("user");
        resource.setScope(Arrays.asList("trust"));
        return resource;
    }

}
