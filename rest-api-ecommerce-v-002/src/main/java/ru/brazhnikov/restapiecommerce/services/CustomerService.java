package ru.brazhnikov.restapiecommerce.services;

import java.util.UUID;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.brazhnikov.restapiecommerce.entities.Customer;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import ru.brazhnikov.restapiecommerce.repositories.CustomerRepository;

/**
 * CustomerService - класс сервиса для работы с пользователями
 *
 * @version 1.0.1
 * @package ru.brazhnikov.restapiecommerce.services
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Service("customerService")
public class CustomerService implements ICustomerService {

    /**
     * @access private
     * @var CustomerRepository customerRepository - репозиторий для экземпляров Customer
     */
    @Autowired
    public CustomerRepository customerRepository;

    @Override
    public String login( String username, String password ) {

        String encodedPassword = this.convertStringToMD5( password );

        Optional<Customer> customer = this.customerRepository.login( username, encodedPassword );
        if( customer.isPresent() ) {
            return this.generateAndSaveToken( customer );
        }

        return StringUtils.EMPTY;
    }

    @Override
    public Optional<User> findByToken( String token ) {

        Optional<Customer> optionalCustomer = this.customerRepository.findByToken( token );
        if( optionalCustomer.isPresent() ) {
            return this.customerRepository.findByToken( token ).map( this::getUserDetails );
        }
        return  Optional.empty();
    }

    @Override
    public Customer findById( Long id ) {
        Optional<Customer> optionalCustomer = this.customerRepository.findById( id );
        return optionalCustomer.orElse(null );
    }

    /**
     * getUserDetails - получить детали внутреннего пользователя(springframework.security.core.userdetails)
     * на основе сущности пользователя, который хранится в БД
     * @param customer
     * @return User
     */
    private User getUserDetails( Customer customer ) {
        User userDetails = new User(
                customer.getUsername(),
                customer.getPassword(), true, true, true, true,
                AuthorityUtils.createAuthorityList( customer.getRole() )
        );

        return userDetails;
    }

    /**
     * convertStringToMD5 - конвертировать строку в хэш MD5
     * @param md5
     * @return String
     */
    private String convertStringToMD5( String md5 ) {

        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance( "MD5" );

            byte[] array    = md.digest( md5.getBytes() );
            StringBuffer sb = new StringBuffer();
            for ( int i = 0; i < array.length; ++i ) {
                sb.append( Integer.toHexString((array[i] & 0xFF) | 0x100).substring( 1,3 ) );
            }

            return sb.toString();

        }
        catch ( java.security.NoSuchAlgorithmException e ) {}

        return null;
    }

    /**
     * generateAndSaveToken - сгенерировать токен для пользователя и сохранить его в БД
     * @param customer
     * @return String
     */
    private String generateAndSaveToken( Optional<Customer> customer ) {
        String token    = UUID.randomUUID().toString();
        Customer user = customer.get();

        user.setToken( token );
        this.customerRepository.save( user );

        return  token;
    }
}
