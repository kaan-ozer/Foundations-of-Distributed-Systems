package de.fhws.fiw.fds.exam03.server.database.hibernate;

import de.fhws.fiw.fds.exam03.server.api.models.Event;
import de.fhws.fiw.fds.exam03.server.database.EventDao;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.sutton.server.database.results.NoContentResult;
import de.fhws.fiw.fds.sutton.server.database.results.SingleModelResult;

/**
 * This class is the adapter between the business logic layer and the database layer.
 * <p>
 * The business logic must use this class to access the database and it can use its own
 * model classes. This class takes care of translating models from the business logic into
 * models of the database layer and vice-versa.
 */
public class EventDaoAdapter implements EventDao
{

	@Override public NoContentResult create( Event model )
	{
		return new NoContentResult();
	}

	@Override public SingleModelResult<Event> readById( long id )
	{
		return new SingleModelResult<>(  );
	}

	@Override public CollectionModelResult<Event> readAll( )
	{
		return new CollectionModelResult<>(  );
	}

	@Override public CollectionModelResult<Event> readAll( SearchParameter searchParameter )
	{
		return new CollectionModelResult<>(  );
	}

	@Override public NoContentResult update( Event model )
	{
		return new NoContentResult();
	}

	@Override public NoContentResult delete( long id )
	{
		return new NoContentResult();
	}
}
