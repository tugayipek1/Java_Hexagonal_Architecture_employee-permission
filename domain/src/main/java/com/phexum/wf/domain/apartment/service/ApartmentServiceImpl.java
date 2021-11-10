package com.phexum.wf.domain.apartment.service;

import java.util.List;
import java.util.Optional;
import com.phexum.wf.domain.apartment.entity.Apartment;
import com.phexum.wf.domain.apartment.port.ApartmentRepository;
import com.phexum.wf.domain.apartment.port.ApartmentService;
import com.phexum.wf.domain.common.CrudServiceImpl;
import com.phexum.wf.domain.common.DomainComponent;

@DomainComponent
public class ApartmentServiceImpl extends CrudServiceImpl<ApartmentRepository, Apartment, Long> implements ApartmentService {

  public ApartmentServiceImpl(ApartmentRepository repository) {
    super(repository);
  }

  @Override
  public Apartment create(Apartment entity)  {
    Optional.ofNullable(entity.getFloor()).orElseThrow(() -> new RuntimeException("Floor can not be null"));
    Optional.ofNullable(entity.getNo()).orElseThrow(() -> new RuntimeException("Apartment number can not be null"));

    List<Apartment> apartments = repository.findByFloor(entity.getFloor());

    if (apartments.size() >= 4) {
      throw new RuntimeException("Floor already have max capacity");

    }

    return super.create(entity);
  }



}
