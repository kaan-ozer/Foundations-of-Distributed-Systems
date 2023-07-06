package de.fhws.fiw.fds.exam03.server.api.states.events;

import de.fhws.fiw.fds.exam03.server.api.models.Event;
import de.fhws.fiw.fds.exam03.server.database.DaoFactory;
import de.fhws.fiw.fds.sutton.server.api.states.AbstractState;
import de.fhws.fiw.fds.sutton.server.api.states.get.AbstractGetState;
import de.fhws.fiw.fds.sutton.server.database.results.SingleModelResult;


public class GetSingleEvent extends AbstractGetState<Event>
{
    public GetSingleEvent( final Builder builder )
    {
        super( builder );
    }

    public static class Builder extends AbstractGetStateBuilder
    {
        @Override public AbstractState build( )
        {
            return new GetSingleEvent( this );
        }
    }


    @Override protected void defineTransitionLinks( )
    {
        addLink( EventUri.REL_PATH_ID, EventRelTypes.UPDATE_SINGLE_EVENT, getAcceptRequestHeader( ),
                this.requestedId );
        addLink( EventUri.REL_PATH_ID, EventRelTypes.DELETE_SINGLE_EVENT, getAcceptRequestHeader( ),
                this.requestedId );
    }


    @Override protected SingleModelResult<Event> loadModel( )
    {
        return DaoFactory.getInstance( ).getEventDao( ).readById( this.requestedId );
    }


    @Override protected void authorizeRequest( )
    {
    }

}
