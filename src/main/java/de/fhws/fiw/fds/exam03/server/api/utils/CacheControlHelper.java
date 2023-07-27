package de.fhws.fiw.fds.exam03.server.api.utils;


import javax.ws.rs.core.CacheControl;

public class CacheControlHelper
{
    public static CacheControl cachePrivateAndTenSeconds( )
    {
        final CacheControl returnValue = new CacheControl( );

        returnValue.setPrivate( true );
        returnValue.setMaxAge( 10 );
        returnValue.setNoTransform( false );

        return returnValue;
    }

    public static CacheControl cachePublicAndTenSeconds( )
    {
        final CacheControl returnValue = new CacheControl( );

        returnValue.setPrivate( false );
        returnValue.setMaxAge( 10 );
        returnValue.setNoTransform( false );

        return returnValue;
    }

    public static CacheControl cachePublicAndOneMinute( )
    {
        final CacheControl returnValue = new CacheControl( );

        returnValue.setPrivate( false );
        returnValue.setMaxAge( 60 );
        returnValue.setNoTransform( false );

        return returnValue;
    }
}
