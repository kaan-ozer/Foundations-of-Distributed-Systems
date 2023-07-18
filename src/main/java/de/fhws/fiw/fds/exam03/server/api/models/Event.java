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

package de.fhws.fiw.fds.exam03.server.api.models;


import de.fhws.fiw.fds.sutton.server.api.models.AbstractModel;
import org.glassfish.jersey.linking.InjectLink;

import com.owlike.genson.annotation.JsonConverter;
import de.fhws.fiw.fds.sutton.server.api.converter.JsonServerLinkConverter;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import com.owlike.genson.annotation.JsonConverter;
import de.fhws.fiw.fds.sutton.server.api.converter.JsonServerLinkConverter;
import de.fhws.fiw.fds.sutton.server.api.converter.XmlServerLinkConverter;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.io.Serializable;

@XmlRootElement
@XmlAccessorType( XmlAccessType.FIELD )
public class Event extends AbstractModel implements Serializable
{

    private String topicShort;
    private String topicLong;
    private String address;
    private String startDateAndTime;
    private String endDateAndTime;
    private String institution;
    private String lecturer;
    private String location;

    @InjectLink(
            style = InjectLink.Style.ABSOLUTE,
            value = "/events/${instance.id}",
            rel = "self",
            title = "self",
            type = "application/json",
            condition = "${instance.primaryId == 0}"
    )
    private Link selfLinkPrimary;


    public Event() {

    }

    public Event( String topicShort, String topicLong, String address, String startDateAndTime, String endDateAndTime, String institution, String lecturer, String location) {

        this.topicShort = topicShort;
        this.topicLong = topicLong;
        this.address = address;
        this.startDateAndTime = startDateAndTime;
        this.endDateAndTime = endDateAndTime;
        this.institution = institution;
        this.lecturer = lecturer;
        this.location = location;
    }

    @JsonConverter(JsonServerLinkConverter.class)
    public Link getSelfLinkPrimary() {
        return selfLinkPrimary;
    }

    public void setSelfLinkPrimary(Link selfLinkPrimary) {
        this.selfLinkPrimary = selfLinkPrimary;
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



   /* @Override public String toString( )
    {
        return "Event{" +
                "id=" + id +
                ", topicShort='" + topicShort + '\'' +
                ", topicLong='" + topicLong + '\'' +
                ", address=" + address +
                ", startDateAndTime='" + startDateAndTime + '\'' +
                ", endDateAndTime='" + endDateAndTime + '\'' +
                ", institution='" + institution + '\'' +
                ", lecturer='" + lecturer + '\'' +
                ", location='" + location + '\'' +
                '}';
    }*/
}
