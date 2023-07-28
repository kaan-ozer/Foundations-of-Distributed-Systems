/*
 * Copyright 2021 University of Applied Sciences Würzburg-Schweinfurt, Germany
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package de.fhws.fiw.fds.exam03.server.api.states.events;

public interface EventRelTypes
{
	String CREATE_EVENT = "createEvent";
	String GET_ALL_EVENTS = "getAllEvents";

	String GET_ALL_EVENTS_BY_SEARCH = "getAllEventsBySearch";
	String GET_ALL_EVENTS_BY_DATE = "getAllEventsByDate";


	String UPDATE_SINGLE_EVENT = "updateEvent";
	String DELETE_SINGLE_EVENT = "deleteEvent";
	String GET_SINGLE_EVENT = "getEvent";
}
