package ru.brazhnikov.restapiecommerce.controller;

import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.brazhnikov.restapiecommerce.entities.Account;
import ru.brazhnikov.restapiecommerce.entities.Address;
import ru.brazhnikov.restapiecommerce.services.AccountService;
import ru.brazhnikov.restapiecommerce.services.AddressService;

import java.util.List;
import java.util.Optional;

/**
 * AddressController - класс контроллер сущности адрес пользователя
 *
 * @version 1.0.1
 * @package ru.brazhnikov.restapiecommerce.controller
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Setter
@RestController
@RequestMapping( path = "/api/address", produces = MediaType.APPLICATION_JSON_VALUE )
public class AddressController {

    /**
     *  @access private
     *  @var AccountService accountService - сервис для получения информации об акаунтах
     */
    @Autowired
    private AddressService addressService;

    @Secured({"ROLE_ADMIN"})
    @GetMapping( value = "/list" )
    public List<Address> list () {
        List<Address> addresses = this.addressService.getAllAddressList();
        return  addresses;
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping( path = "/create", consumes = "application/json" )
    public Address create( @RequestBody Address address ) {
        return  this.addressService.createAddress( address );
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/update/{id}")
    public Address update( @PathVariable String id, @RequestBody Address address ) {

        Optional<Address> optionalAddress = this.addressService.getAddressRepositoryById( Long.valueOf( id ) );
        Address currentAddress = optionalAddress.get();

        if( !StringUtils.isEmpty( address.getStreet1()  ) ) currentAddress.setStreet1( address.getStreet1() );
        if( !StringUtils.isEmpty( address.getStreet2()  ) ) currentAddress.setStreet2( address.getStreet2() );
        if( !StringUtils.isEmpty( address.getCity()     ) ) currentAddress.setCity( address.getCity() );
        if( !StringUtils.isEmpty( address.getCountry()  ) ) currentAddress.setCountry( address.getCountry() );
        if( !StringUtils.isEmpty( address.getDistrict() ) ) currentAddress.setDistrict( address.getDistrict() );
        if( !StringUtils.isEmpty( address.getZipCode()  ) ) currentAddress.setZipCode( address.getZipCode() );

        return this.addressService.updateAddress( currentAddress );
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/delete/{id}")
    public void delete( @PathVariable String id ) {
        this.addressService.deleteAddress( Long.valueOf(id) );
    }
}
