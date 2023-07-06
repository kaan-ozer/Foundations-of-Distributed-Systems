package de.fhws.fiw.fds.exam03.server.database.hibernate.operations;

import de.fhws.fiw.fds.exam03.server.database.hibernate.models.EventDB;
import de.fhws.fiw.fds.sutton.server.database.hibernate.operations.AbstractReadByIdOperation;
import jakarta.persistence.EntityManagerFactory;

public class LoadEventById extends AbstractReadByIdOperation<EventDB>
{
    public LoadEventById(EntityManagerFactory emf, long idToLoad )
    {
        super( emf, EventDB.class, idToLoad );
    }
}
