package com.phexum.wf.infrastructure.building.adapters.jpa.repository;

import com.phexum.wf.domain.building.entity.Building;
import com.phexum.wf.domain.building.port.BuildingRepository;
import com.phexum.wf.domain.firm.entity.Firm;
import com.phexum.wf.infrastructure.building.adapters.jpa.entity.BuildingEntity;
import com.phexum.wf.infrastructure.common.Convertible;
import com.phexum.wf.infrastructure.firm.adapters.jpa.entity.FirmEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BuildingJpaAdapter extends Convertible<Building, BuildingEntity> implements BuildingRepository {

    private final BuildingJpaRepository repository;

    public BuildingJpaAdapter(BuildingJpaRepository repository, ModelMapper mapper) {
        super(mapper, Building.class, BuildingEntity.class);
        this.repository = repository;

    }

    @Override
    public Optional<Building> findByFirm(Firm firm) {

        return repository.findByFirm(independentMapper(firm,FirmEntity.class)).map(x -> entityToModel(x));
    }

    @Override
    public Optional<Building> findById(Long id) {
        return repository.findById(id).map(x -> entityToModel(x));
    }

    @Override
    public List<Building> findAll() {
        return repository.findAll().stream().map(x -> entityToModel(x)).collect(Collectors.toList());
    }

    @Override
    public Building create(Building building) {
        /* BuildingEntity y = mapper.map(building , BuildingEntity.class);
        Building x =  mapper.map(repository.save(y), Building.class);
        return x; */
        return entityToModel(repository.save(modelToEntity(building)));
    }

    @Override
    public Building update(Building building) {

        Optional<Building> buildingOp = findById(building.getId());

        if (buildingOp.isEmpty()) {
            return null;
        } else {
            return entityToModel(repository.save(modelToEntity(building)));
        }
    }

    @Override
    public void delete(Building building) {
        repository.delete(modelToEntity(building));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
