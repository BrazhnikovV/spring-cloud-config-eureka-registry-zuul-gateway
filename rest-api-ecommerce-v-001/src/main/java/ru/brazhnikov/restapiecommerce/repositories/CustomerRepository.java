package ru.brazhnikov.restapiecommerce.repositories;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import ru.brazhnikov.restapiecommerce.entities.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * CustomerRepository - Интерфейс репозитория для экземпляров Customer.
 * Обеспечивает основные операции CRUD за счет расширения CrudRepository.
 *
 * @version 1.0.1
 * @package ru.brazhnikov.restapiecommerce.repositories
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    /**
     * login - выполнить аутентификацию по имени и паролю
     * @param username
     * @param password
     * @return
     */
    @Query(value = "SELECT u FROM Customer u where u.username = ?1 and u.password = ?2 ")
    Optional<Customer> login( String username, String password );

    /**
     * findByToken - найти пользователя по токену
     * @param token
     * @return
     */
    Optional<Customer> findByToken( String token );

    /**
     * findByUsername -
     * @param username
     * @return
     */
    @Query(value = "SELECT u FROM Customer u where u.username = ?1")
    Optional<Customer> findByUsername( String username );
}
