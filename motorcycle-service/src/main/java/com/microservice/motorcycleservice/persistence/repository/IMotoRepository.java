package com.microservice.motorcycleservice.persistence.repository;

import com.microservice.motorcycleservice.persistence.entity.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMotoRepository extends JpaRepository<Moto, Long> {
    List<Moto> findByUserId(Long userId);
}
