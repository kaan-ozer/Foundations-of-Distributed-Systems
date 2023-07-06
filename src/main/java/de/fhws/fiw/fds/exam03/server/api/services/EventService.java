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



import de.fhws.fiw.fds.exam03.server.api.states.events.GetSingleEvent;
import de.fhws.fiw.fds.sutton.server.api.services.AbstractService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path( "events" ) public class EventService extends AbstractService
{



	@GET
	@Path( "{id: \\d+}" )
	@Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
	public Response getSingleEvent( @PathParam( "id" ) final long id )
	{
		return new GetSingleEvent.Builder( )
				.setRequestedId( id )
				.setUriInfo( this.uriInfo )
				.setRequest( this.request )
				.setHttpServletRequest( this.httpServletRequest )
				.setContext( this.context )
				.build( )
				.execute( );
	}


}
