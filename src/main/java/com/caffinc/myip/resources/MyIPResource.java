package com.caffinc.myip.resources;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;


/**
 * Provides endpoint for MyIP service
 * @author Sriram
 */
@Path ("/")
public class MyIPResource
{
    @GET public Response getIp( @Context HttpServletRequest request )
    {
        if ( request.getHeader( "X-Real-IP" ) == null ) {
            return Response.ok( request.getRemoteAddr() ).build();
        } else {
            return Response.ok( request.getHeader( "X-Real-IP" ) ).build();
        }
    }
}
