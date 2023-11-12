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

    /**
     * Executa a criação de um usuário.
     *
     * @param dto O objeto UserDTO que contém os dados do usuário a ser criado.
     * @return Um objeto UserDTO representando o usuário criado.
     */
    public UserDTO execute(UserDTO dto) {
        // Persiste o usuário no banco de dados convertendo o DTO para BO.
        UserBO entity = repository.persist(UserMapper.toBO(dto));

        // Converte a entidade BO resultante de volta para DTO antes de retornar.
        return UserMapper.toDTO(entity);
    }

}
