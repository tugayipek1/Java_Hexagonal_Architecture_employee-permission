package com.phexum.wf.infrastructure.apartment.adapters.jpa.repository;

import com.phexum.wf.infrastructure.apartment.adapters.jpa.entity.ApartmentEntity;
import com.phexum.wf.infrastructure.floor.adapters.jpa.entity.FloorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentJpaRepository extends JpaRepository<ApartmentEntity,Long> {
    List<ApartmentEntity> findByFloorEntity(FloorEntity floorEntity);

}
