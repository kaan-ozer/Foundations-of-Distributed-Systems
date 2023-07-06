package de.fhws.fiw.fds.exam03.server.database.hibernate.models;

import de.fhws.fiw.fds.sutton.server.database.hibernate.models.AbstractDBModel;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table( name = "events" )
public class EventDB extends AbstractDBModel
{

    @Column(name = "id")
    private long id;

    @Column(name = "topic_short")
    private String topicShort;

    @Column(name = "topic_long")
    private String topicLong;

    @Column(name = "address")
    private String address;

    @Column(name = "start_date_and_time")
    private String startDateAndTime;

    @Column(name = "end_date_and_time")
    private String endDateAndTime;

    @Column(name = "institution")
    private String institution;

    @Column(name = "lecturer")
    private String lecturer;

    @Column(name = "location")
    private String location;



    public EventDB() {
    }

    public EventDB( String topicShort, String topicLong, String address, String startDateAndTime, String endDateAndTime, String institution, String lecturer, String location) {

        this.topicShort = topicShort;
        this.topicLong = topicLong;
        this.address = address;
        this.startDateAndTime = startDateAndTime;
        this.endDateAndTime = endDateAndTime;
        this.institution = institution;
        this.lecturer = lecturer;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTopicShort() {
        return topicShort;
    }

    public void setTopicShort(String topicShort) {
        this.topicShort = topicShort;
    }

    public String getTopicLong() {
        return topicLong;
    }

    public void setTopicLong(String topicLong) {
        this.topicLong = topicLong;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStartDateAndTime() {
        return startDateAndTime;
    }

    public void setStartDateAndTime(String startDateAndTime) {
        this.startDateAndTime = startDateAndTime;
    }

    public String getEndDateAndTime() {
        return endDateAndTime;
    }

    public void setEndDateAndTime(String endDateAndTime) {
        this.endDateAndTime = endDateAndTime;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
