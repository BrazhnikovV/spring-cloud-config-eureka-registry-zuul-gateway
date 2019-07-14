package ru.brazhnikov.restapiecommerce.repositories;

import org.springframework.stereotype.Repository;
import ru.brazhnikov.restapiecommerce.entities.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * AccountRepository - интерфейс сервиса для экземпляров Account,
 *
 * @version 1.0.1
 * @package ru.brazhnikov.repositories
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

}
