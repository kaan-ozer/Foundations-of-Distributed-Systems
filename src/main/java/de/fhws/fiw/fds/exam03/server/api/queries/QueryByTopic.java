package de.fhws.fiw.fds.exam03.server.api.queries;

import de.fhws.fiw.fds.exam03.server.api.models.Event;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.sutton.server.api.queries.PagingBehaviorUsingOffsetSize;
import de.fhws.fiw.fds.exam03.server.database.DaoFactory;
import de.fhws.fiw.fds.sutton.server.api.queries.AbstractQuery;
import de.fhws.fiw.fds.sutton.server.database.DatabaseException;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;

public class QueryByTopic extends AbstractQuery<Event>  {
    private String search;

    private String startDateAndTime;
    private String order;

    public QueryByTopic(String search,String startDateAndTime,String order, int offset, int size )
    {
        this.search = search;
        this.startDateAndTime = startDateAndTime;
        this.order = order;

        this.pagingBehavior = new PagingBehaviorUsingOffsetSize<Event>(offset, size );
    }

    public String getStartDateAndTime() {
        return startDateAndTime;
    }

    public void setStartDateAndTime(String startDateAndTime) {
        this.startDateAndTime = startDateAndTime;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    protected CollectionModelResult<Event> doExecuteQuery(SearchParameter searchParameter ) throws DatabaseException
    {


        return DaoFactory.getInstance( ).getEventDao( ).readByTopic(
                this.search,this.startDateAndTime,this.order,
                searchParameter );
    }
}