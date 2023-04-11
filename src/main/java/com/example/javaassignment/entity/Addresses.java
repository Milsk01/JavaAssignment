package com.example.javaassignment.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Addresses {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "first_line")
    private String firstLine;
    @Basic
    @Column(name = "second_line")
    private String secondLine;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "state")
    private String state;
    @Basic
    @Column(name = "province")
    private String province;
    @Basic
    @Column(name = "postal_code")
    private String postalCode;
    @Basic
    @Column(name = "country_id")
    private int countryId;
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Countries countriesByCountryId;
    @OneToMany(mappedBy = "addressesByAddressId")
    private Collection<Participants> participantsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Addresses addresses = (Addresses) o;

        if (id != addresses.id) return false;
        if (countryId != addresses.countryId) return false;
        if (firstLine != null ? !firstLine.equals(addresses.firstLine) : addresses.firstLine != null) return false;
        if (secondLine != null ? !secondLine.equals(addresses.secondLine) : addresses.secondLine != null) return false;
        if (city != null ? !city.equals(addresses.city) : addresses.city != null) return false;
        if (state != null ? !state.equals(addresses.state) : addresses.state != null) return false;
        if (province != null ? !province.equals(addresses.province) : addresses.province != null) return false;
        if (postalCode != null ? !postalCode.equals(addresses.postalCode) : addresses.postalCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstLine != null ? firstLine.hashCode() : 0);
        result = 31 * result + (secondLine != null ? secondLine.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + countryId;
        return result;
    }

    public Countries getCountriesByCountryId() {
        return countriesByCountryId;
    }

    public void setCountriesByCountryId(Countries countriesByCountryId) {
        this.countriesByCountryId = countriesByCountryId;
    }

    public Collection<Participants> getParticipantsById() {
        return participantsById;
    }

    public void setParticipantsById(Collection<Participants> participantsById) {
        this.participantsById = participantsById;
    }
}
