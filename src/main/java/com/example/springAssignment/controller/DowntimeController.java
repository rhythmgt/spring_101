package com.example.springAssignment.controller;

import com.example.springAssignment.model.Downtime;
import com.example.springAssignment.repository.DowntimeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/post")
    public ResponseEntity postDowntime(@RequestParam(name="provider") String provider, @RequestParam(name = "flow_name") String flow_name, @RequestBody Downtime p){
        p.setFlow(flow_name);
        p.setProvider(provider);
        return ResponseEntity.ok(this.downtimeRepository.save(p));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteDowntime(@RequestParam long id){
        this.downtimeRepository.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }

}
