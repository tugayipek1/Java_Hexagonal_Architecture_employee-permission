package com.phexum.wf.domain.employee.usecase;

import com.phexum.wf.domain.common.usecase.UseCase;
import com.phexum.wf.domain.employee.entity.Employee;
import com.phexum.wf.domain.floor.entity.Floor;

public class EmployeeFloorEnter implements UseCase {
    private Employee employee;
    private Floor floor;

    public EmployeeFloorEnter() {
    }

    public EmployeeFloorEnter(Employee employee, Floor floor) {
        this.employee = employee;
        this.floor = floor;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }
}
