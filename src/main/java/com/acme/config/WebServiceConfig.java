package com.acme.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.acme.tshirt_service.impl.TshirtServiceImpl;

@Configuration
public class WebServiceConfig {
	
    @Autowired
    private Bus bus;
    
    @Autowired    
    private TshirtServiceImpl tshirtServicePortTypePortImpl;
 
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, tshirtServicePortTypePortImpl);
        endpoint.publish("/tshirt-service");
        return endpoint;
    }
}