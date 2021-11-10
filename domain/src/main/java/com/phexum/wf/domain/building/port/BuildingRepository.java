package com.phexum.wf.domain.building.port;

import java.util.Optional;
import com.phexum.wf.domain.building.entity.Building;
import com.phexum.wf.domain.common.BaseRepository;
import com.phexum.wf.domain.firm.entity.Firm;

public interface BuildingRepository extends BaseRepository<Building, Long> {

  Optional<Building> findByFirm(Firm firm);

}
