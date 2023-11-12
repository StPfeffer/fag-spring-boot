package com.fag.domain.usecases;

import com.fag.domain.dtos.TransactionDTO;
import com.fag.domain.entities.TransactionBO;
import com.fag.domain.mappers.TransactionMapper;
import com.fag.domain.repositories.ITransactionDataBaseRepository;

public class CreateTransaction {

    private final ITransactionDataBaseRepository repository;

    public CreateTransaction(ITransactionDataBaseRepository repository) {
        this.repository = repository;
    }

    public TransactionDTO execute(TransactionDTO dto) {
        TransactionBO entity = repository.persist(TransactionMapper.toBO(dto));

        return TransactionMapper.toDTO(entity);
    }

}
