package com.phexum.wf.infrastructure.department.adapters.jpa.repository;

import com.phexum.wf.infrastructure.department.adapters.jpa.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface DepartmentJpaRepository extends JpaRepository<DepartmentEntity, Long> {

}
