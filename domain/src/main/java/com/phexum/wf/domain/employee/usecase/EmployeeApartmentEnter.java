package com.phexum.wf.domain.employee.usecase;

import com.phexum.wf.domain.apartment.entity.Apartment;
import com.phexum.wf.domain.common.usecase.UseCase;
import com.phexum.wf.domain.employee.entity.Employee;

public class EmployeeApartmentEnter implements UseCase {

  private Employee employee;
  private Apartment apartment;

  public EmployeeApartmentEnter() {

  }

  public EmployeeApartmentEnter(Employee employee, Apartment apartment) {
    this.employee = employee;
    this.apartment = apartment;
  }


  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }


  public Apartment getApartment() {
    return apartment;
  }


  public void setApartment(Apartment apartment) {
    this.apartment = apartment;
  }

}
