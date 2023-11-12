package com.fag.domain.repositories;

import com.fag.domain.dtos.TransactionDTO;
import com.fag.domain.dtos.UserDTO;

import java.util.List;

public interface ITransactionRepository {

    TransactionDTO findTransactionById(Long id);

    List<TransactionDTO> listAllTransactions();

    List<TransactionDTO> listAllTransactionsBySender(UserDTO sender);

    List<TransactionDTO> listAllTransactionsByReceiver(UserDTO receiver);

}
