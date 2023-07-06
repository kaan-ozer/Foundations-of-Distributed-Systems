package de.fhws.fiw.fds.exam03.server.database.hibernate.dao;

import de.fhws.fiw.fds.exam03.server.database.hibernate.models.EventDB;
import de.fhws.fiw.fds.exam03.server.database.hibernate.operations.LoadEventById;
import de.fhws.fiw.fds.exam03.server.database.hibernate.operations.PersistEventOperation;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.hibernate.results.CollectionModelHibernateResult;
import de.fhws.fiw.fds.sutton.server.database.hibernate.results.SingleModelHibernateResult;
import de.fhws.fiw.fds.sutton.server.database.results.NoContentResult;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.stream.IntStream;

public class EventDaoHibernateImpl implements EventDaoHibernate
{
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory( "de.fhws.fiw.fds.exam03" );

	public EventDaoHibernateImpl( )
	{
		super( );
		populateDatabase( );
	}

	private void populateDatabase( )
	{
		IntStream.range( 0, 100 ).forEach(i -> create( createEvent( ) ) );
	}

	//*********************CRUD OPERATIONS*********************
	public NoContentResult create( EventDB model )
	{
		return new PersistEventOperation( emf, model  ).start();
	}

	private EventDB createEvent() {
		final EventDB returnValue = new EventDB();
		returnValue.setTopicShort("Bond");
		returnValue.setTopicLong("James Bond");
		returnValue.setAddress("123 Main Street");
		returnValue.setStartDateAndTime("2023-07-05 10:00");
		returnValue.setEndDateAndTime("2023-07-05 12:00");
		returnValue.setInstitution("MI6");
		returnValue.setLecturer("James Bond");
		returnValue.setLocation("London");
		return returnValue;
	}



	@Override public SingleModelHibernateResult<EventDB> readById( long id )
	{
		return new LoadEventById( emf, id ).start();
	}
	@Override public CollectionModelHibernateResult<EventDB> readAll( SearchParameter searchParameter )
	{
		return new LoadAllEventsOperations( emf ).start();
	}

	@Override
	public CollectionModelHibernateResult<EventDB> readByTopicShort( String topicShort,
																			   SearchParameter searchParameter )
	{
		return new LoadAllEventsByTopicShort( emf,  topicShort, searchParameter ).start( );
	}

	@Override public NoContentResult update( EventDB model )
	{
		return new NoContentResult();
	}

	@Override public NoContentResult delete( long id )
	{
		return new NoContentResult();
	}



}


