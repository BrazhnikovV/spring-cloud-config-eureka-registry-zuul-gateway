package ru.brazhnikov.restapiecommerce.entities.enums;

/**
 * OrderStatus - Состояния заказа
 * @version 1.0.1
 * @see java.lang.Enum
 * @author vasek
 */
public enum OrderStatus {
    /**
     * в ожидании
     */
    PENDING,
    /**
     * подтвержденный
     */
    CONFIRMED,
    /**
     * отправленный
     */
    SHIPPED,
    /**
     * доставленный
     */
    DELIVERED
}
