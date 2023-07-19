/*
 * Copyright 2021 University of Applied Sciences Würzburg-Schweinfurt, Germany
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package de.fhws.fiw.fds.exam03.server.api.services;

import de.fhws.fiw.fds.exam03.server.api.models.Event;
import de.fhws.fiw.fds.exam03.server.api.queries.QueryByTopicShort;
import de.fhws.fiw.fds.exam03.server.api.states.events.*;

import de.fhws.fiw.fds.exam03.server.database.utils.ResetDatabase;
import de.fhws.fiw.fds.sutton.server.api.queries.PagingBehaviorUsingOffsetSize;
import de.fhws.fiw.fds.sutton.server.api.services.AbstractService;

import javax.ws.rs.*;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path( "events" ) public class EventService extends AbstractService
{

	@POST @Consumes( { MediaType.APPLICATION_JSON } )
	public Response createSingleEvent( final Event personModel )
	{
		return new PostNewEvent.Builder( ).setModelToCreate( personModel )
				.setUriInfo( this.uriInfo )
				.setRequest( this.request )
				.setHttpServletRequest( this.httpServletRequest )
				.setContext( this.context )
				.build( )
				.execute( );
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getAllEvents(
			@DefaultValue("") @QueryParam("topicShort") final String topicShort,
			@DefaultValue("0") @QueryParam("offset") int offset,
			@DefaultValue("20") @QueryParam("size") int size)
	{

		Response response = new GetAllEvents.Builder()

				.setQuery(new QueryByTopicShort(topicShort, offset, size).
						setPagingBehavior(new PagingBehaviorUsingOffsetSize(offset, size)))
				.setUriInfo(this.uriInfo)
				.setRequest(this.request)
				.setHttpServletRequest(this.httpServletRequest)
				.setContext(this.context)
				.build()
				.execute();

		final CacheControl cacheControl = new CacheControl();
		cacheControl.setPrivate(false);
		cacheControl.setMaxAge(10);
		cacheControl.setNoTransform(false);

		Response.ResponseBuilder responseBuilder = Response.ok()
				.cacheControl(cacheControl);
		responseBuilder.entity(response.getEntity());
		response.getHeaders().forEach((name, values) -> {
			for (Object value : values) {
				responseBuilder.header(name.toString(), value.toString());
			}
		});
		Response finalResponse = responseBuilder.build();

		return finalResponse;

	}

	@GET
	@Path( "{id: \\d+}" )
	@Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
	public Response getSingleEvent( @PathParam( "id" ) final long id )
	{



		return
				 new GetSingleEvent.Builder( )
						.setRequestedId( id )
						.setUriInfo( this.uriInfo )
						.setRequest( this.request )
						.setHttpServletRequest( this.httpServletRequest )
						.setContext( this.context )
						.build( )
						.execute( );




	}

	@PUT @Path( "{id: \\d+}" ) @Consumes( { MediaType.APPLICATION_JSON } )
	public Response updateSingleEvent( @PathParam( "id" ) final long id, final Event personModel )
	{
		return new PutSingleEvent.Builder( ).setRequestedId( id )
				.setModelToUpdate( personModel )
				.setUriInfo( this.uriInfo )
				.setRequest( this.request )
				.setHttpServletRequest( this.httpServletRequest )
				.setContext( this.context )
				.build( )
				.execute( );
	}

	@DELETE @Path( "{id: \\d+}" ) @Consumes( { MediaType.APPLICATION_JSON } )
	public Response deleteSingleEvent( @PathParam( "id" ) final long id )
	{
		return new DeleteSingleEvent.Builder( ).setRequestedId( id )
				.setUriInfo( this.uriInfo )
				.setRequest( this.request )
				.setHttpServletRequest( this.httpServletRequest )
				.setContext( this.context )
				.build( )
				.execute( );
	}

	@GET @Path( "resetdatabase" ) @Produces( { MediaType.APPLICATION_JSON } ) public Response resetDatabase( )
	{
		ResetDatabase.reset( );
		return Response.ok( ).build( );
	}
}

