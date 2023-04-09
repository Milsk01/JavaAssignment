package com.example.javaassignment.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Events {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "event_id")
    private int eventId;
    @Basic
    @Column(name = "event_name")
    private String eventName;
    @Basic
    @Column(name = "event_date")
    private Timestamp eventDate;
    @OneToMany(mappedBy = "eventsByEventId")
    private Collection<EventRegistration> eventRegistrationsByEventId;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Timestamp getEventDate() {
        return eventDate;
    }

    public void setEventDate(Timestamp eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Events events = (Events) o;

        if (eventId != events.eventId) return false;
        if (eventName != null ? !eventName.equals(events.eventName) : events.eventName != null) return false;
        if (eventDate != null ? !eventDate.equals(events.eventDate) : events.eventDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eventId;
        result = 31 * result + (eventName != null ? eventName.hashCode() : 0);
        result = 31 * result + (eventDate != null ? eventDate.hashCode() : 0);
        return result;
    }

    public Collection<EventRegistration> getEventRegistrationsByEventId() {
        return eventRegistrationsByEventId;
    }

    public void setEventRegistrationsByEventId(Collection<EventRegistration> eventRegistrationsByEventId) {
        this.eventRegistrationsByEventId = eventRegistrationsByEventId;
    }
}
