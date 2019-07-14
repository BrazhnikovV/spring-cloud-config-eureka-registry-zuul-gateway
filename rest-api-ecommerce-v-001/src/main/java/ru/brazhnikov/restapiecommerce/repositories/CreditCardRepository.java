package ru.brazhnikov.restapiecommerce.repositories;

import org.springframework.stereotype.Repository;
import ru.brazhnikov.restapiecommerce.entities.CreditCard;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * CreditCardRepository - интерфейс сервиса для экземпляров CreditCardRepository,
 *
 * @version 1.0.1
 * @package ru.brazhnikov.repositories
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Repository
public interface CreditCardRepository extends PagingAndSortingRepository<CreditCard, Long> {

}
