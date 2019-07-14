package ru.brazhnikov.restapiecommerce.controller;

import ru.brazhnikov.restapiecommerce.entities.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.brazhnikov.restapiecommerce.services.CustomerService;

/**
 * UserProfileController - класс контроллер получения информации о пользователях
 *
 * @version 1.0.1
 * @package ru.brazhnikov.restapiecommerce.controller
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    @Autowired
    private CustomerService customerService;

    @Secured({"ROLE_ADMIN"})
    @GetMapping( value = "/user/{id}", produces = "application/json" )
    public Customer getUserDetail( @PathVariable Long id ) {
        return this.customerService.findById( id );
    }
}
