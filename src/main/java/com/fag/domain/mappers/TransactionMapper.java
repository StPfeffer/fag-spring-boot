package com.fag.domain.mappers;

import com.fag.domain.dtos.TransactionDTO;
import com.fag.domain.entities.TransactionBO;

public class TransactionMapper {

    public static TransactionDTO toDTO(TransactionBO bo) {
        return new TransactionDTO(
                bo.getId(),
                bo.getAmount(),
                UserMapper.toDTO(bo.getSender()),
                UserMapper.toDTO(bo.getReceiver()),
                bo.getTimestamp()
        );
    }

    public static TransactionBO toBO(TransactionDTO dto) {
        return new TransactionBO(
                dto.getId(),
                dto.getAmount(),
                UserMapper.toBO(dto.getSender()),
                UserMapper.toBO(dto.getReceiver()),
                dto.getTimestamp()
        );
    }

}
