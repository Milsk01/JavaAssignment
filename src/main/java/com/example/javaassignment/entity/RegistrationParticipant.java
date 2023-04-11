package com.example.javaassignment.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "registration_participant", schema = "java_assignment_q3")
public class RegistrationParticipant implements Serializable {
    @Basic
    @Id
    @Column(name = "registration_id",insertable = false,updatable = false)
    private int registrationId;
    @Basic
    @Id
    @Column(name = "participant_id",insertable = false,updatable = false)
    private int participantId;

    @ManyToOne
    @JoinColumn(name = "registration_id", referencedColumnName = "id", nullable = false)
    private Registrations registrationsByRegistrationId;
    @ManyToOne
    @JoinColumn(name = "participant_id", referencedColumnName = "id", nullable = false)
    private Participants participantsByParticipantId;

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistrationParticipant that = (RegistrationParticipant) o;

        if (registrationId != that.registrationId) return false;
        if (participantId != that.participantId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = registrationId;
        result = 31 * result + participantId;
        return result;
    }

    public Registrations getRegistrationsByRegistrationId() {
        return registrationsByRegistrationId;
    }

    public void setRegistrationsByRegistrationId(Registrations registrationsByRegistrationId) {
        this.registrationsByRegistrationId = registrationsByRegistrationId;
    }

    public Participants getParticipantsByParticipantId() {
        return participantsByParticipantId;
    }

    public void setParticipantsByParticipantId(Participants participantsByParticipantId) {
        this.participantsByParticipantId = participantsByParticipantId;
    }
}
