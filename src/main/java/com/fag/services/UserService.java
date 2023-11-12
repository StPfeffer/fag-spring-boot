package com.fag.services;

import com.fag.domain.dtos.TransactionDTO;
import com.fag.domain.dtos.UserDTO;
import com.fag.domain.enums.EnumUserType;
import com.fag.domain.exceptions.UserException;
import com.fag.domain.mappers.UserMapper;
import com.fag.domain.repositories.IUserRepository;
import com.fag.domain.usecases.CreateUser;
import com.fag.infra.jakarta.mappers.JakartaUserMapper;
import com.fag.infra.jakarta.model.JakartaUser;
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

    /**
     * Valida se uma transação é possível para o usuário informado.
     *
     * @param sender O remetente da transação.
     * @param amount O valor da transação.
     * @throws UserException Se a validação falhar, uma exceção será lançada.
     */
    public void validateTransaction(UserDTO sender, BigDecimal amount) {
        if (sender == null) {
            throw new UserException("Não existe um usuário cadastrado para este ID", 400);
        }

        if (sender.getType() == EnumUserType.MERCHANT) {
            throw new UserException("Usuário do tipo Lojista não está autorizado a realizar transações", 400);
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new UserException("Saldo insuficiente", 400);
        }
    }

    /**
     * Cria um novo usuário.
     *
     * @param dto O objeto UserDTO contendo detalhes do usuário a ser criado.
     * @return Um objeto UserDTO representando o usuário criado.
     */
    @Transactional
    public UserDTO createUser(UserDTO dto) {
        CreateUser createUser = new CreateUser(repository);

        return createUser.execute(dto);
    }

    /**
     * Salva um usuário no banco de dados.
     *
     * @param user O objeto UserDTO a ser salvo.
     */
    @Transactional
    public void saveUser(UserDTO user) {
        JakartaUser entity = JakartaUserMapper.toEntity(UserMapper.toBO(user));

        this.repository.save(entity);
    }

    /**
     * Lista todos os usuários no banco de dados.
     *
     * @return Uma lista de objetos UserDTO representando todos os usuários.
     */
    @Override
    public List<UserDTO> listAllUsers() {
        return this.repository.listAllUsers();
    }

    /**
     * Busca um usuário pelo seu ID.
     *
     * @param id O ID do usuário a ser encontrado.
     * @return Um objeto UserDTO representando o usuário encontrado.
     */
    @Override
    public UserDTO findUserById(Long id) {
        return this.repository.findUserById(id);
    }

    /**
     * Busca um usuário pelo seu documento.
     *
     * @param document O documento do usuário a ser encontrado.
     * @return Um objeto UserDTO representando o usuário encontrado.
     * Se o usuário não for encontrado, retorna null.
     */
    @Override
    public UserDTO findUserByDocument(String document) {
        return this.repository.findUserByDocument(document);
    }

    /**
     * Atualiza um usuário existente.
     *
     * @param id   O ID do usuário a ser atualizado.
     * @param user O objeto UserDTO contendo as atualizações.
     * @return Um objeto UserDTO representando o usuário atualizado.
     * @throws UserException Se o usuário não for encontrado, uma exceção será lançada.
     */
    @Transactional
    public UserDTO updateUser(Long id, UserDTO user) {
        UserDTO entity = this.findUserById(id);

        if (entity == null) {
            throw new UserException("Não existe um usuário cadastrado para este ID", 404);
        }

        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setDocument(user.getDocument());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setBalance(user.getBalance());
        entity.setType(user.getType());

        this.repository.save(JakartaUserMapper.toEntity(UserMapper.toBO(entity)));

        return user;
    }

    /**
     * Exclui um usuário pelo seu ID, se possível.
     *
     * @param id O ID do usuário a ser excluído.
     * @return Um objeto UserDTO representando o usuário excluído.
     * @throws UserException Se o usuário não for encontrado ou possuir transações, uma exceção será lançada.
     */
    @Transactional
    public UserDTO deleteUser(Long id) {
        JakartaUser user = this.repository.findById(id).orElse(null);

        if (user == null) {
            throw new UserException("Não existe um usuário cadastrado para este ID", 404);
        }

        UserDTO userDTO = UserMapper.toDTO(JakartaUserMapper.toDomain(user));
        List<TransactionDTO> userTransactions = this.transactionRepository.listAllTransactionsByUser(userDTO);

        if (!userTransactions.isEmpty()) {
            throw new UserException("Não é possível excluir um usuário que possui transações", 400);
        }

        this.repository.delete(user);
        return userDTO;
    }

}
