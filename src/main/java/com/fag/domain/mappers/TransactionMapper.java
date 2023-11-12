package com.fag.domain.mappers;

import com.fag.domain.dtos.TransactionDTO;
import com.fag.domain.entities.TransactionBO;

public class TransactionMapper {

    /**
     * Converte um objeto TransactionBO para um objeto TransactionDTO.
     *
     * @param bo O objeto TransactionBO a ser convertido.
     * @return Um novo objeto TransactionDTO convertido a partir do TransactionBO fornecido.
     */
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

    /**
     * Converte um objeto TransactionDTO para um objeto TransactionBO.
     *
     * @param dto O objeto TransactionDTO a ser convertido.
     * @return Um novo objeto TransactionBO convertido a partir do TransactionDTO fornecido.
     */
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
