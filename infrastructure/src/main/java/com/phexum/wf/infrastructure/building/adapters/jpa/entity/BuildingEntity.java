package com.phexum.wf.infrastructure.building.adapters.jpa.entity;

import com.phexum.wf.domain.firm.entity.Firm;
import com.phexum.wf.infrastructure.firm.adapters.jpa.entity.FirmEntity;

import javax.persistence.*;

@Entity
public class BuildingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @JoinColumn(name = "firmId")
    @OneToOne(targetEntity = FirmEntity.class, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
    private FirmEntity firm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public FirmEntity getFirm() {
        return firm;
    }

    public void setFirm(FirmEntity firm) {
        this.firm = firm;
    }

}
