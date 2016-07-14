package com.palvair.jaxrs.springboot;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Component
@Path("/hello")
public class RestWs {

    @GET
    public String message() {
        return "Hello";
    }
    
    @GET @Path("/getJson")
    @Produces(MediaType.APPLICATION_JSON)
    public RestWsResponse getJson() {
    	return new RestWsResponse("Json");
    }

}
