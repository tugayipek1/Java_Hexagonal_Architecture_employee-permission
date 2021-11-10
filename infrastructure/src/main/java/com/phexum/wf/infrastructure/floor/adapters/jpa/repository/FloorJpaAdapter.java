package com.phexum.wf.infrastructure.floor.adapters.jpa.repository;

import com.phexum.wf.domain.building.entity.Building;
import com.phexum.wf.domain.floor.entity.Floor;
import com.phexum.wf.domain.floor.port.FloorRepository;
import com.phexum.wf.infrastructure.building.adapters.jpa.entity.BuildingEntity;
import com.phexum.wf.infrastructure.common.Convertible;
import com.phexum.wf.infrastructure.floor.adapters.jpa.entity.FloorEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FloorJpaAdapter extends Convertible<Floor, FloorEntity> implements FloorRepository {

    private final FloorJpaRepository repository;

    public FloorJpaAdapter(FloorJpaRepository repository, ModelMapper mapper) {
        super(mapper, Floor.class, FloorEntity.class);
        this.repository = repository;

    }

    @Override
    public List<Floor> findByBuilding(Building building) {
        return repository.findByBuildingEntity(independentMapper(building, BuildingEntity.class))
                .stream()
                .map(x -> entityToModel(x)).collect(Collectors.toList());
    }

    @Override
    public Optional<Floor> findById(Long id) {
        return repository.findById(id).map(x -> entityToModel(x));
    }

    @Override
    public List<Floor> findAll() {
        return repository.findAll().stream().map(x -> entityToModel(x)).collect(Collectors.toList());
    }

    @Override
    public Floor create(Floor floor) {
        return entityToModel(repository.save(modelToEntity(floor)));
    }

    @Override
    public Floor update(Floor floor) {

        if (repository.findById(floor.getId()).isEmpty()) {
            return null;
        } else {
            return entityToModel(repository.save(modelToEntity(floor)));
        }
    }

    @Override
    public void delete(Floor floor) {
        repository.delete(modelToEntity(floor));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
