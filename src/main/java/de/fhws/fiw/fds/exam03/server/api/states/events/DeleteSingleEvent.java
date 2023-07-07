package de.fhws.fiw.fds.exam03.server.api.states.events;

import de.fhws.fiw.fds.sutton.server.api.states.AbstractState;
import de.fhws.fiw.fds.sutton.server.api.states.delete.AbstractDeleteState;
import de.fhws.fiw.fds.sutton.server.database.results.NoContentResult;
import de.fhws.fiw.fds.sutton.server.database.results.SingleModelResult;
import de.fhws.fiw.fds.exam03.server.database.DaoFactory;
import de.fhws.fiw.fds.exam03.server.api.models.Event;

public class DeleteSingleEvent extends AbstractDeleteState<Event>
{
    public DeleteSingleEvent( final Builder builder )
    {
        super( builder );
    }

    public static class Builder extends AbstractDeleteStateBuilder
    {
        @Override
        public AbstractState build( )
        {
            return new DeleteSingleEvent( this );
        }
    }

    @Override
    protected void defineTransitionLinks( )
    {
    }


    @Override
    protected SingleModelResult<Event> loadModel( )
    {
        return DaoFactory.getInstance( ).getEventDao( ).readById( this.modelIdToDelete );
    }

    @Override
    protected NoContentResult deleteModel( )
    {
        return DaoFactory.getInstance( ).getEventDao( ).delete( this.modelIdToDelete );
    }


    @Override
    protected void authorizeRequest( )
    {

    }


}
