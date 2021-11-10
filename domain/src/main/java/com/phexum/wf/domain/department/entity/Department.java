package com.phexum.wf.domain.department.entity;

import java.util.ArrayList;
import java.util.List;
import com.phexum.wf.domain.apartment.entity.Apartment;
import com.phexum.wf.domain.firm.entity.Firm;
import com.phexum.wf.domain.permission.Permission;

public class Department {
  private Long id;
  private String name;
  private Firm firm;
  private List<Permission> permissions = new ArrayList<>();
  private Apartment apartment = new Apartment();

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

  public Firm getFirm() {
    return firm;
  }

  public void setFirm(Firm firm) {
    this.firm = firm;
  }

  public List<Permission> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<Permission> permission) {
    this.permissions = permission;
  }

  public void addPermission(Permission permission) {
    this.permissions.add(permission);
  }

  public Apartment getApartment() {
    return apartment;
  }

  public void setApartment(Apartment apartment) {
    this.apartment = apartment;
  }


}
