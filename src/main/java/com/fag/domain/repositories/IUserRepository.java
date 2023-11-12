package com.fag.domain.repositories;

import com.fag.domain.dtos.UserDTO;

import java.util.List;

public interface IUserRepository {

    UserDTO findUserById(Long id);

    UserDTO findUserByDocument(String document);

    List<UserDTO> listAllUsers();

}
