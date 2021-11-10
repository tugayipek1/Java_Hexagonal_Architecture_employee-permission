package com.phexum.wf.domain.department.service;

import java.util.Optional;
import com.phexum.wf.domain.common.CrudServiceImpl;
import com.phexum.wf.domain.common.DomainComponent;
import com.phexum.wf.domain.department.entity.Department;
import com.phexum.wf.domain.department.port.DepartmentRepository;
import com.phexum.wf.domain.department.port.DepartmentService;


@DomainComponent
public class DepartmentServiceImpl extends CrudServiceImpl<DepartmentRepository, Department, Long> implements DepartmentService {

  public DepartmentServiceImpl(DepartmentRepository repository) {
    super(repository);
  }


  @Override
  public Department create(Department entity)  {
    Optional.ofNullable(entity.getFirm()).orElseThrow(() -> new RuntimeException("Firm can not be null"));
    Optional.ofNullable(entity.getApartment()).orElseThrow(() -> new RuntimeException("Apartment can not be null"));

    return super.create(entity);
  }

}
