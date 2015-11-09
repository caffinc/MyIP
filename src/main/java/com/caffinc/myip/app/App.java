package com.caffinc.myip.app;

import com.caffinc.myip.resources.MyIPResource;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;


/**
 * Starts the MyIP service
 * @author Sriram
 */
public class App
{
    private static final int PORT = Integer.parseInt( System.getProperty( "port", "9876" ) );

    private static Server server = null;

    public static void main( String[] args ) throws Exception
    {
        server = new Server( PORT );
        ServletContextHandler handler = new ServletContextHandler( ServletContextHandler.SESSIONS );
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.packages( MyIPResource.class.getPackage().getName() );
        ServletHolder holder = new ServletHolder( new ServletContainer( resourceConfig ) );
        holder.setAsyncSupported( true );
        handler.setContextPath( "/" );
        handler.addServlet( holder, "/*" );
        server.setHandler( handler );
        server.start();
    }

    public static boolean isServerRunning() {
        return server != null && server.isRunning();
    }
}
