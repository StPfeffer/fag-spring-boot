package com.fag.services;

import com.fag.domain.dtos.UserDTO;
import com.fag.domain.repositories.IUserRepository;
import com.fag.domain.usecases.CreateUser;
import com.fag.infra.jakarta.repository.JakartaTransactionRepository;
import com.fag.infra.jakarta.repository.JakartaUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserRepository {

    @Autowired
    private JakartaUserRepository repository;

    @Autowired
    private JakartaTransactionRepository transactionRepository;

    @Transactional
    public UserDTO createUser(UserDTO dto) {
        CreateUser createUser = new CreateUser(repository);

        return createUser.execute(dto);
    }

    @Override
    public List<UserDTO> listAllUsers() {
        return this.repository.listAllUsers();
    }

    @Override
    public UserDTO findUserById(Long id) throws Exception {
        return this.repository.findUserById(id);
    }

    @Override
    public UserDTO findUserByDocument(String document) {
        return this.repository.findUserByDocument(document);
    }

}
