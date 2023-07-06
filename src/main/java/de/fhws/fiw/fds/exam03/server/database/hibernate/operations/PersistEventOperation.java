package de.fhws.fiw.fds.exam03.server.database.hibernate.operations;

import de.fhws.fiw.fds.exam03.server.database.hibernate.models.EventDB;
import de.fhws.fiw.fds.sutton.server.database.hibernate.operations.AbstractPersistOperation;
import jakarta.persistence.EntityManagerFactory;

public class PersistEventOperation extends AbstractPersistOperation<EventDB>
{
    public PersistEventOperation(EntityManagerFactory emf, EventDB modelToPersist )
    {
        super( emf, modelToPersist );
    }
}