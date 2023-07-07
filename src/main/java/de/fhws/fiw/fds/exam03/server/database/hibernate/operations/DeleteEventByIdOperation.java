package de.fhws.fiw.fds.exam03.server.database.hibernate.operations;

import de.fhws.fiw.fds.exam03.server.api.models.Event;
import de.fhws.fiw.fds.exam03.server.database.hibernate.models.EventDB;
import de.fhws.fiw.fds.sutton.server.database.hibernate.operations.AbstractDeleteOperationById;
import jakarta.persistence.EntityManagerFactory;
public class DeleteEventByIdOperation extends AbstractDeleteOperationById<EventDB> {

        public DeleteEventByIdOperation( EntityManagerFactory emf, long idToDelete )
        {
            super( emf, EventDB.class, idToDelete );
        }

}
