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

package de.fhws.fiw.fds.exam03.server.database;

import de.fhws.fiw.fds.exam03.server.database.hibernate.EventDaoAdapter;

public class DaoFactory
{
	private static DaoFactory INSTANCE;

	public static final DaoFactory getInstance( )
	{
		if ( INSTANCE == null )
		{
			INSTANCE = new DaoFactory( );
		}

		return INSTANCE;
	}

	private final EventDao eventDao;

	private DaoFactory( )
	{
		this.eventDao = new EventDaoAdapter( );
	}

	public EventDao getEventDao( )
	{
		return this.eventDao;
	}
}
