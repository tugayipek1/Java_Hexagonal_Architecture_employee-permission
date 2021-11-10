package com.phexum.wf.domain.floor.port;

import java.util.List;
import com.phexum.wf.domain.building.entity.Building;
import com.phexum.wf.domain.common.BaseRepository;
import com.phexum.wf.domain.floor.entity.Floor;

public interface FloorRepository extends BaseRepository<Floor, Long> {

  List<Floor> findByBuilding(Building building);

}
