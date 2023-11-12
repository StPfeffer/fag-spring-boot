package com.fag.controllers;

import com.fag.domain.dtos.TransactionDTO;
import com.fag.domain.dtos.TransactionRequestDTO;
import com.fag.services.TransactionService;
import com.fag.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody TransactionRequestDTO request) {
        TransactionDTO newTransaction = this.transactionService.createTransaction(request);

        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> listTransactions() {
        return ResponseEntity.ok(this.transactionService.listAllTransactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getTransaction(@PathVariable Long id) {
        return ResponseEntity.ok(this.transactionService.findTransactionById(id));
    }

    @GetMapping("/sender/{senderId}")
    public ResponseEntity<List<TransactionDTO>> listTransactionsBySender(@PathVariable Long senderId) {
        return ResponseEntity.ok(this.transactionService.listAllTransactionsBySender(this.userService.findUserById(senderId)));
    }

    @GetMapping("/receiver/{receiverId}")
    public ResponseEntity<List<TransactionDTO>> listTransactionsByReceiver(@PathVariable Long receiverId) {
        return ResponseEntity.ok(this.transactionService.listAllTransactionsByReceiver(this.userService.findUserById(receiverId)));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TransactionDTO>> listTransactionsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(this.transactionService.listAllTransactionsByUser(this.userService.findUserById(userId)));
    }

}
