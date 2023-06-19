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

package de.fhws.fiw.fds.exam03.server;

import de.fhws.fiw.fds.sutton.server.AbstractStart;

/**
 * DON'T USE THIS CLASS ANYMORE!
 *
 * Instead, run "mvn verify" (which then uses Docker). The embedded version of Tomcat does not
 * work in combination with JPA (Hibernate).
 */
public class Start extends AbstractStart
{
	public static final String CONTEXT_PATH = "exam03";

	public static void main( final String[] args ) throws Exception
	{
		new Start( ).startTomcat( );
	}

	@Override
	protected String contextPath( )
	{
		return CONTEXT_PATH;
	}
}
