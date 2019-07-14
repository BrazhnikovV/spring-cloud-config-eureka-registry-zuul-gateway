package ru.brazhnikov.restapiecommerce.entities.auditable;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import lombok.AccessLevel;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


/**
 * Auditable - класс для аудита таблицы сущности account
 *
 * @version 1.0.1
 * @package ru.brazhnikov.restapiecommerce.entities.auditable
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Getter( AccessLevel.PROTECTED )
@Setter( AccessLevel.PROTECTED )
@MappedSuperclass
@EntityListeners( AuditingEntityListener.class )
public class Auditable<U> {

    @CreationTimestamp
    @Column( name = "created_at" )
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column( name = "updated_at" )
    private Timestamp updatedAt;
}
