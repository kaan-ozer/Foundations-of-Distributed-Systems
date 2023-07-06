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

public class Event extends AbstractModel
{



    private String topicShort;
    private String topicLong;
    private String address;
    private String startDateAndTime;
    private String endDateAndTime;
    private String institution;
    private String lecturer;
    private String location;



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
