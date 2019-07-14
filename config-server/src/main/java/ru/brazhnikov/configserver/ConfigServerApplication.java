package ru.brazhnikov.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ConfigServerApplication - главный класс сервера конфигураций микросервисов.
 * Хранит конфигурации для всех служб в одном месте.
 *
 * @version 1.0.1
 * @package ru.brazhnikov.configserver
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}
