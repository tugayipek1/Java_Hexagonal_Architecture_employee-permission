package com.phexum.wf.infrastructure.apartment.adapters.rest;


import com.phexum.wf.domain.apartment.entity.Apartment;
import com.phexum.wf.domain.apartment.port.ApartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/apartment")
@RestController
public class ApartmentController {
    private final ApartmentService apartmentService;

    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apartment> findById(@PathVariable Long id) {
        Optional<Apartment> op = apartmentService.findById(id);
        if (op.isPresent()) {
            return ResponseEntity.ok(op.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/list")
    public ResponseEntity<List<Apartment>> findAll() {
        return ResponseEntity.ok(apartmentService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Apartment> create(@RequestBody Apartment apartment) {
        return ResponseEntity.ok(apartmentService.create(apartment));

    }

    @PutMapping("/update")
    public ResponseEntity<Apartment> update(@RequestBody Apartment apartment) {
        return ResponseEntity.ok(apartmentService.update(apartment));
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Apartment apartment) {
        apartmentService.delete(apartment);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {

            apartmentService.deleteById(id);

    }

}
