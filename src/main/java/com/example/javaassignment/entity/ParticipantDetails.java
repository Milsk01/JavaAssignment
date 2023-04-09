package com.example.javaassignment.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "participant_details", schema = "java_assignment_q3", catalog = "")
public class ParticipantDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "participant_detail_id")
    private int participantDetailId;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic
    @Column(name = "address_id")
    private int addressId;
    @Basic
    @Column(name = "area_id")
    private int areaId;
    @OneToMany(mappedBy = "participantDetailsByParticipantDetailId")
    private Collection<ParticipantDetailEventRegistration> participantDetailEventRegistrationsByParticipantDetailId;
    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
    private Addresses addressesByAddressId;
    @ManyToOne
    @JoinColumn(name = "area_id", referencedColumnName = "area_id", nullable = false)
    private Areas areasByAreaId;

    public int getParticipantDetailId() {
        return participantDetailId;
    }

    public void setParticipantDetailId(int participantDetailId) {
        this.participantDetailId = participantDetailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParticipantDetails that = (ParticipantDetails) o;

        if (participantDetailId != that.participantDetailId) return false;
        if (addressId != that.addressId) return false;
        if (areaId != that.areaId) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = participantDetailId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + addressId;
        result = 31 * result + areaId;
        return result;
    }

    public Collection<ParticipantDetailEventRegistration> getParticipantDetailEventRegistrationsByParticipantDetailId() {
        return participantDetailEventRegistrationsByParticipantDetailId;
    }

    public void setParticipantDetailEventRegistrationsByParticipantDetailId(Collection<ParticipantDetailEventRegistration> participantDetailEventRegistrationsByParticipantDetailId) {
        this.participantDetailEventRegistrationsByParticipantDetailId = participantDetailEventRegistrationsByParticipantDetailId;
    }

    public Addresses getAddressesByAddressId() {
        return addressesByAddressId;
    }

    public void setAddressesByAddressId(Addresses addressesByAddressId) {
        this.addressesByAddressId = addressesByAddressId;
    }

    public Areas getAreasByAreaId() {
        return areasByAreaId;
    }

    public void setAreasByAreaId(Areas areasByAreaId) {
        this.areasByAreaId = areasByAreaId;
    }
}
