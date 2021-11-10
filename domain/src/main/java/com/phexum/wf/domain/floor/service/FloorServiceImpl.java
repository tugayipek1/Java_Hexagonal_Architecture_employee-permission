package com.phexum.wf.domain.floor.service;

import java.util.List;
import java.util.Optional;
import com.phexum.wf.domain.common.CrudServiceImpl;
import com.phexum.wf.domain.common.DomainComponent;
import com.phexum.wf.domain.floor.entity.Floor;
import com.phexum.wf.domain.floor.port.FloorRepository;
import com.phexum.wf.domain.floor.port.FloorService;


@DomainComponent
public class FloorServiceImpl extends CrudServiceImpl<FloorRepository, Floor, Long> implements FloorService {

  public FloorServiceImpl(FloorRepository repository) {
    super(repository);
  }


  @Override
  public Floor create(Floor entity) {
    Optional.ofNullable(entity.getBuilding()).orElseThrow(() -> new RuntimeException("Building can not be null"));

    List<Floor> floors = this.repository.findByBuilding(entity.getBuilding());


    if (floors.size() >= 5) {
      throw new RuntimeException("Building should have max 5 floor");
    }


    return this.repository.create(entity);
  }
}
