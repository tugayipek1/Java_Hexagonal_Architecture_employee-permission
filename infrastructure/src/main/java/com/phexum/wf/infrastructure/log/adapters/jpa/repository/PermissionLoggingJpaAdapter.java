package com.phexum.wf.infrastructure.log.adapters.jpa.repository;

import com.phexum.wf.domain.floor.entity.Floor;
import com.phexum.wf.domain.log.entity.PermissionLog;
import com.phexum.wf.domain.log.port.PermissionLogRepository;
import com.phexum.wf.domain.log.port.PermissionLoggingService;
import com.phexum.wf.infrastructure.common.Convertible;
import com.phexum.wf.infrastructure.floor.adapters.jpa.entity.FloorEntity;
import com.phexum.wf.infrastructure.floor.adapters.jpa.repository.FloorJpaRepository;
import com.phexum.wf.infrastructure.log.adapters.jpa.entity.PermissionLogEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PermissionLoggingJpaAdapter extends Convertible<PermissionLog, PermissionLogEntity> implements PermissionLogRepository {
    private final PermissionLogJpaRepository repository;

    public PermissionLoggingJpaAdapter(PermissionLogJpaRepository repository, ModelMapper mapper) {
        super(mapper, PermissionLog.class, PermissionLogEntity.class);
        this.repository = repository;

    }

    @Override
    public Optional<PermissionLog> findById(Long id) {
        return repository.findById(id).map(x -> entityToModel(x));
    }

    @Override
    public List<PermissionLog> findAll() {
        return repository.findAll().stream().map(x -> entityToModel(x)).collect(Collectors.toList());
    }

    @Override
    public PermissionLog create(PermissionLog permissionLog) {
        return entityToModel(repository.save(modelToEntity(permissionLog)));

    }

    @Override
    public PermissionLog update(PermissionLog permissionLog) {
        if (repository.findById(permissionLog.getId()).isEmpty()) {
            return null;
        } else {
            return entityToModel(repository.save(modelToEntity(permissionLog)));
        }
    }

    @Override
    public void delete(PermissionLog permissionLog) {
        repository.delete(modelToEntity(permissionLog));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
