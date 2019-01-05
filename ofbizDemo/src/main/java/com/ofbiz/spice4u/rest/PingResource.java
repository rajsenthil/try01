package com.ofbiz.spice4u.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.base.util.UtilMisc;
import org.apache.ofbiz.entity.DelegatorFactory;
import org.apache.ofbiz.entity.GenericDelegator;

import org.apache.ofbiz.service.GenericServiceException;
import org.apache.ofbiz.service.LocalDispatcher;
import org.apache.ofbiz.service.ServiceDispatcher;
import org.apache.ofbiz.service.ServiceUtil;

@Path("/ping")
public class PingResource {

    @GET
    @Produces("text/plain")
    @Path("{message}")
    public Response sayHello(@PathParam("message") String message) {

        GenericDelegator delegator = (GenericDelegator) DelegatorFactory.getDelegator("default");
        ServiceDispatcher serviceDispatcher = ServiceDispatcher.getInstance(delegator);
        LocalDispatcher dispatcher = serviceDispatcher.getLocalDispatcher("default",delegator);

        Map<String, String> paramMap = UtilMisc.toMap( "message", message );

        Map<String, Object> result = new HashMap<>();
        try {
            result = dispatcher.runSync("ping", paramMap);
        } catch (GenericServiceException e1) {
            Debug.logError(e1, PingResource.class.getName());
            return Response.serverError().entity(e1.toString()).build();
        }

        if (ServiceUtil.isSuccess(result)) {
            return Response.ok("RESPONSE: *** " + result.get("message") + " ***").type("text/plain").build();
        }

        if (ServiceUtil.isError(result) || ServiceUtil.isFailure(result)) {
            return Response.serverError().entity(ServiceUtil.getErrorMessage(result)).build();
        }

        // shouldn't ever get here ... should we?
        throw new RuntimeException("Invalid ");
    }
}
