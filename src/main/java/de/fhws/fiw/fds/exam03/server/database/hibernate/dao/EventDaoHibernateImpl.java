package de.fhws.fiw.fds.exam03.server.database.hibernate.dao;

import de.fhws.fiw.fds.exam03.server.database.hibernate.models.EventDB;
import de.fhws.fiw.fds.exam03.server.database.hibernate.operations.*;
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
		IntStream.range( 0, 1 ).forEach(i -> create( createEvent( ) ) );
	}

	//*********************CRUD OPERATIONS*********************
	public NoContentResult create( EventDB model )
	{
		return new PersistEventOperation( emf, model  ).start();
	}

	private EventDB createEvent() {
		final EventDB returnValue = new EventDB();
		returnValue.setTopicShort("Math");
		returnValue.setTopicLong("Mathematics");
		returnValue.setAddress("789 Elm Street");
		returnValue.setStartDateAndTime("2023-10-17T13:15:00");
		returnValue.setEndDateAndTime("2023-11-17T13:18:00");
		returnValue.setInstitution("University XYZ");
		returnValue.setLecturer("Prof. Johnson");
		returnValue.setLocation("City A");
		return returnValue;
	}



	@Override public SingleModelHibernateResult<EventDB> readById( long id )
	{
		return new LoadEventById( emf, id ).start();
	}
	@Override public CollectionModelHibernateResult<EventDB> readAll( SearchParameter searchParameter )
	{
		return new LoadAllEventsOperation( emf ).start();
	}

	@Override
	public CollectionModelHibernateResult<EventDB> readByTopic( String search,String startDateAndTime, String order,
																			   SearchParameter searchParameter )
	{
		return new LoadAllEventsByTopic( emf, search,startDateAndTime,order,searchParameter).start( );
	}

	@Override public NoContentResult update( EventDB model )
	{
		return new UpdateEventOperation( emf, model ).start();
	}

	@Override public NoContentResult delete( long id )
	{
		return new DeleteEventByIdOperation( emf, id ).start();
	}



}


