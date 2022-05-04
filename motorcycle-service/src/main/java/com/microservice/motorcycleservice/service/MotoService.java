package com.microservice.motorcycleservice.service;

import com.microservice.motorcycleservice.persistence.entity.Moto;
import com.microservice.motorcycleservice.persistence.repository.IMotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {
    @Autowired
    private IMotoRepository motoRepository;

    public List<Moto> findAll(){
        return motoRepository.findAll();
    }

    public Moto findById(Long id){
        return motoRepository.findById(id)
                .orElseThrow();
    }

    public Moto save(Moto moto){
        return motoRepository.save(moto);
    }

    public List<Moto> findByUserId(Long motoId){
        return  motoRepository.findByUserId(motoId);
    }
}
