package de.fhws.fiw.fds.exam03.server.api.states.events;

import de.fhws.fiw.fds.exam03.server.api.models.Event;
import de.fhws.fiw.fds.exam03.server.database.DaoFactory;
import de.fhws.fiw.fds.sutton.server.api.states.AbstractState;
import de.fhws.fiw.fds.sutton.server.api.states.put.AbstractPutState;
import de.fhws.fiw.fds.sutton.server.database.results.NoContentResult;
import de.fhws.fiw.fds.sutton.server.database.results.SingleModelResult;

public class PutSingleEvent extends AbstractPutState<Event>
{
    public PutSingleEvent( final Builder builder )
    {
        super( builder );
    }

    public static class Builder extends AbstractPutStateBuilder<Event>
    {
        @Override
        public AbstractState build( )
        {
            return new PutSingleEvent( this );
        }
    }

    @Override
    protected void defineTransitionLinks( )
    {

    }

    @Override
    protected SingleModelResult<Event> loadModel( )
    {
        return DaoFactory.getInstance( ).getEventDao( ).readById( this.modelToUpdate.getId( ) );
    }

    @Override
    protected NoContentResult updateModel( )
    {
        return DaoFactory.getInstance( ).getEventDao( ).update( this.modelToUpdate );
    }

    @Override
    protected void authorizeRequest( )
    {
    }

}
