package com.phexum.wf.infrastructure.department.adapters.rest;

import com.phexum.wf.domain.department.entity.Department;
import com.phexum.wf.domain.department.port.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findById(@PathVariable Long id) {
        Optional<Department> op = service.findById(id);
        if (op.isPresent()) {
            return ResponseEntity.ok(op.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Department>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Department> create(@RequestBody Department department) {
        return ResponseEntity.ok(service.create(department));
    }

    @PutMapping("/update")
    public ResponseEntity<Department> update(@RequestBody Department department) {
        return ResponseEntity.ok(service.update(department));
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Department department) {
        service.delete(department);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
