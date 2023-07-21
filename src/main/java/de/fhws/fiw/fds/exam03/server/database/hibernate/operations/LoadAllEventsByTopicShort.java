
package de.fhws.fiw.fds.exam03.server.database.hibernate.operations;


import de.fhws.fiw.fds.exam03.server.database.hibernate.models.EventDB;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.hibernate.operations.AbstractDatabaseOperation;
import de.fhws.fiw.fds.sutton.server.database.hibernate.results.CollectionModelHibernateResult;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class LoadAllEventsByTopicShort
        extends AbstractDatabaseOperation<EventDB, CollectionModelHibernateResult<EventDB>>
{
    private final String topicShort;


    private final SearchParameter searchParameter;

    public LoadAllEventsByTopicShort(EntityManagerFactory emf, String topicShort ,
                                     SearchParameter searchParameter )
    {
        super( emf );
        this.topicShort = topicShort.toLowerCase( );
        this.searchParameter = searchParameter;
    }

    @Override
    protected CollectionModelHibernateResult<EventDB> run()
    {
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<EventDB> cq = cb.createQuery(EventDB.class);
        final Root<EventDB> root = cq.from(EventDB.class);

        final Predicate matchTopicShort = cb.like(cb.lower(root.get("topicShort")), this.topicShort + "%");

        final Predicate predicate = cb.and(matchTopicShort);
        final CriteriaQuery<EventDB> filterByNames = cq.select(root).where(predicate);

        TypedQuery<EventDB> query = em.createQuery(filterByNames);

        // Calculate total number of results before applying offset and size
        int totalResults = em.createQuery(filterByNames).getResultList().size();

        // Apply offset and size
        query.setFirstResult(searchParameter.getOffset());
        query.setMaxResults(searchParameter.getSize());

        CollectionModelHibernateResult<EventDB> returnValue = new CollectionModelHibernateResult<>(query.getResultList());
        returnValue.setTotalNumberOfResult(totalResults); // Set the total count of results



        return returnValue;
    }

    @Override
    protected CollectionModelHibernateResult<EventDB> errorResult()
    {
        final CollectionModelHibernateResult<EventDB> returnValue = new CollectionModelHibernateResult<>();
        returnValue.setError();
        return returnValue;
    }

}

