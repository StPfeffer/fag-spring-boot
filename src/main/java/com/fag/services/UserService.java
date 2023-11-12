package com.fag.services;

import com.fag.domain.dtos.UserDTO;
import com.fag.domain.enums.EnumUserType;
import com.fag.domain.repositories.IUserRepository;
import com.fag.domain.usecases.CreateUser;
import com.fag.infra.jakarta.repository.JakartaTransactionRepository;
import com.fag.infra.jakarta.repository.JakartaUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService implements IUserRepository {

    @Autowired
    private JakartaUserRepository repository;

    @Autowired
    private JakartaTransactionRepository transactionRepository;

    public void validateTransaction(UserDTO sender, BigDecimal amount) throws Exception {
        if (sender == null) {
            throw new Exception("Não existe um usuário cadastrado para este ID");
        }

        if (sender.getType() == EnumUserType.MERCHANT) {
            throw new Exception("Usuário do tipo Lojista não está autorizado a realizar transações");
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Saldo insuficiente");
        }
    }

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
