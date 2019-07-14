package ru.brazhnikov.registryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * RegistryServerApplication - главный класс сервера реестра.
 * Выступает в качестве адресной книги для всех компонентов распределенной системы.
 *
 * @version 1.0.1
 * @package ru.brazhnikov.registryserver
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@EnableEurekaServer
@SpringBootApplication
public class RegistryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistryServerApplication.class, args);
    }

}
