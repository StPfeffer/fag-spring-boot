package com.fag.domain.mappers;

import com.fag.domain.dtos.UserDTO;
import com.fag.domain.entities.UserBO;

public class UserMapper {

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
