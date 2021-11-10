package com.phexum.wf.infrastructure.firm.adapters.jpa.repository;

import com.phexum.wf.domain.firm.entity.Firm;
import com.phexum.wf.domain.firm.port.FirmRepository;
import com.phexum.wf.infrastructure.common.Convertible;
import com.phexum.wf.infrastructure.firm.adapters.jpa.entity.FirmEntity;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FirmJpaAdapter extends Convertible<Firm,FirmEntity> implements FirmRepository {

    private final FirmJpaRepository repository;

    public FirmJpaAdapter(FirmJpaRepository repository, ModelMapper mapper) {
        super(mapper,Firm.class,FirmEntity.class);
        this.repository = repository;
    }

    @Override
    public Optional<Firm> findById(Long id) {
/*
        Firm firm = new Firm();
        FirmEntity firmEntity = repository.findById(id).get();
        firm = mapper.map(firmEntity, Firm.class);

        return Optional.of(firm);
*/
        return repository.findById(id).map(x -> entityToModel(x));

    }

    @Override
    public List<Firm> findAll() {
      /*
        List<FirmEntity> firmEntity = repository.findAll();
        List<Firm> firm=new ArrayList<>();
        for (FirmEntity entity:firmEntity) {
            firm.add(mapper.map(entity,Firm.class));
        }
        return firm;
       */

        return repository.findAll().stream().map(x ->entityToModel(x)).collect(Collectors.toList());

    }

    @Override
    public Firm create(Firm firm) {
        FirmEntity entity =modelToEntity(firm);

        return entityToModel(repository.save(entity));
    }

    @Override
    public Firm update(Firm firm) {

        Optional<Firm> firmOp = findById(firm.getId());

        if (firmOp.isEmpty()) {
            return null;
        }
        else {
            return entityToModel(repository.save(modelToEntity(firm)));
        }
    }

    @Override
    public void delete(Firm firm) {
        FirmEntity entity = modelToEntity(firm);

        repository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);

    }
}
