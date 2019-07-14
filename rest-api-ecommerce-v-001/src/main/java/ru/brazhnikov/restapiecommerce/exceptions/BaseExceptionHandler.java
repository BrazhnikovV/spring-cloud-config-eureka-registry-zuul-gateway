package ru.brazhnikov.restapiecommerce.exceptions;

import java.util.*;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import javax.validation.ConstraintViolationException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * BaseExceptionHandler - класс обработчик исключений
 *
 * @version 1.0.1
 * @package ru.brazhnikov.restapiecommerce.exceptions
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
public class BaseExceptionHandler {

    /**
     * handleConstraintViolation - обработать ошибки валидации
     * @param ex -
     * @param request -
     * @return
     */
    @ExceptionHandler( ConstraintViolationException.class )
    public ResponseEntity<Object> handleConstraintViolation( ConstraintViolationException ex, WebRequest request ) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put( "timestamp", new Date() );
        body.put( "status", HttpStatus.BAD_REQUEST );
        List<String> errors = ex.getConstraintViolations()
                .stream()
                .map( x -> x.getMessage() )
                .collect( Collectors.toList() );

        body.put( "errors", errors );

        return new ResponseEntity<>( body, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST );
    }

    /**
     * conflict - обработать исключение DataIntegrityViolationException
     * @param req
     * @param ex
     */
    @ResponseStatus( value=HttpStatus.CONFLICT, reason="Data integrity violation" )
    @ExceptionHandler( DataIntegrityViolationException.class )
    public void conflict( HttpServletRequest req, DataIntegrityViolationException ex ) {
        // Nothing to do
    }
}
