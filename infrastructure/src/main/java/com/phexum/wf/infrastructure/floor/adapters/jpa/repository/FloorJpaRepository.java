package com.phexum.wf.infrastructure.floor.adapters.jpa.repository;

import com.phexum.wf.infrastructure.building.adapters.jpa.entity.BuildingEntity;
import com.phexum.wf.infrastructure.floor.adapters.jpa.entity.FloorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorJpaRepository extends JpaRepository<FloorEntity,Long> {
    List<FloorEntity> findByBuildingEntity(BuildingEntity buildingEntity);
}
