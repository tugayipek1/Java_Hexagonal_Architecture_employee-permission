package com.phexum.wf.infrastructure.building.adapters.rest;


import com.phexum.wf.domain.apartment.entity.Apartment;
import com.phexum.wf.domain.building.entity.Building;
import com.phexum.wf.domain.building.port.BuildingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/building")
@RestController
public class BuildingController {

    private BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @PostMapping("/create")
    public Building create(@RequestBody Building building) {

        return buildingService.create(building);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Building> findById(@PathVariable Long id) {
        Optional<Building> op = buildingService.findById(id);
        if (op.isPresent()) {
            return ResponseEntity.ok(op.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/list")
    public ResponseEntity<List<Building>> findAll() {
        return ResponseEntity.ok(buildingService.findAll());
    }

    @PutMapping("/update")
    public ResponseEntity<Building> update(@RequestBody Building building) {
        return ResponseEntity.ok(buildingService.update(building));
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Building building) {
        buildingService.delete(building);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {

            buildingService.deleteById(id);
    }
}
