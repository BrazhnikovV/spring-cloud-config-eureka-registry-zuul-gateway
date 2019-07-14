package ru.brazhnikov.restapiecommerce.entities;

import lombok.Data;
import javax.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import ru.brazhnikov.restapiecommerce.entities.auditable.Auditable;


/**
 * Address - класс сущности адреса пользователя
 *
 * @version 1.0.1
 * @package ru.brazhnikov.restapiecommerce.entities
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address extends Auditable<String> {

    /**
     * @access private
     * @var int id - перавичный ключ таблицы
     */
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    /**
     * @access private
     * @var String street1 - первая улица
     */
    @NotNull
    @Size( min=4, max=64 )
    private String street1;

    /**
     * @access private
     * @var String street2 - вторая улица
     */
    @Size( min=4, max=64 )
    private String street2;

    /**
     * @access private
     * @var String district - район города
     */
    @NotNull
    @Size( min=4, max=64 )
    private String district;

    /**
     * @access private
     * @var String city - город
     */
    @NotNull
    @Size( min=4, max=64 )
    private String city;

    /**
     * @access private
     * @var String country - страна
     */
    @NotNull
    @Size( min=4, max=64 )
    private String country;

    /**
     * @access private
     * @var String zipCode - zip код
     */
    @NotNull
    @Size( min=8, max=8 )
    private String zipCode;
}
