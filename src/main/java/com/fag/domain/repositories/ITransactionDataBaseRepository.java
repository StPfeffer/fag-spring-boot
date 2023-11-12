package com.fag.domain.repositories;

import com.fag.domain.entities.TransactionBO;

public interface ITransactionDataBaseRepository {

    TransactionBO persist(TransactionBO bo);

}
