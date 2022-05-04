package com.microservice.usuarioservice.service;

import com.microservice.usuarioservice.feignclients.CarFeignClient;
import com.microservice.usuarioservice.model.Car;
import com.microservice.usuarioservice.model.Moto;
import com.microservice.usuarioservice.persistence.Entity.User;
import com.microservice.usuarioservice.persistence.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    //el cual fue previamente Beaneado a la configuración de spring
    @Autowired
    private RestTemplate restTemplate;

    //Inyecto el FeignClients creado
    @Autowired
    private CarFeignClient carFeignClient;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id)
                .orElseThrow();
    }

    public User save(User user){
        return userRepository.save(user);
    }

    //new métodos para los microservices

    //método para traer los cars asociados a este user
    public List<Car> findCars(Long userId){

        //creamos una lista que se va al método findCarsByUserId del microservice Car
        List<Car> cars=restTemplate.getForObject("http://localhost:8002/api/car/findCarByUserId/userId/"+userId,List.class);
        return cars;
    }

    //método para traer las motos asociados a este user
    public List<Moto> findMotos(Long userId){

        //creamos una lista que se va al método findMotoByUserId del microservice Motorcycle
        List<Moto> motos=restTemplate.getForObject("http://localhost:8083/api/moto/findMotoByUserId/userId/"+userId,List.class);
        return motos;
    }

    //metodos de Spring-Cloud FeignClient

    public Car saveCar(Long userId, Car car){
        //seteo el id del user
        car.setUserId(userId);
        //lo guardo
        Car carNew=carFeignClient.save(car);
        return carNew ;
    }
}
