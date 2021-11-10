package com.phexum.wf.infrastructure.firm.adapters.jpa.repository;

import com.phexum.wf.infrastructure.firm.adapters.jpa.entity.FirmEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirmJpaRepository extends JpaRepository<FirmEntity,Long>{

}
