package com.fag.infra.jakarta.mappers;

import com.fag.domain.entities.TransactionBO;
import com.fag.infra.jakarta.model.JakartaTransaction;

public class JakartaTransactionMapper {

    public static JakartaTransaction toEntity(TransactionBO domain) {
        return new JakartaTransaction(
                domain.getAmount(),
                JakartaUserMapper.toEntity(domain.getSender()),
                JakartaUserMapper.toEntity(domain.getReceiver()),
                domain.getTimestamp()
        );
    }

    public static TransactionBO toDomain(JakartaTransaction entity) {
        return new TransactionBO(
                entity.getId(),
                entity.getAmount(),
                JakartaUserMapper.toDomain(entity.getSender()),
                JakartaUserMapper.toDomain(entity.getReceiver()),
                entity.getTimestamp()
        );
    }

}
