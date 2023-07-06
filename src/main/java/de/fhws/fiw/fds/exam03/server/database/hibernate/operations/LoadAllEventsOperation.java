package de.fhws.fiw.fds.exam03.server.database.hibernate.operations;

import de.fhws.fiw.fds.exam03.server.database.hibernate.models.EventDB;
import de.fhws.fiw.fds.sutton.server.database.hibernate.operations.AbstractReadAllOperation;
import jakarta.persistence.EntityManagerFactory;

public class LoadAllEventsOperation extends AbstractReadAllOperation<EventDB>
{
    public LoadAllEventsOperation( EntityManagerFactory emf )
    {
        super( emf, EventDB.class );
    }
}