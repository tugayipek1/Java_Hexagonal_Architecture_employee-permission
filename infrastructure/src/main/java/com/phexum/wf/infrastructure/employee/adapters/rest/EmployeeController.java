package com.phexum.wf.infrastructure.employee.adapters.rest;

import com.phexum.wf.domain.employee.entity.Employee;
import com.phexum.wf.domain.employee.port.EmployeeService;
import com.phexum.wf.domain.employee.usecase.EmployeeApartmentEnter;
import com.phexum.wf.domain.employee.usecase.EmployeeFloorEnter;
import com.phexum.wf.infrastructure.common.BaseController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends BaseController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/enter/apartment")
    public ResponseEntity<?> EmployeeEnterApartment(@RequestBody EmployeeApartmentEnter usecase) {
        handle(usecase);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/enter/floor")
    public ResponseEntity<?> EmployeeEnterFloor(@RequestBody EmployeeFloorEnter usecase) {
        handle(usecase);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {

        Optional<Employee> op = employeeService.findById(id);

        if (op.isPresent()) {
            return ResponseEntity.ok(op.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.create(employee));
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.update(employee));
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Employee employee) {
        employeeService.delete(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
    }

}
