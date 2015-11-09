package com.caffinc.myip.app;

import com.caffinc.myip.resources.MyIPClient;
import com.caffinc.myip.utils.Utils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;


/**
 * Tests the whole service
 * @author Sriram
 */
public class AppTest
{
    private static final Logger LOG = LoggerFactory.getLogger( AppTest.class );
    private static final String randomPort = String.valueOf( 5000 + ( new Random() ).nextInt( 5000 ) );


    @BeforeClass public static void setUp() throws Exception
    {
        new Thread()
        {
            @Override public void run()
            {
                try {
                    System.setProperty( "port", randomPort );
                    App.main( new String[] {} );
                } catch ( Exception e ) {
                    LOG.error( "Could not start service to test", e );
                }
            }
        }.start();
        long startTime = System.currentTimeMillis();
        while ( System.currentTimeMillis() - 10000 < startTime ) {
            if ( App.isServerRunning() ) {
                break;
            }
            Thread.sleep( 100 );
        }
        if ( !App.isServerRunning() ) {
            throw new IllegalStateException( "Could not start server for testing" );
        }
    }


    @Test public void testGetIp() throws Exception
    {
        MyIPClient client = new MyIPClient( randomPort );
        Assert.assertFalse( "Server should return an IP", Utils.isNullOrWhitespace( client.getIp() ) );
    }


    @Test public void testGetIpWithXRealIp() throws Exception
    {
        MyIPClient client = new MyIPClient( randomPort, "123.123.123.123" );
        Assert.assertEquals( "Server should return the X-Real-IP", "123.123.123.123", client.getIp() );
    }
}
