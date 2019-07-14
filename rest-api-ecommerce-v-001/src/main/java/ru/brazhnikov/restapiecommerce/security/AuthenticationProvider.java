package ru.brazhnikov.restapiecommerce.security;

import java.util.Optional;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import ru.brazhnikov.restapiecommerce.services.CustomerService;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;

/**
 * AuthenticationProvider - класс провайдер отвечает за поиск пользователя
 * на основе токена аутентификации, отправленного клиентом в заголовке.
 *
 * @version 1.0.1
 * @package ru.brazhnikov.restapiecommerce.security
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Data
@Component
public class AuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    /**
     * @access public
     * @var CustomerService customerService - сервис для работы с пользователями
     */
    @Autowired
    private CustomerService customerService;

    @Override
    protected void additionalAuthenticationChecks(
            UserDetails userDetails,
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken ) throws AuthenticationException {
        //
    }

    @Override
    protected UserDetails retrieveUser(
            String userName,
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken ) throws AuthenticationException {

        Object token = usernamePasswordAuthenticationToken.getCredentials();
        return Optional
                .ofNullable( token )
                .map( String::valueOf )
                .flatMap( this.customerService::findByToken )
                .orElseThrow( () -> new UsernameNotFoundException( "Cannot find user with authentication token = " + token ) );
    }
}
