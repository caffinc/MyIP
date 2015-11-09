package com.caffinc.myip.utils;

import org.junit.Assert;
import org.junit.Test;


/**
 * Tests methods in Utils
 * @author Sriram
 */
public class UtilsTest
{
    @Test public void testIsNullOrWhitespaceForNull()
    {
        Assert.assertTrue( "Null String should return true", Utils.isNullOrWhitespace( null ) );
    }


    @Test public void testIsNullOrWhitespaceForEmpty()
    {
        Assert.assertTrue( "Empty String should return true", Utils.isNullOrWhitespace( "" ) );
    }


    @Test public void testIsNullOrWhitespaceForWhitespace()
    {
        Assert.assertTrue( "Whitespace should return true", Utils.isNullOrWhitespace( " " ) );
    }


    @Test public void testIsNullOrWhitespaceForValidString()
    {
        Assert.assertFalse( "Valid String should return false", Utils.isNullOrWhitespace( "test" ) );
    }
}
