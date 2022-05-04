package com.microservice.usuarioservice.model;

import lombok.Data;

@Data
public class Car {
    private String brand;
    private String model;

    //agrego atributo para usarrlo en feignClient
    private Long userId;
}
