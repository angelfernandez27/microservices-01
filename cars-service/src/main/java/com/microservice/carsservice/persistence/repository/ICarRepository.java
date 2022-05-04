package com.microservice.carsservice.persistence.repository;
import com.microservice.carsservice.persistence.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarRepository extends JpaRepository<Car,Long> {
        List<Car> findByUserId(Long userId);
}
