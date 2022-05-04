package com.microservice.motorcycleservice.controller;

import com.microservice.motorcycleservice.persistence.entity.Moto;
import com.microservice.motorcycleservice.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moto")
public class MotoController {
    @Autowired
    private MotoService motoService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Moto>> findAll(){
        if (motoService.findAll().isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motoService.findAll());
    }
    @GetMapping("/findById")
    public ResponseEntity<Moto> findById(@RequestParam Long id){
        return ResponseEntity.ok(motoService.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Moto> save(@RequestBody Moto moto){
        return ResponseEntity.ok(motoService.save(moto));
    }

    @GetMapping("/findMotoByUserId/userId/{userId}")
    public ResponseEntity<List<Moto>> findMotoByUserId(@PathVariable Long userId){
        if (motoService.findByUserId(userId).isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motoService.findByUserId(userId));
    }
}
