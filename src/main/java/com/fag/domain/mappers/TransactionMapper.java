package com.fag.domain.mappers;

import com.fag.domain.dtos.TransactionDTO;
import com.fag.domain.entities.TransactionBO;

public class TransactionMapper {

    public static TransactionDTO toDTO(TransactionBO bo) {
        return new TransactionDTO(
                bo.id(),
                bo.amount(),
                UserMapper.toDTO(bo.sender()),
                UserMapper.toDTO(bo.receiver()),
                bo.timestamp(),
                bo.success()
        );
    }

    public static TransactionBO toBO(TransactionDTO dto) {
        return new TransactionBO(
                dto.getId(),
                dto.getAmount(),
                UserMapper.toBO(dto.getSender()),
                UserMapper.toBO(dto.getReceiver()),
                dto.getTimestamp(),
                dto.isSuccess()
        );
    }

}
