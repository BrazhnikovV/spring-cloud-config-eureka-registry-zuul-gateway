package ru.brazhnikov.restapiecommerce.entities;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import ru.brazhnikov.restapiecommerce.entities.auditable.Auditable;

/**
 * Customer - класс сущности пользователя
 *
 * @version 1.0.1
 * @package ru.brazhnikov.restapiecommerce.controller
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends Auditable<String> {

    /**
     * @access private
     * @var int id - перавичный ключ таблицы
     */
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    /**
     * @access private
     * @var String userName - логин
     */
    @NotNull
    @Size( min=4, max=64 )
    private String username;

    /**
     * @access private
     * @var String password - пароль
     */
    @NotNull
    @Size(min=4, max=64)
    private String password;

    /**
     * @access private
     * @var String token - токен
     */
    @NotNull
    @Size( min=4, max=64 )
    private String token;

    /**
     * @access private
     * @var String first_name - имя пользователя
     */
    @NotNull
    @Size( min=4, max=64 )
    private String firstName;

    /**
     * @access private
     * @var String last_name - фамилия
     */
    @NotNull
    @Size( min=4, max=64 )
    private String lastName;

    /**
     * @access private
     * @var String email - электронная почта
     */
    @NotNull
    @Size( min=4, max=64 )
    private String email;

    /**
     * @access private
     * @var String role - роль пользователя в системе
     */
    @NotNull
    @Size( min=6, max=32 )
    private String role;

    /**
     *  @access private
     *  @var Set<Account> accounts -
     */
    @OneToOne( cascade = CascadeType.ALL )
    private Account account;
}
