package com.microservice.usuarioservice.controller;

import com.microservice.usuarioservice.model.Car;
import com.microservice.usuarioservice.model.Moto;
import com.microservice.usuarioservice.persistence.Entity.User;
import com.microservice.usuarioservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll(){
        if (userService.findAll().isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userService.findAll());
    }
    @GetMapping("/findById")
    public ResponseEntity<User> findById(@RequestParam Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.ok(userService.save(user));
    }

    //métodos de microservices

    @GetMapping("/cars/{userId}")
    public ResponseEntity<List<Car>> findCars(@PathVariable("userId") Long userId){
        if (userService.findCars(userId).isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userService.findCars(userId));
    }

    @GetMapping("/motos/{userId}")
    public ResponseEntity<List<Moto>> findMotos(@PathVariable("userId") Long userId){
        if (userService.findMotos(userId).isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userService.findMotos(userId));
    }

    //métodos de Spring-Cloud FeignClient

    @PostMapping("/car/{userId}")
    public ResponseEntity<Car> save(@PathVariable("userId") Long userId, @RequestBody Car car){
        Car carNew=userService.saveCar(userId,car);
        return ResponseEntity.ok(carNew);
    }

}
