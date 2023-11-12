package com.fag.infra;

import com.fag.domain.dtos.ExceptionDTO;
import com.fag.domain.exceptions.TransactionException;
import com.fag.domain.exceptions.UserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    /**
     * Manipula exceções gerais.
     *
     * @param exception A exceção a ser tratada.
     * @return ResponseEntity contendo um objeto ExceptionDTO e status HTTP 500.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> threatGeneralExceptions(Exception exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");

        return ResponseEntity.internalServerError().body(exceptionDTO);
    }

    /**
     * Manipula exceções relacionadas a usuários.
     *
     * @param exception A exceção do tipo UserException a ser tratada.
     * @return ResponseEntity contendo um objeto ExceptionDTO e status HTTP correspondente.
     */
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ExceptionDTO> threatUserException(UserException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), String.valueOf(exception.getStatusCode()));

        return switch (exception.getStatusCode()) {
            case 400 -> ResponseEntity.badRequest().body(exceptionDTO);
            case 404 -> ResponseEntity.notFound().build();
            default -> ResponseEntity.internalServerError().body(exceptionDTO);
        };
    }

    /**
     * Manipula exceções relacionadas a transações.
     *
     * @param exception A exceção do tipo TransactionException a ser tratada.
     * @return ResponseEntity contendo um objeto ExceptionDTO e status HTTP correspondente.
     */
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