package com.phexum.wf.infrastructure.log.adapters.jpa.repository;

import com.phexum.wf.infrastructure.log.adapters.jpa.entity.PermissionLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionLogJpaRepository extends JpaRepository<PermissionLogEntity,Long> {
}
