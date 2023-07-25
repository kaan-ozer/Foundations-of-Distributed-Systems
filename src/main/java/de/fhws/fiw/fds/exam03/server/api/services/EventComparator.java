package de.fhws.fiw.fds.exam03.server.api.services;

import de.fhws.fiw.fds.exam03.server.api.models.Event;
import de.fhws.fiw.fds.exam03.server.database.hibernate.models.EventDB;

import java.util.Comparator;

public class EventComparator
{

    public static String reverseSearchOrder( final String orderAttribute )
    {
        switch ( orderAttribute )
        {
            case "+topic":
                return "-topic";
            case "-topic":
                return "%2Btopic";
            case "+date":
                return "-date";
            case "-date":
                return "%2Bdate";
            default:
                return "%2Btopic";
        }
    }


}
