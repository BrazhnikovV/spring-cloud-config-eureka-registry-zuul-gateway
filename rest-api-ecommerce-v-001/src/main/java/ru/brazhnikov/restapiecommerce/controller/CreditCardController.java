package ru.brazhnikov.restapiecommerce.controller;

import lombok.Setter;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.brazhnikov.restapiecommerce.entities.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import ru.brazhnikov.restapiecommerce.services.CreditCardService;

/**
 * CreditCardController - класс контроллер сущности кредитная карта
 *
 * @version 1.0.1
 * @package ru.brazhnikov.restapiecommerce.controller
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Setter
@RestController
@RequestMapping( path = "/api/cards", produces = MediaType.APPLICATION_JSON_VALUE )
public class CreditCardController {

    /**
     *  @access private
     *  @var AccountService accountService - сервис для получения информации об акаунтах
     */
    @Autowired
    private CreditCardService creditCardService;

    @Secured({"ROLE_ADMIN"})
    @GetMapping( value = "/list" )
    public List<CreditCard> list () {
        List<CreditCard> creditCards = this.creditCardService.getAllCreditCardList();
        return  creditCards;
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping( path = "/create", consumes = "application/json" )
    public CreditCard create( @RequestBody CreditCard creditCard ) {
        return  this.creditCardService.createCreditCard( creditCard );
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/update/{id}")
    public CreditCard update( @PathVariable String id, @RequestBody CreditCard creditCard ) {

        Optional<CreditCard> optionalCreditCard = this.creditCardService.getCreditCardById( Long.valueOf( id ) );
        CreditCard currentCreditCard = optionalCreditCard.get();
        if( !StringUtils.isEmpty( creditCard.getNumber()  ) ) currentCreditCard.setNumber( creditCard.getNumber() );
        if( !StringUtils.isEmpty( creditCard.getType()  ) ) currentCreditCard.setType( creditCard.getType() );

        return this.creditCardService.updateCreditCard( currentCreditCard );
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/delete/{id}")
    public void delete( @PathVariable String id ) {
        this.creditCardService.deleteCreditCard( Long.valueOf(id) );
    }
}
