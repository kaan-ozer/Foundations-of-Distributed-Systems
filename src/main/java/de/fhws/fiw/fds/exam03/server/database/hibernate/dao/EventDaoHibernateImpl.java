package de.fhws.fiw.fds.exam03.server.database.hibernate.dao;

import de.fhws.fiw.fds.exam03.server.database.hibernate.models.EventDB;
import de.fhws.fiw.fds.exam03.server.database.hibernate.operations.*;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.hibernate.results.CollectionModelHibernateResult;
import de.fhws.fiw.fds.sutton.server.database.hibernate.results.SingleModelHibernateResult;
import de.fhws.fiw.fds.sutton.server.database.results.NoContentResult;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Random;
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
		IntStream.range( 0, 12 ).forEach(i -> create( createEvent( ) ) );
	}

	//*********************CRUD OPERATIONS*********************
	public NoContentResult create( EventDB model )
	{
		return new PersistEventOperation( emf, model  ).start();
	}

	private EventDB createEvent() {
		final EventDB returnValue = new EventDB();

		Random random = new Random();

		String[] topicsShort = {"Math", "Science", "History", "Art", "English", "Biology", "Computer Science", "Chemistry", "Music", "Geography", "Physical Education", "Economics"};
		String[] topicsLong = {"Mathematics", "Physics", "World History", "Painting", "English Literature", "Cell Biology", "Introduction to Programming", "Organic Chemistry", "Music Theory", "Geographical Concepts", "Sports and Fitness", "Microeconomics"};
		String[] addresses = {"123 Main Street", "456 Oak Avenue", "789 Elm Street"};
		String[] institutions = {"University XYZ", "College ABC", "School DEF"};
		String[] lecturers = {"Prof. Johnson", "Dr. Smith", "Prof. Williams", "Dr. Brown", "Prof. Lee", "Dr. Wilson", "Prof. Martin", "Dr. Anderson", "Prof. Davis", "Dr. Clark"};
		String[] locations = {"City A", "City B", "City C"};

		int index = random.nextInt(topicsShort.length);
		returnValue.setTopicShort(topicsShort[index]);

		index = random.nextInt(topicsLong.length);
		returnValue.setTopicLong(topicsLong[index]);

		index = random.nextInt(addresses.length);
		returnValue.setAddress(addresses[index]);


		int year = random.nextInt(3) + 2023;
		int month = random.nextInt(12) + 1;
		int day = random.nextInt(28) + 1;
		int hour = random.nextInt(24);
		int minute = random.nextInt(60);

		String formattedHour = String.format("%02d", hour);

		returnValue.setStartDateAndTime(year + "-" + month + "-" + day + "T" + formattedHour + ":" + minute + ":00");


		int daysToAdd = random.nextInt(5) + 1;
		returnValue.setEndDateAndTime(year + "-" + month + "-" + (day + daysToAdd) + "T" + formattedHour + ":" + minute + ":00");

		index = random.nextInt(institutions.length);
		returnValue.setInstitution(institutions[index]);

		index = random.nextInt(lecturers.length);
		returnValue.setLecturer(lecturers[index]);

		index = random.nextInt(locations.length);
		returnValue.setLocation(locations[index]);

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


