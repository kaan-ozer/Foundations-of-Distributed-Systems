
package de.fhws.fiw.fds.exam03.server.database.hibernate.operations;


import de.fhws.fiw.fds.exam03.server.database.hibernate.models.EventDB;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.hibernate.operations.AbstractDatabaseOperation;
import de.fhws.fiw.fds.sutton.server.database.hibernate.results.CollectionModelHibernateResult;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LoadAllEventsByTopic
        extends AbstractDatabaseOperation<EventDB, CollectionModelHibernateResult<EventDB>>
{
    private final String search;
    private final String startDateAndTime;
    private final String order;
    private final SearchParameter searchParameter;

    public LoadAllEventsByTopic(EntityManagerFactory emf, String search,  String startDateAndTime, String order,
                                      SearchParameter searchParameter) {
        super(emf);
        this.search = search.toLowerCase();
        this.startDateAndTime = startDateAndTime;
        this.order = order;
        this.searchParameter = searchParameter;
    }



    @Override
    protected CollectionModelHibernateResult<EventDB> run()
    {

        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<EventDB> cq = cb.createQuery(EventDB.class);
        final Root<EventDB> root = cq.from(EventDB.class);

        final String searchKeyword = this.search.toLowerCase();
        final Predicate matchTopicShort = cb.like(cb.lower(root.get("topicShort")), searchKeyword + "%");
        final Predicate matchTopicLong = cb.like(cb.lower(root.get("topicLong")), searchKeyword + "%");
        final Predicate topicSearchPredicate = cb.or(matchTopicShort, matchTopicLong);

        Predicate finalPredicate = topicSearchPredicate;

        final Predicate matchDate = cb.like(cb.lower(root.get("startDateAndTime")), startDateAndTime + "%");

         finalPredicate = cb.and(topicSearchPredicate, matchDate);

        final CriteriaQuery<EventDB> filterByNames = cq.select(root).where(finalPredicate);

        // Sorting logic based on the order parameter
        if (order.equals("topic")) {
            filterByNames.orderBy(cb.asc(cb.function("LOWER", String.class, root.get("topicLong"))));
        } else if (order.equals("-topic")) {
            filterByNames.orderBy(cb.desc(cb.function("LOWER", String.class, root.get("topicLong"))));
        }

        TypedQuery<EventDB> query = em.createQuery(filterByNames);


        int totalResults = em.createQuery(filterByNames).getResultList().size();

        query.setFirstResult(searchParameter.getOffset());
        query.setMaxResults(searchParameter.getSize());

        List<EventDB> resultList = query.getResultList();

        if (order.equals("date")) {
            resultList.sort(Comparator.comparing(e -> LocalDate.parse(e.getStartDateAndTime(), DateTimeFormatter.ISO_LOCAL_DATE_TIME)));
        } else if(order.equals("-date")) {
            resultList.sort(Comparator.comparing(e -> LocalDate.parse(e.getStartDateAndTime(), DateTimeFormatter.ISO_LOCAL_DATE_TIME), Comparator.reverseOrder()));
        }

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

