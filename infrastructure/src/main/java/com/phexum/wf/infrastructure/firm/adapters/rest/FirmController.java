package com.phexum.wf.infrastructure.firm.adapters.rest;

import com.phexum.wf.domain.building.entity.Building;
import com.phexum.wf.domain.firm.entity.Firm;
import com.phexum.wf.domain.firm.port.FirmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/firm")
@RestController
public class FirmController {

    private final FirmService firmService;

    public FirmController(FirmService firmService) {
        this.firmService = firmService;
    }

    @PostMapping("/create")
    public ResponseEntity<Firm> create(@RequestBody Firm firm) {

        return ResponseEntity.ok(firmService.create(firm));
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Firm entity) {
        firmService.delete(entity);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Firm>> findAll() {
        return ResponseEntity.ok(firmService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Firm> findById(@PathVariable long id) {
        Optional<Firm> op = firmService.findById(id);
        if (op.isPresent()) {
            return ResponseEntity.ok(op.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/update")
    public ResponseEntity<Firm> update(@RequestBody Firm firm) {
        return ResponseEntity.ok(firmService.update(firm));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        firmService.deleteById(id);

    }
}
