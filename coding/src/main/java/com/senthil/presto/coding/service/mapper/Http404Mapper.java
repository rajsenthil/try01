package com.senthil.presto.coding.com.senthil.presto.coding.service.mapper;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class Http404Mapper implements ExceptionMapper<NotFoundException> {

    @Context
    private HttpHeaders headers;

    @Override
    public Response toResponse(NotFoundException nfe) {
        return Response.status(404).entity(nfe.getMessage()).type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}
