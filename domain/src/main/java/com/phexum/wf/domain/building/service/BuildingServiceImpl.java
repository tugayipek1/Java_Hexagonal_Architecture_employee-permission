package com.phexum.wf.domain.building.service;

import java.util.Optional;
import com.phexum.wf.domain.building.entity.Building;
import com.phexum.wf.domain.building.port.BuildingRepository;
import com.phexum.wf.domain.building.port.BuildingService;
import com.phexum.wf.domain.common.CrudServiceImpl;
import com.phexum.wf.domain.common.DomainComponent;

@DomainComponent
public class BuildingServiceImpl extends CrudServiceImpl<BuildingRepository, Building, Long> implements BuildingService {

  public BuildingServiceImpl(BuildingRepository repository) {
    super(repository);
  }

  @Override
  public Building create(Building entity) {
    Optional.ofNullable(entity.getAddress()).orElseThrow(() -> new RuntimeException("Address can not be null"));

    Optional<Building> buildingOp = repository.findByFirm(entity.getFirm());

    if (buildingOp.isPresent()) {
      throw new RuntimeException("Firm already have a building");

    }

    return super.create(entity);
  }


}
