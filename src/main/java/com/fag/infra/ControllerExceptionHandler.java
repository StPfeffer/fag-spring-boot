package com.fag.infra;

import com.fag.domain.dtos.ExceptionDTO;
import com.fag.domain.exceptions.TransactionException;
import com.fag.domain.exceptions.UserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> threatGeneralExceptions(Exception exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");

        return ResponseEntity.internalServerError().body(exceptionDTO);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ExceptionDTO> threatUserException(UserException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), String.valueOf(exception.getStatusCode()));

        return switch (exception.getStatusCode()) {
            case 400 -> ResponseEntity.badRequest().body(exceptionDTO);
            case 404 -> ResponseEntity.notFound().build();
            default -> ResponseEntity.internalServerError().body(exceptionDTO);
        };
    }

    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<ExceptionDTO> threatTransactionException(TransactionException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), String.valueOf(exception.getStatusCode()));

        return switch (exception.getStatusCode()) {
            case 400 -> ResponseEntity.notFound().build();
            case 404 -> ResponseEntity.badRequest().body(exceptionDTO);
            default -> ResponseEntity.internalServerError().body(exceptionDTO);
        };
    }

}