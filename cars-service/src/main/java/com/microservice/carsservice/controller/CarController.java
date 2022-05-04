package com.microservice.carsservice.controller;

import com.microservice.carsservice.persistence.entity.Car;
import com.microservice.carsservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Car>> findAll(){
        if (carService.findAll().isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carService.findAll());
    }
    @GetMapping("/findById")
    public ResponseEntity<Car> findById(@RequestParam Long id){
        return ResponseEntity.ok(carService.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Car> save(@RequestBody Car car){
        return ResponseEntity.ok(carService.save(car));
    }

    @GetMapping("/findCarByUserId/userId/{userId}")
    public ResponseEntity<List<Car>> findCarByUserId(@PathVariable Long userId){
        if (carService.findByUserId(userId).isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carService.findByUserId(userId));
    }

}
