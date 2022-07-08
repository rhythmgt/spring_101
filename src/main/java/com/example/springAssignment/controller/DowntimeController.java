package com.example.springAssignment.controller;

import com.example.springAssignment.model.Downtime;
import com.example.springAssignment.repository.DowntimeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping
public class DowntimeController {

    private final DowntimeRepository downtimeRepository;

    public DowntimeController(DowntimeRepository downtimeRepository) {
        this.downtimeRepository = downtimeRepository;
    }

    @GetMapping("/get-all-downtimes")
    public ResponseEntity getAllDowntimes(){
        return ResponseEntity.ok(this.downtimeRepository.findAll());
    }

    @GetMapping("/get-downtime/{id}")
    public ResponseEntity getDowntime(@PathVariable Long id){
        Optional<Downtime> downtimes = this.downtimeRepository.findById(id);
        if (!downtimes.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(downtimes.get());
    }

    @PostMapping("/create-downtime")
    public ResponseEntity postDowntime(@RequestParam(name="provider") String provider, @RequestParam(name = "flow_name") String flow_name, @RequestBody Downtime p){
        p.setFlow(flow_name);
        p.setProvider(provider);
        Downtime d = this.downtimeRepository.save(p);
        return ResponseEntity.ok("created sid: "+ d.getId());
    }

    @DeleteMapping("/delete-downtime/{id}")
    public ResponseEntity deleteDowntime(@PathVariable Long id){
        this.downtimeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update-downtime/{id}")
    public ResponseEntity modifyDowntime(@PathVariable Long id, @RequestParam(name="provider") String provider, @RequestParam(name = "flow_name") String flow_name, @RequestBody Downtime p){
        Optional<Downtime> downtimes = this.downtimeRepository.findById(id);
        if (!downtimes.isPresent()){
            return ResponseEntity.notFound().build();
        }
        p.setId(id);
        p.setFlow(flow_name);
        p.setProvider(provider);
        this.downtimeRepository.save(p);
        return ResponseEntity.noContent().build();
    }

}
