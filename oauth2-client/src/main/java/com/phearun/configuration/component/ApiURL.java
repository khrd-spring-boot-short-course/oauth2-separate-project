package com.phearun.configuration.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiURL {

    @Value("${config.oauth2.resourceURI}")
    public String resource;

    @Value("${config.oauth2.messageURI}")
    public String message;

    @Value("${config.oauth2.publicMessageURI}")
    public String publicMessage;

}
