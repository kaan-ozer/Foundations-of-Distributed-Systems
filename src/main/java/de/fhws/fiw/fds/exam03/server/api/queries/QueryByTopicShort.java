package de.fhws.fiw.fds.exam03.server.api.queries;

import de.fhws.fiw.fds.exam03.server.api.models.Event;
import de.fhws.fiw.fds.sutton.server.api.queries.PagingBehavior;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.sutton.server.api.queries.PagingBehaviorUsingOffsetSize;
import de.fhws.fiw.fds.exam03.server.database.DaoFactory;
import de.fhws.fiw.fds.sutton.server.api.queries.AbstractQuery;
import de.fhws.fiw.fds.sutton.server.database.DatabaseException;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;

public class QueryByTopicShort extends AbstractQuery<Event>  {
    private String topicShort;

    public QueryByTopicShort( String topicShort, int offset, int size )
    {
        this.topicShort = topicShort;

        this.pagingBehavior = new PagingBehaviorUsingOffsetSize<Event>(offset, size );
    }

    public String getTopicShort() {
        return topicShort;
    }

    public void setTopicShort(String topicShort) {
        this.topicShort = topicShort;
    }

    protected CollectionModelResult<Event> doExecuteQuery(SearchParameter searchParameter ) throws DatabaseException
    {


        return DaoFactory.getInstance( ).getEventDao( ).readByTopicShort(
                this.topicShort,
                searchParameter );
    }
}