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

import de.fhws.fiw.fds.exam03.server.Start;
import de.fhws.fiw.fds.exam03.server.api.services.EventComparator;

public interface EventUri
{
	String REVERSE_ORDER_TOPIC = "&order=-topic";
	String REVERSE_ORDER_DATE = "&order=-date";
	String SEARCH_ELEMENT= "?search={SEARCH}";
	String PATH_ELEMENT = "events";
	String REL_PATH = Start.CONTEXT_PATH + "/api/" + PATH_ELEMENT;
	String REL_PATH_BY_SEARCH = REL_PATH + SEARCH_ELEMENT;
	String REL_PATH_BY_SEARCH_REVERSE_ORDER_TOPIC = REL_PATH + REVERSE_ORDER_TOPIC;
	String REL_PATH_BY_SEARCH_REVERSE_ORDER_DATE = REL_PATH + REVERSE_ORDER_DATE;
	String REL_PATH_ID = REL_PATH + "/{id}";
}

