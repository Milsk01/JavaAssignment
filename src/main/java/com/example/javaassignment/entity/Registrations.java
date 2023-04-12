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

    @ManyToMany
    @JoinTable(
            name = "registration_event",
            joinColumns = @JoinColumn(name = "registration_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "event_id", referencedColumnName = "id", nullable = false))
    private Collection<Events> eventsById;


    @Basic
    @Column(name = "participant_id",insertable = false,updatable = false)
    private Integer participantId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "participant_id", referencedColumnName = "id")
    private Participants participantsByParticipantId;


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

    public void setEventsById(Collection<Events> eventsById) {
        this.eventsById = eventsById;
    }

    public Collection<Events> getEventsById() {
        return eventsById;
    }

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Registrations that = (Registrations) o;

        if (id != that.id) return false;
        if (isFirstTime != that.isFirstTime) return false;
        if (isStudent != that.isStudent) return false;
        if (tshirtSize != null ? !tshirtSize.equals(that.tshirtSize) : that.tshirtSize != null) return false;
        if (registrationFees != null ? !registrationFees.equals(that.registrationFees) : that.registrationFees != null)
            return false;
        if (numberOfPaper != null ? !numberOfPaper.equals(that.numberOfPaper) : that.numberOfPaper != null)
            return false;
        if (participantId != null ? !participantId.equals(that.participantId) : that.participantId != null)
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
        result = 31 * result + (participantId != null ? participantId.hashCode() : 0);
        return result;
    }

    public Participants getParticipantsByParticipantId() {
        return participantsByParticipantId;
    }

    public void setParticipantsByParticipantId(Participants participantsByParticipantId) {
        this.participantsByParticipantId = participantsByParticipantId;
    }


}
