package com.phexum.wf.infrastructure.employee.adapters.jpa.repository;

import com.phexum.wf.domain.employee.entity.Employee;
import com.phexum.wf.domain.employee.port.EmployeeRepository;
import com.phexum.wf.domain.employee.port.EmployeeService;
import com.phexum.wf.infrastructure.common.Convertible;
import com.phexum.wf.infrastructure.employee.adapters.jpa.entity.EmployeeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeJpaAdapter extends Convertible<Employee, EmployeeEntity> implements EmployeeRepository {

    private final EmployeeJpaRepository repository;

    public EmployeeJpaAdapter(EmployeeJpaRepository repository, ModelMapper mapper) {
        super(mapper,Employee.class,EmployeeEntity.class);
        this.repository = repository;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return repository.findById(id).map(x->entityToModel(x));
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll().stream().map(x->entityToModel(x)).collect(Collectors.toList());
    }

    @Override
    public Employee create(Employee employee) {
        return entityToModel(repository.save(modelToEntity(employee)));
    }

    @Override
    public Employee update(Employee employee) {
        if (repository.findById(employee.getId()).isEmpty())
        {
            return null;
        }
        else
        {
            return entityToModel(repository.save(modelToEntity(employee)));
        }
    }

    @Override
    public void delete(Employee employee) {
        repository.delete(modelToEntity(employee));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
