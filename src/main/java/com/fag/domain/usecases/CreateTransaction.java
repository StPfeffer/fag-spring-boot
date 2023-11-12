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

    /**
     * Executa a criação de uma transação.
     *
     * @param dto O objeto TransactionDTO que contém os dados da transação a ser criada.
     * @return Um objeto TransactionDTO representando a transação criada.
     */
    public TransactionDTO execute(TransactionDTO dto) {
        // Persiste a transação no banco de dados convertendo o DTO para BO.
        TransactionBO entity = repository.persist(TransactionMapper.toBO(dto));

        // Converte a entidade BO resultante de volta para DTO antes de retornar.
        return TransactionMapper.toDTO(entity);
    }

}
