package com.example.javaassignment.entity;

import javax.persistence.*;

@Entity
@Table(name = "participant_detail_event_registration", schema = "java_assignment_q3", catalog = "")
public class ParticipantDetailEventRegistration {
    @Basic
    @Column(name = "participant_detail_id")
    private int participantDetailId;
    @Basic
    @Column(name = "event_registration_id")
    private int eventRegistrationId;
    @ManyToOne
    @JoinColumn(name = "participant_detail_id", referencedColumnName = "participant_detail_id", nullable = false)
    private ParticipantDetails participantDetailsByParticipantDetailId;
    @ManyToOne
    @JoinColumn(name = "event_registration_id", referencedColumnName = "event_registration_id", nullable = false)
    private EventRegistration eventRegistrationByEventRegistrationId;

    public int getParticipantDetailId() {
        return participantDetailId;
    }

    public void setParticipantDetailId(int participantDetailId) {
        this.participantDetailId = participantDetailId;
    }

    public int getEventRegistrationId() {
        return eventRegistrationId;
    }

    public void setEventRegistrationId(int eventRegistrationId) {
        this.eventRegistrationId = eventRegistrationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParticipantDetailEventRegistration that = (ParticipantDetailEventRegistration) o;

        if (participantDetailId != that.participantDetailId) return false;
        if (eventRegistrationId != that.eventRegistrationId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = participantDetailId;
        result = 31 * result + eventRegistrationId;
        return result;
    }

    public ParticipantDetails getParticipantDetailsByParticipantDetailId() {
        return participantDetailsByParticipantDetailId;
    }

    public void setParticipantDetailsByParticipantDetailId(ParticipantDetails participantDetailsByParticipantDetailId) {
        this.participantDetailsByParticipantDetailId = participantDetailsByParticipantDetailId;
    }

    public EventRegistration getEventRegistrationByEventRegistrationId() {
        return eventRegistrationByEventRegistrationId;
    }

    public void setEventRegistrationByEventRegistrationId(EventRegistration eventRegistrationByEventRegistrationId) {
        this.eventRegistrationByEventRegistrationId = eventRegistrationByEventRegistrationId;
    }
}
