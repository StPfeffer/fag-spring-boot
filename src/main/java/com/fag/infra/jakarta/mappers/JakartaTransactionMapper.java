package com.fag.infra.jakarta.mappers;

import com.fag.domain.entities.TransactionBO;
import com.fag.infra.jakarta.model.JakartaTransaction;

public class JakartaTransactionMapper {

    /**
     * Converte um objeto TransactionBO para uma entidade JakartaTransaction.
     *
     * @param domain O objeto TransactionBO a ser convertido.
     * @return Uma nova entidade JakartaTransaction convertida a partir do TransactionBO fornecido.
     */
    public static JakartaTransaction toEntity(TransactionBO domain) {
        return new JakartaTransaction(
                domain.amount(),
                JakartaUserMapper.toEntity(domain.sender()),
                JakartaUserMapper.toEntity(domain.receiver()),
                domain.timestamp(),
                domain.success()
        );
    }

    /**
     * Converte uma entidade JakartaTransaction para um objeto TransactionBO.
     *
     * @param entity A entidade JakartaTransaction a ser convertida.
     * @return Um novo objeto TransactionBO convertido a partir da entidade JakartaTransaction fornecida.
     */
    public static TransactionBO toDomain(JakartaTransaction entity) {
        return new TransactionBO(
                entity.getId(),
                entity.getAmount(),
                JakartaUserMapper.toDomain(entity.getSender()),
                JakartaUserMapper.toDomain(entity.getReceiver()),
                entity.getTimestamp(),
                entity.isSuccess()
        );
    }

}
