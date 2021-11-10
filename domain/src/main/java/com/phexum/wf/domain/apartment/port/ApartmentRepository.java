package com.phexum.wf.domain.apartment.port;

import java.util.List;
import com.phexum.wf.domain.apartment.entity.Apartment;
import com.phexum.wf.domain.common.BaseRepository;
import com.phexum.wf.domain.floor.entity.Floor;

public interface ApartmentRepository extends BaseRepository<Apartment, Long> {

  List<Apartment> findByFloor(Floor floor);

}
