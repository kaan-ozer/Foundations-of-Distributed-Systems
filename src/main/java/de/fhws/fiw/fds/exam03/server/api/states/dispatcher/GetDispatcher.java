// Copyright 2022 Peter Braun
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package de.fhws.fiw.fds.exam03.server.api.states.dispatcher;


import de.fhws.fiw.fds.sutton.server.api.states.get.AbstractGetDispatcherState;
import de.fhws.fiw.fds.exam03.server.api.states.events.EventRelTypes;
import de.fhws.fiw.fds.exam03.server.api.states.events.EventUri;

public class GetDispatcher extends AbstractGetDispatcherState
{

	public GetDispatcher( Builder builder )
	{
		super( builder );
	}

	@Override
	protected void defineTransitionLinks( )
	{
		addLink( EventUri.REL_PATH, EventRelTypes.GET_ALL_EVENTS, getAcceptRequestHeader( ) );
		addLink(EventUri.REL_PATH_BY_SEARCH,EventRelTypes.GET_ALL_EVENTS_BY_SEARCH,getAcceptRequestHeader());
		addLink(EventUri.REL_PATH_BY_DATE,EventRelTypes.GET_ALL_EVENTS_BY_DATE,getAcceptRequestHeader());
		addLink(EventUri.REL_PATH_BY_SEARCH_WITH_ORDER,EventRelTypes.GET_ALL_EVENTS_BY_SEARCH_WITH_ORDER,getAcceptRequestHeader());
		addLink(EventUri.REL_PATH_BY_DATE_WITH_ORDER,EventRelTypes.GET_ALL_EVENTS_BY_DATE_WITH_ORDER,getAcceptRequestHeader());

	}


	public static class Builder extends AbstractDispatcherStateBuilder
	{
		@Override
		public GetDispatcher build( )
		{
			return new GetDispatcher( this );
		}
	}
}
