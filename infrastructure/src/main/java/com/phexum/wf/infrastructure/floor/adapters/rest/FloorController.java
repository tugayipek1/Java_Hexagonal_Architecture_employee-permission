package com.phexum.wf.infrastructure.floor.adapters.rest;

import com.phexum.wf.domain.firm.entity.Firm;
import com.phexum.wf.domain.floor.entity.Floor;
import com.phexum.wf.domain.floor.port.FloorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/floor")
@RestController
public class FloorController {
    private final FloorService floorService;

    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Floor> findById(@PathVariable Long id) {
        Optional<Floor> op = floorService.findById(id);
        if (op.isPresent()) {
            return ResponseEntity.ok(op.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/list")
    public ResponseEntity<List<Floor>> findAll() {
        return ResponseEntity.ok(floorService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Floor> create(@RequestBody Floor floor) {
        return ResponseEntity.ok(floorService.create(floor));
    }

    @PutMapping("/update")
    public ResponseEntity<Floor> update(@RequestBody Floor floor) {
        return ResponseEntity.ok(floorService.update(floor));
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Floor floor) {
        floorService.delete(floor);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {

        floorService.deleteById(id);

    }
}
