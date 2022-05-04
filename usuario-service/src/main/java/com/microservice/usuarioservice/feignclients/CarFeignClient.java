package com.microservice.usuarioservice.feignclients;

import com.microservice.usuarioservice.model.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//con esta anotación le indico que va a ser un cliente FeignClient
//(forma de comunicar microservices utilizando spring-cloud)
//dentro pongo el nombre del microservice y su url
//p/d es una interface porque se la va a implementar en service
@FeignClient(name = "cars-service",url = "http://localhost:8002")
//@RequestMapping("/car")
public interface CarFeignClient {
    @PostMapping()
    public Car save(@RequestBody Car car);
}
