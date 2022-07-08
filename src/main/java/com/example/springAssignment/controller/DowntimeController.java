package com.example.springAssignment.controller;

import com.example.springAssignment.repository.DowntimeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get-downtimes")
public class DowntimeController {

    private final DowntimeRepository downtimeRepository;

    public DowntimeController(DowntimeRepository downtimeRepository) {
        this.downtimeRepository = downtimeRepository;
    }

    @GetMapping
    public ResponseEntity getAllProducts(){
        return ResponseEntity.ok(this.downtimeRepository.findAll());
    }
}
