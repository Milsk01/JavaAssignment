package com.example.javaassignment.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Registrations {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "is_first_time")
    private byte isFirstTime;
    @Basic
    @Column(name = "is_student")
    private byte isStudent;
    @Basic
    @Column(name = "tshirt_size")
    private String tshirtSize;
    @Basic
    @Column(name = "registration_fees")
    private String registrationFees;
    @Basic
    @Column(name = "number_of_paper")
    private String numberOfPaper;
    @Basic
    @Column(name = "event_id")
    private int eventId;
    @OneToMany(mappedBy = "registrationsByRegistrationId")
    private Collection<RegistrationParticipant> registrationParticipantsById;
    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Events eventsByEventId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getIsFirstTime() {
        return isFirstTime;
    }

    public void setIsFirstTime(byte isFirstTime) {
        this.isFirstTime = isFirstTime;
    }

    public byte getIsStudent() {
        return isStudent;
    }

    public void setIsStudent(byte isStudent) {
        this.isStudent = isStudent;
    }

    public String getTshirtSize() {
        return tshirtSize;
    }

    public void setTshirtSize(String tshirtSize) {
        this.tshirtSize = tshirtSize;
    }

    public String getRegistrationFees() {
        return registrationFees;
    }

    public void setRegistrationFees(String registrationFees) {
        this.registrationFees = registrationFees;
    }

    public String getNumberOfPaper() {
        return numberOfPaper;
    }

    public void setNumberOfPaper(String numberOfPaper) {
        this.numberOfPaper = numberOfPaper;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Registrations that = (Registrations) o;

        if (id != that.id) return false;
        if (isFirstTime != that.isFirstTime) return false;
        if (isStudent != that.isStudent) return false;
        if (eventId != that.eventId) return false;
        if (tshirtSize != null ? !tshirtSize.equals(that.tshirtSize) : that.tshirtSize != null) return false;
        if (registrationFees != null ? !registrationFees.equals(that.registrationFees) : that.registrationFees != null)
            return false;
        if (numberOfPaper != null ? !numberOfPaper.equals(that.numberOfPaper) : that.numberOfPaper != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) isFirstTime;
        result = 31 * result + (int) isStudent;
        result = 31 * result + (tshirtSize != null ? tshirtSize.hashCode() : 0);
        result = 31 * result + (registrationFees != null ? registrationFees.hashCode() : 0);
        result = 31 * result + (numberOfPaper != null ? numberOfPaper.hashCode() : 0);
        result = 31 * result + eventId;
        return result;
    }

    public Collection<RegistrationParticipant> getRegistrationParticipantsById() {
        return registrationParticipantsById;
    }

    public void setRegistrationParticipantsById(Collection<RegistrationParticipant> registrationParticipantsById) {
        this.registrationParticipantsById = registrationParticipantsById;
    }

    public Events getEventsByEventId() {
        return eventsByEventId;
    }

    public void setEventsByEventId(Events eventsByEventId) {
        this.eventsByEventId = eventsByEventId;
    }
}
