package de.fhws.fiw.fds.exam03.server.api.states.events;

import de.fhws.fiw.fds.exam03.server.api.models.Event;
import de.fhws.fiw.fds.exam03.server.database.DaoFactory;
import de.fhws.fiw.fds.sutton.server.api.queries.AbstractQuery;
import de.fhws.fiw.fds.sutton.server.api.states.AbstractState;
import de.fhws.fiw.fds.sutton.server.api.states.get.AbstractGetCollectionState;
import de.fhws.fiw.fds.sutton.server.database.DatabaseException;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;

import javax.ws.rs.core.GenericEntity;
import java.util.Collection;

public class GetAllEvents extends AbstractGetCollectionState<Event> {

    public GetAllEvents( final GetAllEvents.Builder builder )
    {
        super( builder );
    }



    public static class Builder extends AbstractGetCollectionStateBuilder<Event>
    {
        @Override public AbstractState build( )
        {
            return new GetAllEvents( this );
        }
    }

    @Override protected void defineTransitionLinks( )
    {

        addLink("/exam03/api/events?date={DATE}", "getAllEventsByDate",getAcceptRequestHeader());
        addLink("/exam03/api/events?search={DATE}&order=topic,-topic,date,-date", "getAllEventsByDateWithOrder",getAcceptRequestHeader());

        addLink("/exam03/api/events?search={SEARCH}", "getAllEventsBySearch",getAcceptRequestHeader());
        addLink("/exam03/api/events?search={SEARCH}&order=topic,-topic,date,-date", "gtAllEventsBySearchWithOrder",getAcceptRequestHeader());
    }



    protected void defineHttpResponseBody( )
    {

        this.responseBuilder.entity( new GenericEntity<Collection<Event>>( this.result.getResult( ) )
        {
        } );
    }


    public static class AllEvents extends AbstractQuery<Event> {
        @Override
        protected CollectionModelResult<Event> doExecuteQuery(SearchParameter searchParameter) throws DatabaseException {
            return DaoFactory.getInstance().getEventDao().readAll();
        }
    }

    @Override
    protected void authorizeRequest() {

    }


}
