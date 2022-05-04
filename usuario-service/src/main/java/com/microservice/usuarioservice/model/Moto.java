package com.microservice.usuarioservice.model;

import lombok.Data;

@Data
public class Moto {
    private String brand;
    private String model;

    //agrego atributo para usarlo en feignClient
    private Long userId;
}
