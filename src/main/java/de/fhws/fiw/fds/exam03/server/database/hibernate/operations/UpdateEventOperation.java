package de.fhws.fiw.fds.exam03.server.database.hibernate.operations;
import de.fhws.fiw.fds.exam03.server.database.hibernate.models.EventDB;
import de.fhws.fiw.fds.sutton.server.database.hibernate.operations.AbstractUpdateOperation;
import jakarta.persistence.EntityManagerFactory;
public class UpdateEventOperation {

    public class UpdatePersonOperation extends AbstractUpdateOperation<EventDB>
    {
        public UpdatePersonOperation( EntityManagerFactory emf, EventDB modelToUpdate )
        {
            super( emf, modelToUpdate );
        }
    }

}
