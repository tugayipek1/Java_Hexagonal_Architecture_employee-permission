package com.phexum.wf.infrastructure.log.adapters.rest;

import com.phexum.wf.domain.log.entity.PermissionLog;
import com.phexum.wf.domain.log.port.PermissionLoggingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {

    private final PermissionLoggingService service;

    public LogController(PermissionLoggingService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<List<PermissionLog>> list(){
        return ResponseEntity.ok(service.findAll());
    }
}
