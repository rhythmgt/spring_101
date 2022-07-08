package com.example.springAssignment.controller;

import com.example.springAssignment.model.Downtime;
import com.example.springAssignment.repository.DowntimeRepository;
import org.springframework.boot.autoconfigure.web.ServerProperties;
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

    @GetMapping("/getall")
    public ResponseEntity getAllDowntimes(){
        return ResponseEntity.ok(this.downtimeRepository.findAll());
    }

    @GetMapping("/getbyid")
    public ResponseEntity getDowntime(@RequestParam long id){
        Optional<Downtime> downtimes = this.downtimeRepository.findById(id);
        if (!downtimes.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.downtimeRepository.findById(id));
    }

    @PostMapping("/post")
    public ResponseEntity postDowntime(@RequestParam(name="provider") String provider, @RequestParam(name = "flow_name") String flow_name, @RequestBody Downtime p){
        p.setFlow(flow_name);
        p.setProvider(provider);
        Downtime d = this.downtimeRepository.save(p);
        URI loc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(d.getId()).toUri();
        return ResponseEntity.created(loc).build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteDowntime(@RequestParam(name = "id") Long id){
        this.downtimeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/put")
    public ResponseEntity modifyDowntime(@RequestParam(name = "id") Long id, @RequestParam(name="provider") String provider, @RequestParam(name = "flow_name") String flow_name, @RequestBody Downtime p){
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
