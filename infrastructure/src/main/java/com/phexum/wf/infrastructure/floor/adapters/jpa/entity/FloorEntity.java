package com.phexum.wf.infrastructure.floor.adapters.jpa.entity;

import com.phexum.wf.domain.permission.Permission;
import com.phexum.wf.infrastructure.building.adapters.jpa.entity.BuildingEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FloorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int level;
    @ManyToOne(targetEntity = BuildingEntity.class)
    private BuildingEntity buildingEntity;
    @Column
    @ElementCollection(targetClass = Permission.class)
    @Enumerated(EnumType.STRING)
    private List<Permission> entrancePermissions = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public BuildingEntity getBuilding() {
        return buildingEntity;
    }

    public void setBuilding(BuildingEntity buildingEntity) {
        this.buildingEntity = buildingEntity;
    }

    public List<Permission> getEntrancePermissions() {
        return entrancePermissions;
    }

    public void setEntrancePermissions(List<Permission> entrancePermissions) {
        this.entrancePermissions = entrancePermissions;
    }

}
