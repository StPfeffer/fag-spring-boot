package com.fag.services;

import com.fag.domain.dtos.TransactionDTO;
import com.fag.domain.dtos.TransactionRequestDTO;
import com.fag.domain.dtos.UserDTO;
import com.fag.domain.exceptions.TransactionException;
import com.fag.domain.repositories.ITransactionRepository;
import com.fag.domain.usecases.CreateTransaction;
import com.fag.infra.jakarta.repository.JakartaTransactionRepository;
import com.fag.infra.mocky.repository.TransactionMocky;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService implements ITransactionRepository {

    @Autowired
    private UserService userService;

    @Autowired
    private JakartaTransactionRepository repository;

    @Autowired
    private TransactionMocky mocky;

    @Transactional
    public TransactionDTO createTransaction(TransactionRequestDTO request) {
        UserDTO sender = this.userService.findUserById(request.senderId());
        UserDTO receiver = this.userService.findUserById(request.receiverId());

        this.userService.validateTransaction(sender, request.value());

        if (!mocky.authorizeTransaction()) {
            throw new TransactionException("Transação não autorizada pelo serviço", 500);
        }

        this.updateBalance(sender, receiver, request.value());

        TransactionDTO dto = new TransactionDTO(
                null,
                request.value(),
                sender,
                receiver,
                LocalDateTime.now(),
                true
        );

        CreateTransaction createTransaction = new CreateTransaction(repository);
        return createTransaction.execute(dto);
    }

    @Override
    public TransactionDTO findTransactionById(Long id) {
        return this.repository.findTransactionById(id);
    }

    @Override
    public List<TransactionDTO> listAllTransactions() {
        return this.repository.listAllTransactions();
    }

    public List<TransactionDTO> listAllTransactionsByUser(UserDTO sender) {
        return this.repository.listAllTransactionsByUser(sender);
    }

    @Override
    public List<TransactionDTO> listAllTransactionsBySender(UserDTO sender) {
        return this.repository.listAllTransactionsBySender(sender);
    }

    @Override
    public List<TransactionDTO> listAllTransactionsByReceiver(UserDTO receiver) {
        return this.repository.listAllTransactionsByReceiver(receiver);
    }

    private void updateBalance(UserDTO sender, UserDTO receiver, BigDecimal value) {
        sender.setBalance(sender.getBalance().subtract(value));
        receiver.setBalance(receiver.getBalance().add(value));

        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);
    }

}
