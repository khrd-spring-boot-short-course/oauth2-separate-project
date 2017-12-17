package com.phearun.configuration;

import com.phearun.configuration.component.ClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import java.util.Arrays;

@Configuration
@EnableOAuth2Client
public class OAuth2ClientConfiguration {

    @Autowired
    private ClientDetails clientDetails;

    @Bean
    public OAuth2RestOperations restTemplate(OAuth2ClientContext oauth2ClientContext) {
        return new OAuth2RestTemplate(resource(), oauth2ClientContext);
    }

    private OAuth2ProtectedResourceDetails resource() {
        AuthorizationCodeResourceDetails resource = new AuthorizationCodeResourceDetails();
        resource.setClientId(clientDetails.clientID);
        resource.setClientSecret(clientDetails.clientSecret);
        resource.setAccessTokenUri(clientDetails.accessTokenUri);
        resource.setUserAuthorizationUri(clientDetails.userAuthorizationUri);
        resource.setScope(Arrays.asList("read"));
        return resource;
    }
}
