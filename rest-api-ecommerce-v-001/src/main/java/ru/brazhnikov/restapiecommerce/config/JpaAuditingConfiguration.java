package ru.brazhnikov.restapiecommerce.config;

import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * JpaAuditingConfiguration - конфигурационный класс настройки аудита таблиц сущностей
 *
 * @version 1.0.1
 * @package ru.brazhnikov.restapiecommerce.config
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfiguration {

    @Bean
    public AuditorAware<String> auditorProvider() {

        /*
          if you are using spring security, you can get the currently logged username with following code segment.
          SecurityContextHolder.getContext().getAuthentication().getName()
         */
        return () -> Optional.ofNullable("chathuranga");
    }
}
