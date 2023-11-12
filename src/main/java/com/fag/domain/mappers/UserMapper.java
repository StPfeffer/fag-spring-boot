package com.fag.domain.mappers;

import com.fag.domain.dtos.UserDTO;
import com.fag.domain.entities.UserBO;

public class UserMapper {

    /**
     * Converte um objeto UserBO para um objeto UserDTO.
     *
     * @param bo O objeto UserBO a ser convertido.
     * @return Um novo objeto UserDTO convertido a partir do UserBO fornecido.
     */
    public static UserDTO toDTO(UserBO bo) {
        return new UserDTO(
                bo.id(),
                bo.firstName(),
                bo.lastName(),
                bo.document(),
                bo.email(),
                bo.password(),
                bo.balance(),
                bo.userType()
        );
    }

    /**
     * Converte um objeto UserDTO para um objeto UserBO.
     *
     * @param dto O objeto UserDTO a ser convertido.
     * @return Um novo objeto UserBO convertido a partir do UserDTO fornecido.
     */
    public static UserBO toBO(UserDTO dto) {
        return new UserBO(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getDocument(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getBalance(),
                dto.getType()
        );
    }

}
