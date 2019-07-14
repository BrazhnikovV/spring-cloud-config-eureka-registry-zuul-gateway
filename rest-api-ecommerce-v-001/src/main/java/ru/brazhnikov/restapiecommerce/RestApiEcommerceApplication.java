package ru.brazhnikov.restapiecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RestApiEcommerceApplication - стартовый класс приложения
 *
 * @version 1.0.1
 * @package ru.brazhnikov.restapiecommerce.entities
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@SpringBootApplication
@EnableEurekaClient
public class RestApiEcommerceApplication {

    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(RestApiEcommerceApplication.class, args);
    }
}
