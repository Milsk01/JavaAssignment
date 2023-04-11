package com.example.javaassignment.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Areas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "area_name")
    private String areaName;
    @OneToMany(mappedBy = "areasByAreaId")
    private Collection<Participants> participantsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Areas areas = (Areas) o;

        if (id != areas.id) return false;
        if (areaName != null ? !areaName.equals(areas.areaName) : areas.areaName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (areaName != null ? areaName.hashCode() : 0);
        return result;
    }

    public Collection<Participants> getParticipantsById() {
        return participantsById;
    }

    public void setParticipantsById(Collection<Participants> participantsById) {
        this.participantsById = participantsById;
    }
}
