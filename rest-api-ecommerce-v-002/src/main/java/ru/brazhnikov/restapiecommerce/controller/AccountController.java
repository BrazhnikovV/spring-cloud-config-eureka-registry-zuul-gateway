package ru.brazhnikov.restapiecommerce.controller;

import java.util.*;
import lombok.Setter;
import javax.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import ru.brazhnikov.restapiecommerce.entities.Account;
import ru.brazhnikov.restapiecommerce.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import ru.brazhnikov.restapiecommerce.exceptions.BaseExceptionHandler;

/**
 * AccountController - класс контроллер сущности акаунт
 *
 * @version 1.0.1
 * @package ru.brazhnikov.restapiecommerce.controller
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Setter
@RestController
@RequestMapping( path = "/api/accounts", produces = MediaType.APPLICATION_JSON_VALUE )
public class AccountController extends BaseExceptionHandler {

    /**
     *  @access private
     *  @var AccountService accountService - сервис для получения информации об акаунтах
     */
    @Autowired
    private AccountService accountService;

    @Secured({"ROLE_ADMIN"})
    @GetMapping( value = "/list" )
    public List<Account> list () {
        List<Account> accounts = this.accountService.getAllAccountsList();
        return  accounts;
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping( path = "/create", consumes = "application/json" )
    public Account create( @RequestBody @Valid Account account, BindingResult result ) {
        return  this.accountService.createAccount( account );
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/update/{id}")
    public Account update( @PathVariable String id, @RequestBody @Valid Account account ) {
        return this.accountService.updateAccount( account );
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/delete/{id}")
    public void delete( @PathVariable String id ) {
        this.accountService.deleteAccount( Long.valueOf(id) );
    }
}
