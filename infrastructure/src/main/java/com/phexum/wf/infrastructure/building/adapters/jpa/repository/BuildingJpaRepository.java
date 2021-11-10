package com.phexum.wf.infrastructure.building.adapters.jpa.repository;

import com.phexum.wf.infrastructure.building.adapters.jpa.entity.BuildingEntity;
import com.phexum.wf.infrastructure.firm.adapters.jpa.entity.FirmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuildingJpaRepository extends JpaRepository<BuildingEntity, Long> {

    Optional<BuildingEntity> findByFirm(FirmEntity firmEntity);
}
