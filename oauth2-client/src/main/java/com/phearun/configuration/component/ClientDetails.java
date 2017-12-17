package com.phearun.configuration.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClientDetails {

    @Value("${config.oauth2.accessTokenUri}")
    public String accessTokenUri;

    @Value("${config.oauth2.userAuthorizationUri}")
    public String userAuthorizationUri;

    @Value("${config.oauth2.clientID}")
    public String clientID;

    @Value("${config.oauth2.clientSecret}")
    public String clientSecret;

}
