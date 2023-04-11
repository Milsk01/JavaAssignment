package com.example.javaassignment.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Countries {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "country_name")
    private String countryName;
    @OneToMany(mappedBy = "countriesByCountryId")
    private Collection<Addresses> addressesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Countries countries = (Countries) o;

        if (id != countries.id) return false;
        if (countryName != null ? !countryName.equals(countries.countryName) : countries.countryName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        return result;
    }

    public Collection<Addresses> getAddressesById() {
        return addressesById;
    }

    public void setAddressesById(Collection<Addresses> addressesById) {
        this.addressesById = addressesById;
    }
}
