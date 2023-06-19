/*
 * Copyright (c) peter.braun@fhws.de
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

package de.fhws.fiw.fds.sutton.client.converters;

import com.owlike.genson.Context;
import com.owlike.genson.Converter;
import com.owlike.genson.stream.ObjectReader;
import com.owlike.genson.stream.ObjectWriter;
import de.fhws.fiw.fds.sutton.client.utils.Link;

/**
 * The ClientLinkConverter class provides the required functionality to serialize and deserialize the {@link Link} class
 * to and from the JSON format
 */
public class ClientLinkConverter implements Converter<Link>
{
	@Override
	public void serialize( final Link link, final ObjectWriter objectWriter, final Context context )
		throws Exception
	{
		objectWriter.writeName( link.getRelationType( ) );
		objectWriter.beginObject( );
		objectWriter.writeString( "href", replaceCharacters( link.getUrl( ) ) );
		objectWriter.writeString( "rel", link.getRelationType( ) );

		if ( link.getMediaType( ) != null && link.getMediaType( ).isEmpty( ) == false )
		{
			objectWriter.writeString( "type", link.getMediaType( ) );
		}

		objectWriter.endObject( );
	}

	@Override
	public Link deserialize( final ObjectReader objectReader, final Context context )
		throws Exception
	{
		final Link returnValue = new Link( );

		objectReader.beginObject( );
		while ( objectReader.hasNext( ) )
		{
			objectReader.next( );

			if ( "href".equals( objectReader.name( ) ) )
			{
				final String value = objectReader.valueAsString( );
				returnValue.setUrl( value );
			}

			if ( "rel".equals( objectReader.name( ) ) )
			{
				final String value = objectReader.valueAsString( );
				returnValue.setRelationType( value );
			}

			if ( "type".equals( objectReader.name( ) ) )
			{
				final String value = objectReader.valueAsString( );
				returnValue.setMediaType( value );
			}
		}

		objectReader.endObject( );

		return returnValue;
	}

	private String replaceCharacters( final String body )
	{
		return body.replace( "%3F", "?" ).replaceAll( "%7B", "{" ).replaceAll( "%7D", "}" );
	}
}
