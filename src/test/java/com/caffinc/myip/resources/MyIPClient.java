package com.caffinc.myip.resources;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.GET;


/**
 * Client to access the MyIP service
 * @author Sriram
 */
public class MyIPClient
{
    private interface MyIPServiceInterface
    {
        @GET ("/") public String getIp();
    }


    private MyIPServiceInterface service;


    public MyIPClient( final String port )
    {
        this.service = new RestAdapter.Builder().setEndpoint( "http://localhost:" + port ).build()
            .create( MyIPServiceInterface.class );
    }


    public MyIPClient( final String port, final String ip )
    {
        this.service = new RestAdapter.Builder().setEndpoint( "http://localhost:" + port )
            .setRequestInterceptor( new RequestInterceptor()
            {
                public void intercept( RequestFacade request )
                {
                    request.addHeader( "X-Real-IP", ip );
                }
            } ).build().create( MyIPServiceInterface.class );
    }


    public String getIp()
    {
        return service.getIp();
    }
}
