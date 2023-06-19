package de.fhws.fiw.fds.exam03.server.database.hibernate.models;

import de.fhws.fiw.fds.sutton.server.database.hibernate.models.AbstractDBModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table( name = "events" )
public class EventDB extends AbstractDBModel
{
}
