package com.phexum.wf.infrastructure.apartment.adapters.jpa.repository;

import com.phexum.wf.domain.apartment.entity.Apartment;
import com.phexum.wf.domain.apartment.port.ApartmentRepository;
import com.phexum.wf.domain.floor.entity.Floor;
import com.phexum.wf.infrastructure.apartment.adapters.jpa.entity.ApartmentEntity;
import com.phexum.wf.infrastructure.common.Convertible;
import com.phexum.wf.infrastructure.floor.adapters.jpa.entity.FloorEntity;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApartmentJpaAdapter extends Convertible<Apartment,ApartmentEntity> implements ApartmentRepository {
    private final ApartmentJpaRepository repository;


    public ApartmentJpaAdapter(ApartmentJpaRepository repository, ModelMapper mapper) {
        super(mapper,Apartment.class,ApartmentEntity.class);
        this.repository = repository;

    }


    @Override
    public List<Apartment> findByFloor(Floor floor) {

        return repository.findByFloorEntity(independentMapper(floor,FloorEntity.class))
                .stream()
                .map(x -> entityToModel(x))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Apartment> findById(Long id) {

        return repository.findById(id).map(x -> entityToModel(x));
    }

    @Override
    public List<Apartment> findAll() {
        return repository.findAll()
                .stream()
                .map(x -> entityToModel(x))
                .collect(Collectors.toList());
    }

    @Override

    public Apartment create(Apartment apartment) {
        return entityToModel(repository.save(modelToEntity(apartment)));
    }

    @Override

    public Apartment update(Apartment apartment) {
        if (repository.findById(apartment.getId()).isPresent()) {
            //return mapper.map(repository.save(mapper.map(apartment, ApartmentEntity.class)),Apartment.class);

            return create(apartment);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Apartment apartment) {

        repository.delete(modelToEntity(apartment));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);

    }
}
