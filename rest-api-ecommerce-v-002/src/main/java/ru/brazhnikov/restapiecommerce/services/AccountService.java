package ru.brazhnikov.restapiecommerce.services;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.brazhnikov.restapiecommerce.entities.Account;
import ru.brazhnikov.restapiecommerce.repositories.AccountRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * AccountService - класс сервиса для работы с данными об акаунтах
 *
 * @version 1.0.1
 * @package ru.brazhnikov.services
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Setter
@Service
public class AccountService {

    /**
     *  @access private
     *  @var AccountRepository accountRepository - репозиторий акаунтов
     */
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EntityManager entityManager;

    /**
     * getAccountById -
     * @return List<Account>
     */
    public Optional<Account> getAccountById( Long id ) {
        return this.accountRepository.findById( id );
    }

    /**
     * getAllAccountsList - получить список акаунтов
     * @return List<Account>
     */
    public List<Account> getAllAccountsList() {
        return ( List<Account> ) this.accountRepository.findAll();
    }

    /**
     * createAccount - добавить акаунт
     * @return Account
     */
    public Account createAccount( Account account ) {
        return this.accountRepository.save( account );
    }

    /**
     * updateAccount - обновить акаунт
     * @param account
     * @return Account
     */
    @Transactional
    public Account updateAccount( Account account ) {
        return this.entityManager.merge( account);
    }

    /**
     * deleteAccount - удалить акаунт
     * @param id
     * @return void
     */
    public void deleteAccount( Long id ) {
        this.accountRepository.deleteById( id );
    }
}
