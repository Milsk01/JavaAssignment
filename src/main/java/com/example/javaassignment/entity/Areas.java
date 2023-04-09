package com.example.javaassignment.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Areas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "area_id")
    private int areaId;
    @Basic
    @Column(name = "area_name")
    private String areaName;
    @OneToMany(mappedBy = "areasByAreaId")
    private Collection<ParticipantDetails> participantDetailsByAreaId;

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
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

        if (areaId != areas.areaId) return false;
        if (areaName != null ? !areaName.equals(areas.areaName) : areas.areaName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = areaId;
        result = 31 * result + (areaName != null ? areaName.hashCode() : 0);
        return result;
    }

    public Collection<ParticipantDetails> getParticipantDetailsByAreaId() {
        return participantDetailsByAreaId;
    }

    public void setParticipantDetailsByAreaId(Collection<ParticipantDetails> participantDetailsByAreaId) {
        this.participantDetailsByAreaId = participantDetailsByAreaId;
    }
}
