package de.fhws.fiw.fds.exam03.server.database.hibernate.dao;

import de.fhws.fiw.fds.exam03.server.database.hibernate.models.EventDB;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.hibernate.results.CollectionModelHibernateResult;
import de.fhws.fiw.fds.sutton.server.database.hibernate.results.SingleModelHibernateResult;
import de.fhws.fiw.fds.sutton.server.database.results.NoContentResult;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EventDaoHibernateImpl implements EventDaoHibernate
{
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory( "de.fhws.fiw.fds.exam03" );

	public EventDaoHibernateImpl( )
	{
		super( );
		populateDatabase( );
	}


	//*********************CRUD OPERATIONS*********************
	@Override public NoContentResult create( EventDB model )
	{
		return new NoContentResult();
	}


	@Override public SingleModelHibernateResult<EventDB> readById( long id )
	{
		return new SingleModelHibernateResult<>(  );
	}

	@Override public CollectionModelHibernateResult<EventDB> readAll( SearchParameter searchParameter )
	{
		return new CollectionModelHibernateResult<>(  );
	}


	@Override public NoContentResult update( EventDB model )
	{
		return new NoContentResult();
	}

	@Override public NoContentResult delete( long id )
	{
		return new NoContentResult();
	}

	private void populateDatabase( )
	{
	}

}
