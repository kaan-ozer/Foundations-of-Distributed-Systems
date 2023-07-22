
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

import java.util.List;

public class LoadAllEventsByTopic
        extends AbstractDatabaseOperation<EventDB, CollectionModelHibernateResult<EventDB>>
{
    private final String search;
    private final SearchParameter searchParameter;
    private final String order; // New parameter for sorting

    public LoadAllEventsByTopic(EntityManagerFactory emf, String search, String order, SearchParameter searchParameter) {
        super(emf);
        this.search = search.toLowerCase();
        this.searchParameter = searchParameter;
        this.order = order;
    }

    @Override
    protected CollectionModelHibernateResult<EventDB> run()
    {

/*
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<EventDB> cq = cb.createQuery(EventDB.class);
        final Root<EventDB> root = cq.from(EventDB.class);

        final String searchKeyword = this.search.toLowerCase();

        final Predicate matchTopicShort = cb.like(cb.lower(root.get("topicShort")), searchKeyword + "%");
        final Predicate matchTopicLong = cb.like(cb.lower(root.get("topicLong")), searchKeyword + "%");

        final Predicate predicate = cb.or(matchTopicShort, matchTopicLong);

        final CriteriaQuery<EventDB> filterByNames = cq.select(root).where(predicate);

        TypedQuery<EventDB> query = em.createQuery(filterByNames);


        int totalResults = em.createQuery(filterByNames).getResultList().size();


        query.setFirstResult(searchParameter.getOffset());
        query.setMaxResults(searchParameter.getSize());

        List<EventDB> resultList = query.getResultList();

        CollectionModelHibernateResult<EventDB> returnValue = new CollectionModelHibernateResult<>(resultList);
        returnValue.setTotalNumberOfResult(totalResults); // Set the total count of results

        return returnValue;*/

        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<EventDB> cq = cb.createQuery(EventDB.class);
        final Root<EventDB> root = cq.from(EventDB.class);

        final String searchKeyword = this.search.toLowerCase();
        final Predicate matchTopicShort = cb.like(cb.lower(root.get("topicShort")), searchKeyword + "%");
        final Predicate matchTopicLong = cb.like(cb.lower(root.get("topicLong")), searchKeyword + "%");

        final Predicate predicate = cb.or(matchTopicShort, matchTopicLong);
        final CriteriaQuery<EventDB> filterByNames = cq.select(root).where(predicate);


        if (order.startsWith("+")) {
            String orderBy = order.substring(1);
            if (orderBy.equals("topicShort") || orderBy.equals("topicLong")) {
                cq.orderBy(cb.asc(root.get(orderBy)));
            } else {

            }
        } else if (order.startsWith("-")) {
            String orderBy = order.substring(1);
            if (orderBy.equals("topicShort") || orderBy.equals("topicLong")) {
                cq.orderBy(cb.desc(root.get(orderBy)));
            } else {

            }
        }

        TypedQuery<EventDB> query = em.createQuery(filterByNames);


        int totalResults = em.createQuery(filterByNames).getResultList().size();


        query.setFirstResult(searchParameter.getOffset());
        query.setMaxResults(searchParameter.getSize());

        List<EventDB> resultList = query.getResultList();

        CollectionModelHibernateResult<EventDB> returnValue = new CollectionModelHibernateResult<>(resultList);
        returnValue.setTotalNumberOfResult(totalResults);

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

