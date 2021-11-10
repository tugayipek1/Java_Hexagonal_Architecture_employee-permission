package com.phexum.wf.domain.apartment.entity;

import java.util.ArrayList;
import java.util.List;
import com.phexum.wf.domain.floor.entity.Floor;
import com.phexum.wf.domain.permission.Permission;

public class Apartment  {
  private Long id;
  private Floor floor;
  private int no;
  private List<Permission> entrancePermissions = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Floor getFloor() {
    return floor;
  }

  public void setFloor(Floor floor) {
    this.floor = floor;
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
