package com.microservice.carsservice.service;
import com.microservice.carsservice.persistence.entity.Car;
import com.microservice.carsservice.persistence.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private ICarRepository carRepository;

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public Car findById(Long id){
        return carRepository.findById(id)
                .orElseThrow();
    }

    public Car save(Car car){
        return carRepository.save(car);
    }

    public List<Car> findByUserId(Long userId){
        return  carRepository.findByUserId(userId);
    }
}
