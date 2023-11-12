package com.fag.domain.repositories;

import com.fag.domain.dtos.UserDTO;

import java.util.List;


public interface IUserRepository {

    List<UserDTO> listAllUsers();

    UserDTO findUserById(Long id) throws Exception;

    UserDTO findUserByDocument(String document);

}
