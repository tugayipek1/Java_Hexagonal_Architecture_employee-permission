package com.phexum.wf.domain.employee.entity;

import java.util.ArrayList;
import java.util.List;
import com.phexum.wf.domain.department.entity.Department;
import com.phexum.wf.domain.permission.Permission;

public class Employee {
  private Long id;
  private String name;
  private Department department;
  private List<Permission> permissions = new ArrayList<>();

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

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
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

}
