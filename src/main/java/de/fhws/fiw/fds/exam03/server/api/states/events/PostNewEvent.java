package de.fhws.fiw.fds.exam03.server.api.states.events;
import de.fhws.fiw.fds.sutton.server.api.states.AbstractState;
import de.fhws.fiw.fds.sutton.server.api.states.post.AbstractPostState;
import de.fhws.fiw.fds.sutton.server.database.results.NoContentResult;
import de.fhws.fiw.fds.exam03.server.database.DaoFactory;
import de.fhws.fiw.fds.exam03.server.api.models.Event;
public class PostNewEvent extends AbstractPostState<Event> {

        public PostNewEvent( final Builder builder )
        {
            super( builder );
        }

        public static class Builder extends AbstractPostStateBuilder<Event>
        {
            @Override
            public AbstractState build( )
            {
                return new PostNewEvent( this );
            }
        }

        @Override
        protected void defineTransitionLinks( )
        {

        }


        @Override
        protected NoContentResult saveModel( )
        {
            return DaoFactory.getInstance( ).getEventDao( ).create( this.modelToStore );
        }

        @Override
        protected void authorizeRequest( )
        {
        }



}


