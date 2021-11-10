package com.phexum.wf.infrastructure.department.adapters.jpa.entity;

import com.phexum.wf.domain.apartment.entity.Apartment;
import com.phexum.wf.domain.firm.entity.Firm;
import com.phexum.wf.domain.permission.Permission;
import com.phexum.wf.infrastructure.apartment.adapters.jpa.entity.ApartmentEntity;
import com.phexum.wf.infrastructure.firm.adapters.jpa.entity.FirmEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    @ManyToOne(targetEntity = FirmEntity.class)
    private FirmEntity firm;
    @Column
    @ElementCollection(targetClass = Permission.class)
    @Enumerated(EnumType.STRING)
    private List<Permission> permissions = new ArrayList<>();

    @ManyToOne(targetEntity = ApartmentEntity.class)
    private ApartmentEntity apartment = new ApartmentEntity();

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

    public FirmEntity getFirm() {
        return firm;
    }

    public void setfirm(FirmEntity firm) {
        this.firm = firm;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public ApartmentEntity getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentEntity apartment) {
        this.apartment = apartment;
    }
}

