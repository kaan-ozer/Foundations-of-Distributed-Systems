package de.fhws.fiw.fds.exam03.server.api.services;

import de.fhws.fiw.fds.sutton.server.api.services.AbstractService;
import de.fhws.fiw.fds.exam03.server.api.states.dispatcher.GetDispatcher;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path( "" )
public class DispatcherService extends AbstractService
{
	@GET
	public Response getDispatcher( )
	{
		return new GetDispatcher.Builder( ).setUriInfo( this.uriInfo )
										   .setRequest( this.request )
										   .setHttpServletRequest( this.httpServletRequest )
										   .setContext( this.context )
										   .build( )
										   .execute( );
	}
}
