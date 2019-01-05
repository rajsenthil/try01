package com.ofbiz.spice4u.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloWorld {

    @GET
    @Path("/message")
    public String sayHello() {
        return "Hello Rest World!!!";
    }
}
