package com.phexum.wf.infrastructure.department.adapters.jpa.repository;

import com.phexum.wf.domain.department.entity.Department;
import com.phexum.wf.domain.department.port.DepartmentRepository;
import com.phexum.wf.infrastructure.common.Convertible;
import com.phexum.wf.infrastructure.department.adapters.jpa.entity.DepartmentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentJpaAdapter extends Convertible<Department,DepartmentEntity> implements DepartmentRepository {
    private final DepartmentJpaRepository repository;

    public DepartmentJpaAdapter(DepartmentJpaRepository repository, ModelMapper mapper) {
        super(mapper,Department.class,DepartmentEntity.class);
        this.repository = repository;

    }

    @Override
    public Optional<Department> findById(Long id) {
        return repository.findById(id).map(x ->entityToModel(x));
    }

    @Override
    public List<Department> findAll() {
        return repository.findAll().stream().map(x ->entityToModel(x)).collect(Collectors.toList());
    }

    @Override
    public Department create(Department department) {
        return entityToModel(repository.save(modelToEntity(department)));
    }

    @Override
    public Department update(Department department) {
        if (repository.findById(department.getId()).isEmpty()) {
            return null;
        } else {
            return entityToModel(repository.save(modelToEntity(department)));
        }
    }

    @Override
    public void delete(Department department) {
          repository.delete(modelToEntity(department));
    }

    @Override
    public void deleteById(Long id) {
          repository.deleteById(id);
    }
}
