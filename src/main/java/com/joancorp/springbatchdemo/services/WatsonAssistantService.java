package com.joancorp.springbatchdemo.services;

import org.springframework.stereotype.Service;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.*;

import com.joancorp.springbatchdemo.WatsonAssistantConfig;


@Service
public class WatsonAssistantService {
	
	private final WatsonAssistantConfig config;
	private SessionResponse session;
	private Assistant service;
	
	public WatsonAssistantService(WatsonAssistantConfig config) {
        this.config = config;
    }
	
	private SessionResponse createSession(Assistant service) {

        CreateSessionOptions createSessionOptions = new CreateSessionOptions.Builder(config.getId()).build();
        return service.createSession(createSessionOptions).execute().getResult();
    }
	
	private Assistant connect() {

        try {
            Authenticator authenticator = new IamAuthenticator(config.getApikey());
            Assistant service = new Assistant(config.getVersionDate(), authenticator);
            service.setServiceUrl(config.getUrl());
            //Cerrar sesion
            return service;
        } catch (Error e) {
            throw new Error(e);
        }
    }
    
}
