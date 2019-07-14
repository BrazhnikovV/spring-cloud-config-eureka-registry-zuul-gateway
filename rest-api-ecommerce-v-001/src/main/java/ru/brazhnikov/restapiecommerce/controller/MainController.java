package ru.brazhnikov.restapiecommerce.controller;

import lombok.Setter;
import java.util.List;
import org.springframework.http.MediaType;
import ru.brazhnikov.restapiecommerce.entities.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import ru.brazhnikov.restapiecommerce.services.AccountService;

@Setter
@RestController
@RequestMapping( path = "/api/main", produces = MediaType.APPLICATION_JSON_VALUE)
public class MainController {

    /**
     *  @access private
     *  @var AccountService accountService - сервис для получения информации об акаунтах
     */
    @Autowired
    private AccountService accountService;

    @GetMapping( value = "/list/accounts", produces = "application/json" )
    public List<Account> list () {
        List<Account> accounts = this.accountService.getAllAccountsList();
        return  accounts;
    }

    @GetMapping( value = "/greeting", produces = "application/json" )
    public String greeting () {
        return  "Hello i am rest-api-ecommerce-v-001";
    }
}
