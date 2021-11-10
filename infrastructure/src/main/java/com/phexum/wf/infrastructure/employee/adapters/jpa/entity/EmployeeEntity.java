package com.phexum.wf.infrastructure.employee.adapters.jpa.entity;

import com.phexum.wf.domain.permission.Permission;
import com.phexum.wf.infrastructure.department.adapters.jpa.entity.DepartmentEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(targetEntity = DepartmentEntity.class)
    private DepartmentEntity department;

    @ElementCollection(targetClass = Permission.class)
    @Column
    @Enumerated(EnumType.STRING)
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

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
