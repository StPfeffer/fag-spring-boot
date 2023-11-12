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
                bo.timestamp()
        );
    }

    public static TransactionBO toBO(TransactionDTO dto) {
        return new TransactionBO(
                dto.id(),
                dto.amount(),
                UserMapper.toBO(dto.sender()),
                UserMapper.toBO(dto.receiver()),
                dto.timestamp()
        );
    }

}
