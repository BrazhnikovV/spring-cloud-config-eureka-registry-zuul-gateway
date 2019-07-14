package ru.brazhnikov.restapiecommerce.services;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.brazhnikov.restapiecommerce.entities.Account;
import ru.brazhnikov.restapiecommerce.entities.CreditCard;
import ru.brazhnikov.restapiecommerce.repositories.AccountRepository;
import ru.brazhnikov.restapiecommerce.repositories.CreditCardRepository;

import java.util.List;
import java.util.Optional;

/**
 * CreditCardService - класс сервиса для работы с данными о кредитных картах
 *
 * @version 1.0.1
 * @package ru.brazhnikov.services
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Setter
@Service
public class CreditCardService {

    /**
     *  @access private
     *  @var CreditCardRepository creditCardRepository - репозиторий кредитных карт
     */
    @Autowired
    private CreditCardRepository creditCardRepository;

    /**
     * getCreditCardById - получить кредитную карту по идентификатору
     * @return List<CreditCard>
     */
    public Optional<CreditCard> getCreditCardById( Long id ) {
        return this.creditCardRepository.findById( id );
    }

    /**
     * getAllCreditCardList - получить список кредитных карт
     * @return List<CreditCard>
     */
    public List<CreditCard> getAllCreditCardList() {
        return ( List<CreditCard> ) this.creditCardRepository.findAll();
    }

    /**
     * createCreditCard - добавить кредитную карту
     * @return CreditCard
     */
    public CreditCard createCreditCard( CreditCard creditCard ) {
        return this.creditCardRepository.save( creditCard );
    }

    /**
     * updateCreditCard - обновить кредитную карту
     * @param creditCard
     * @return CreditCard
     */
    public CreditCard updateCreditCard( CreditCard creditCard ) {
        return this.creditCardRepository.save( creditCard);
    }

    /**
     * deleteCreditCard - удалить кредитную карту
     * @param id
     * @return void
     */
    public void deleteCreditCard( Long id ) {
        this.creditCardRepository.deleteById( id );
    }
}
