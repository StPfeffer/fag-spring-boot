package com.fag.infra.jakarta.repository;

import com.fag.domain.dtos.TransactionDTO;
import com.fag.domain.dtos.UserDTO;
import com.fag.domain.entities.TransactionBO;
import com.fag.domain.mappers.TransactionMapper;
import com.fag.domain.repositories.ITransactionDataBaseRepository;
import com.fag.domain.repositories.ITransactionRepository;
import com.fag.infra.jakarta.mappers.JakartaTransactionMapper;
import com.fag.infra.jakarta.model.JakartaTransaction;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JakartaTransactionRepository extends SimpleJpaRepository<JakartaTransaction, Long> implements ITransactionDataBaseRepository, ITransactionRepository {

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

    @Override
    public List<TransactionDTO> listAllTransactions() {
        List<JakartaTransaction> transactions = this.findAll();

        return transactions.stream()
                .map(jakartaTransaction -> TransactionMapper.toDTO(JakartaTransactionMapper.toDomain(jakartaTransaction)))
                .collect(Collectors.toList());
    }

    @Override
    public List<TransactionDTO> listAllTransactionsBySender(UserDTO sender) {
        return null;
    }

    @Override
    public List<TransactionDTO> listAllTransactionsByReceiver(UserDTO receiver) {
        return null;
    }

}
