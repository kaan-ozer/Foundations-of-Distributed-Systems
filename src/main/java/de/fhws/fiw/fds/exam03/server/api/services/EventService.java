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
import de.fhws.fiw.fds.exam03.server.api.queries.QueryByTopic;
import de.fhws.fiw.fds.exam03.server.api.states.events.*;

import de.fhws.fiw.fds.exam03.server.api.utils.EtagGenerator;
import de.fhws.fiw.fds.exam03.server.database.utils.ResetDatabase;
import de.fhws.fiw.fds.sutton.server.api.hyperlinks.Hyperlinks;
import de.fhws.fiw.fds.sutton.server.api.services.AbstractService;

import javax.ws.rs.*;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static de.fhws.fiw.fds.exam03.server.api.utils.CacheControlHelper.cachePublicAndTenSeconds;
import static de.fhws.fiw.fds.sutton.server.api.queries.PagingBehaviorUsingOffsetSize.*;

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
			@DefaultValue("") @QueryParam("search") final String search,
			@DefaultValue("") @QueryParam("date") final String startDateAndTime,
			@DefaultValue( "+topic" ) @QueryParam( "order" ) final String order,
			@DefaultValue("0") @QueryParam(QUERY_PARAM_OFFSET) int offset,
			@DefaultValue(DEFAULT_PAGE_SIZE_STR) @QueryParam(QUERY_PARAM_SIZE) int size)
	{

		Response response = new GetAllEvents.Builder()
				.setQuery(new QueryByTopic(search, startDateAndTime, order, offset, size))
				.setUriInfo(this.uriInfo)
				.setRequest(this.request)
				.setHttpServletRequest(this.httpServletRequest)
				.setContext(this.context)
				.build()
				.execute();

		Response.ResponseBuilder responseBuilder = Response.fromResponse(response);


		if (search.isEmpty() && startDateAndTime.isEmpty()) {

			responseBuilder.cacheControl(cachePublicAndTenSeconds());

		}


		return responseBuilder.build();

		}


	@GET
	@Path( "{id: \\d+}" )
	@Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
	public Response getSingleEvent( @PathParam( "id" ) final long id )
	{


		Response response = new GetSingleEvent.Builder()
				.setRequestedId(id)
				.setUriInfo(this.uriInfo)
				.setRequest(this.request)
				.setHttpServletRequest(this.httpServletRequest)
				.setContext(this.context)
				.build()
				.execute();



		Event event = (Event) response.getEntity();

		if (event == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		final EntityTag entityTag = EtagGenerator.createEntityTag(event);

		System.out.println("Entity TAG:" + entityTag);

		Response.ResponseBuilder builder = request.evaluatePreconditions(entityTag);

		if (builder == null)
		{

			builder = Response.ok(event)
					.cacheControl(cachePublicAndTenSeconds())
					.tag(entityTag);


			for (Map.Entry<String, List<Object>> entry : response.getHeaders().entrySet())
			{
				String name = entry.getKey();
				List<Object> values = entry.getValue();
				for (Object value : values)
				{
					builder.header(name, value);
				}
			}
		}


		return builder.build();

	}

	@PUT @Path( "{id: \\d+}" ) @Consumes( { MediaType.APPLICATION_JSON } )
	public Response updateSingleEvent( @PathParam( "id" ) final long id, final Event personModel )
	{

		Response response = new GetSingleEvent.Builder()
				.setRequestedId(id)
				.setUriInfo(this.uriInfo)
				.setRequest(this.request)
				.setHttpServletRequest(this.httpServletRequest)
				.setContext(this.context)
				.build()
				.execute();


		Event event = (Event) response.getEntity();


		if (event == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}


		if (id != event.getId()) {
			System.out.println(event.getId() + "eventıd" + id + "id normal");
			return Response.status(Response.Status.BAD_REQUEST).build();
		}


		final EntityTag entityTag = EtagGenerator.createEntityTag(event);

		System.out.println("Entity TAG:" + entityTag);


		Response.ResponseBuilder builder = request.evaluatePreconditions(entityTag);

		if (builder != null) {

			return Response.status(Response.Status.PRECONDITION_FAILED).build();
		} else {
			return new PutSingleEvent.Builder( ).setRequestedId( id )
					.setModelToUpdate( personModel )
					.setUriInfo( this.uriInfo )
					.setRequest( this.request )
					.setHttpServletRequest( this.httpServletRequest )
					.setContext( this.context )
					.build( )
					.execute( );
		}
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

