package com.fag.domain.mappers;

import com.fag.domain.dtos.UserDTO;
import com.fag.domain.entities.UserBO;

public class UserMapper {

    public static UserDTO toDTO(UserBO bo) {
        return new UserDTO(
                bo.getId(),
                bo.getFirstName(),
                bo.getLastName(),
                bo.getDocument(),
                bo.getEmail(),
                bo.getPassword(),
                bo.getBalance(),
                bo.getUserType()
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
