package ru.brazhnikov.restapiecommerce.entities;

import lombok.Data;
import javax.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import ru.brazhnikov.restapiecommerce.entities.auditable.Auditable;

/**
 * CreditCard - класс сущности кредитной карты пользователя
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
public class CreditCard extends Auditable<String> {

    /**
     * @access private
     * @var int id - перавичный ключ таблицы
     */
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    /**
     * @access private
     * @var String number - номер карты
     */
    @NotNull
    @Size( min=19, max=19 )
    @Pattern(regexp = "^[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}$")
    private String number;

    /**
     * @access private
     * @var String type - тип карты
     */
    @NotNull
    @Size( min=2, max=32 )
    private String type;
}
