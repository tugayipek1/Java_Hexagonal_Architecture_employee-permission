package com.phexum.wf.infrastructure.employee.adapters.jpa.repository;

import com.phexum.wf.infrastructure.employee.adapters.jpa.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity,Long> {
}
