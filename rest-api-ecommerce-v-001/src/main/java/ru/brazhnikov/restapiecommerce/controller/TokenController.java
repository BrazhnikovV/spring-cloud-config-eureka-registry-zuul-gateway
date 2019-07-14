package ru.brazhnikov.restapiecommerce.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.brazhnikov.restapiecommerce.services.CustomerService;

/**
 * TokenController - класс контроллер получения токена
 *
 * @version 1.0.1
 * @package ru.brazhnikov.restapiecommerce.controller
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@RestController
public class TokenController {

    /**
     * @access private
     * @var CustomerService customerService - репозиторий для экземпляров Customer
     */
    @Autowired
    private CustomerService customerService;

    @PostMapping("/token")
    public String getToken( @RequestParam( "username" ) final String username, @RequestParam( "password" ) final String password ) {

        String token = this.customerService.login( username, password );
        if( StringUtils.isEmpty( token ) ) {
            return "no token found";
        }
        return token;
    }
}
