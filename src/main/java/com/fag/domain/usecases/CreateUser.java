package com.fag.domain.usecases;

import com.fag.domain.dtos.UserDTO;
import com.fag.domain.entities.UserBO;
import com.fag.domain.mappers.UserMapper;
import com.fag.domain.repositories.IUserDataBaseRepository;

public class CreateUser {

    private final IUserDataBaseRepository repository;

    public CreateUser(IUserDataBaseRepository repository) {
        this.repository = repository;
    }

    public UserDTO execute(UserDTO dto) {
        UserBO entity = repository.persist(UserMapper.toBO(dto));

        return UserMapper.toDTO(entity);
    }

}
