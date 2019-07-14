package ru.brazhnikov.restapiecommerce.entities;

import lombok.Data;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import ru.brazhnikov.restapiecommerce.entities.auditable.Auditable;

/**
 * Account - класс сущности аккаунта пользователя
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
public class Account extends Auditable<String> {

    /**
     * @access private
     * @var int id - перавичный ключ таблицы
     */
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    /**
     * @access private
     * @var String accountNumber - номер аккаунта
     */
    @NotNull
    @Size( min=13, max=13 )
    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}-[0-9]{6}$")
    private String accountNumber;

    /**
     * @access private
     * @var Set<Address> addresses - список адресов (связь с таблицей адресов)
     */
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    private Set<Address> addresses = new HashSet<>();

    /**
     * @access private
     * @var Set<CreditCard> creditCards - список кредитных карт (связь с таблицей карточек)
     */
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    private Set<CreditCard> creditCards = new HashSet<>();
}
