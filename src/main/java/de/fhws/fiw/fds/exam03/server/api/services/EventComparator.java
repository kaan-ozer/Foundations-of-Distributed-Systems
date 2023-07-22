package de.fhws.fiw.fds.exam03.server.api.services;

import de.fhws.fiw.fds.exam03.server.api.models.Event;

import java.util.Comparator;

public class EventComparator
{
    public static Comparator<Event> by(final String orderAttribute )
    {
        switch ( orderAttribute )
        {
            case "+topic":
                return byTopic( );
            case "-topic":
                return byTopic( ).reversed( );
            case "+date":
                return byStartDate( );
            case "-date":
                return byStartDate( ).reversed( );
            default:
                return byId( );
        }
    }


    public static String reverseSearchOrder( final String orderAttribute )
    {
        switch ( orderAttribute )
        {
            case "+topic":
                return "-topic";
            case "-topic":
                return "+topic";
            case "+date":
                return "-date";
            case "-date":
                return "+date";
            default:
                return "+name";
        }
    }

    public static Comparator<Event> byId( )
    {
        return Comparator.comparing( Event::getId );
    }

    public static Comparator<Event> byTopic( )
    {
        return Comparator.comparing( Event::getTopicLong ).thenComparing( Event::getTopicShort );
    }

    public static Comparator<Event> byStartDate( )
    {
        return Comparator.comparing( Event::getStartDateAndTime );
    }
}
