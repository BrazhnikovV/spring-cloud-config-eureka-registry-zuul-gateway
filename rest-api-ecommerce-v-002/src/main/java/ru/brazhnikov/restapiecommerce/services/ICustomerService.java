package ru.brazhnikov.restapiecommerce.services;

import java.util.Optional;
import ru.brazhnikov.restapiecommerce.entities.Customer;
import org.springframework.security.core.userdetails.User;

/**
 * IUserService - интерфейс сервиса для экземпляров Customer,
 * !!!Fixme а также экземпляра User в методе findByToken
 *
 * @version 1.0.1
 * @package ru.brazhnikov.restapiecommerce.services
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
public interface ICustomerService {

    /**
     * login - выполнить аутентификацию по имени и паролю
     * @param username
     * @param password
     * @return
     */
    String login( String username, String password );

    /**
     * findByToken - найти пользователя по токену
     * @param token
     * @return
     */
    Optional<User> findByToken( String token );

    /**
     * findById - найти пользователя по идентификаору
     * @param id
     * @return
     */
    Customer findById( Long id );
}
