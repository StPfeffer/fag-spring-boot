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

    /**
     * Cria uma nova transação.
     *
     * @param request Os dados de requisição da transação.
     * @return A transação criada e o status HTTP 201 (CREATED).
     */
    @PostMapping
    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody TransactionRequestDTO request) {
        TransactionDTO newTransaction = this.transactionService.createTransaction(request);

        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }

    /**
     * Lista todas as transações.
     *
     * @return Uma lista, contendo todas as transações e o status HTTP 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<TransactionDTO>> listTransactions() {
        return ResponseEntity.ok(this.transactionService.listAllTransactions());
    }

    /**
     * Obtém uma transação pelo seu ID.
     *
     * @param id O ID da transação.
     * @return A transação referente a este ID, ou {@code null} se não houver
     *         nenhuma transação associada ao ID informado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getTransaction(@PathVariable Long id) {
        return ResponseEntity.ok(this.transactionService.findTransactionById(id));
    }

    /**
     * Lista todas as transações pelo seu remetente.
     *
     * @param senderId O ID do remetente.
     * @return As transações referentes a este remetente, ou {@code null} se não
     *         houver nenhuma transação associada ao ID do remetente informado.
     */
    @GetMapping("/sender/{senderId}")
    public ResponseEntity<List<TransactionDTO>> listTransactionsBySender(@PathVariable Long senderId) {
        return ResponseEntity.ok(this.transactionService.listAllTransactionsBySender(this.userService.findUserById(senderId)));
    }

    /**
     * Lista todas as transações pelo seu destinatário.
     *
     * @param receiverId O ID do destinatário.
     * @return As transações referentes a este destinatário, ou {@code null} se não
     *         houver nenhuma transação associada ao ID do destinatário informado.
     */
    @GetMapping("/receiver/{receiverId}")
    public ResponseEntity<List<TransactionDTO>> listTransactionsByReceiver(@PathVariable Long receiverId) {
        return ResponseEntity.ok(this.transactionService.listAllTransactionsByReceiver(this.userService.findUserById(receiverId)));
    }

    /**
     * Lista todas as transações que envolvem este usuário, seja ele o remetente
     * ou destinatário da mesma.
     *
     * @param userId O ID do usuário.
     * @return Uma lista contendo todas as transações na qual este usuário faz
     *         parte, ou {@code null} se não houver transações com este usuário.
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TransactionDTO>> listTransactionsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(this.transactionService.listAllTransactionsByUser(this.userService.findUserById(userId)));
    }

    /**
     * Realiza o cancelamento de uma transação previamente aprovada pelos demais
     * servições.
     * <p>
     * A valor referente a esta transação será debitado para os respectivos
     * usuários.
     *
     * @param id O ID da transação a ser cancelada.
     * @return A transação, cancelada.
     */
    @PutMapping("/{id}/refuse")
    public ResponseEntity<TransactionDTO> refuseTransaction(@PathVariable Long id) {
        return ResponseEntity.ok(this.transactionService.refuseTransactionById(id));
    }

}
