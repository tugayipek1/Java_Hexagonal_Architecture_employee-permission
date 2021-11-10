package com.phexum.wf.domain.floor.entity;

import java.util.ArrayList;
import java.util.List;
import com.phexum.wf.domain.building.entity.Building;
import com.phexum.wf.domain.permission.Permission;

public class Floor {
  private Long id;
  private int level;
  private Building building;
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

  public Building getBuilding() {
    return building;
  }

  public void setBuilding(Building building) {
    this.building = building;
  }

  public List<Permission> getEntrancePermissions() {
    return entrancePermissions;
  }

  public void setEntrancePermissions(List<Permission> entrancePermissions) {
    this.entrancePermissions = entrancePermissions;
  }

}
