package com.fag.domain.usecases;

import com.fag.domain.dtos.UserDTO;
import com.fag.domain.entities.UserBO;
import com.fag.domain.mappers.UserMapper;
import com.fag.domain.repositories.IUserDataBaseRepository;

public class CreateUser {

    private final IUserDataBaseRepository dbRepository;

    public CreateUser(IUserDataBaseRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    public UserDTO execute(UserDTO dto) {
        UserBO entity = dbRepository.persist(UserMapper.toBO(dto));

        return UserMapper.toDTO(entity);
    }

}
