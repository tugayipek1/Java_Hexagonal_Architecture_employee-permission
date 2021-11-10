package com.phexum.wf.infrastructure.apartment.adapters.jpa.entity;

import com.phexum.wf.domain.floor.entity.Floor;
import com.phexum.wf.domain.permission.Permission;
import com.phexum.wf.infrastructure.floor.adapters.jpa.entity.FloorEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ApartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(targetEntity = FloorEntity.class)
    private FloorEntity floorEntity;
    private int no;
    @Column
    @ElementCollection(targetClass=Permission.class)
    @Enumerated(EnumType.STRING)
    private List<Permission> entrancePermissions = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FloorEntity getFloor() {
        return floorEntity;
    }

    public void setFloor(FloorEntity floorEntity) {
        this.floorEntity = floorEntity;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public List<Permission> getEntrancePermissions() {
        return entrancePermissions;
    }

    public void setEntrancePermissions(List<Permission> entrancePermissions) {
        this.entrancePermissions = entrancePermissions;
    }

}
