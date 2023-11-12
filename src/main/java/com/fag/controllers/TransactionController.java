package com.fag.controllers;

import com.fag.domain.dtos.TransactionDTO;
import com.fag.domain.dtos.TransactionRequestDTO;
import com.fag.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody TransactionRequestDTO request) throws Exception {
        TransactionDTO newTransaction = this.transactionService.createTransaction(request);

        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }

}
