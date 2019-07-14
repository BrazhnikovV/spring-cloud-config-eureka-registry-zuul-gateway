package ru.brazhnikov.restapiecommerce.services;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.brazhnikov.restapiecommerce.entities.Account;
import ru.brazhnikov.restapiecommerce.entities.Address;
import ru.brazhnikov.restapiecommerce.repositories.AccountRepository;
import ru.brazhnikov.restapiecommerce.repositories.AddressRepository;

import java.util.List;
import java.util.Optional;

/**
 * AddressService - класс сервиса для работы с данными об адресах
 *
 * @version 1.0.1
 * @package ru.brazhnikov.services
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Setter
@Service
public class AddressService {

    /**
     *  @access private
     *  @var AddressRepository addressRepository - репозиторий адресов
     */
    @Autowired
    private AddressRepository addressRepository;

    /**
     * getAccountById -
     * @return List<Address>
     */
    public Optional<Address> getAddressRepositoryById(Long id ) {
        return this.addressRepository.findById( id );
    }

    /**
     * getAllAddressList - получить список акаунтов
     * @return List<Address>
     */
    public List<Address> getAllAddressList() {
        return ( List<Address> ) this.addressRepository.findAll();
    }

    /**
     * createAddress - добавить адрес
     * @return Address
     */
    public Address createAddress( Address address ) {
        return this.addressRepository.save( address );
    }

    /**
     * updateAddress - обновить адрес
     * @param address
     * @return Address
     */
    public Address updateAddress( Address address ) {
        return this.addressRepository.save( address);
    }

    /**
     * deleteAddress - удалить адрес
     * @param id
     * @return void
     */
    public void deleteAddress( Long id ) {
        this.addressRepository.deleteById( id );
    }
}
