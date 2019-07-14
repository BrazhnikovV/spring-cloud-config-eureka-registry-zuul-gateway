package ru.brazhnikov.restapiecommerce.repositories;

import org.springframework.stereotype.Repository;
import ru.brazhnikov.restapiecommerce.entities.Address;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * AddressRepository - интерфейс сервиса для экземпляров Address,
 *
 * @version 1.0.1
 * @package ru.brazhnikov.repositories
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

}
