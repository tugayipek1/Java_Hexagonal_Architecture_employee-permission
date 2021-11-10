package com.phexum.wf.domain.employee.service;

import java.util.Optional;
import com.phexum.wf.domain.common.CrudServiceImpl;
import com.phexum.wf.domain.common.DomainComponent;
import com.phexum.wf.domain.employee.entity.Employee;
import com.phexum.wf.domain.employee.port.EmployeeRepository;
import com.phexum.wf.domain.employee.port.EmployeeService;


@DomainComponent
public class EmployeeServiceImpl extends CrudServiceImpl<EmployeeRepository, Employee, Long> implements EmployeeService {

  public EmployeeServiceImpl(EmployeeRepository repository) {
    super(repository);
  }

  @Override
  public Employee create(Employee entity) {
    Optional.ofNullable(entity.getDepartment()).orElseThrow(() -> new RuntimeException("Department can not be null"));

    return super.create(entity);
  }


}
