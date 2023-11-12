package com.fag.infra.jakarta.repository;

import com.fag.domain.entities.TransactionBO;
import com.fag.domain.repositories.ITransactionDataBaseRepository;
import com.fag.infra.jakarta.mappers.JakartaTransactionMapper;
import com.fag.infra.jakarta.model.JakartaTransaction;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class JakartaTransactionRepository extends SimpleJpaRepository<JakartaTransaction, Long> implements ITransactionDataBaseRepository {

    private final EntityManager em;

    @Autowired
    public JakartaTransactionRepository(EntityManager em) {
        super(JakartaTransaction.class, em);
        this.em = em;
    }

    @Override
    public TransactionBO persist(TransactionBO bo) {
        JakartaTransaction entity = JakartaTransactionMapper.toEntity(bo);

        em.persist(entity);
        em.flush();

        return JakartaTransactionMapper.toDomain(entity);
    }

}
