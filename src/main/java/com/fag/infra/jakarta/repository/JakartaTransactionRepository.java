package com.fag.infra.jakarta.repository;

import com.fag.domain.dtos.TransactionDTO;
import com.fag.domain.dtos.UserDTO;
import com.fag.domain.entities.TransactionBO;
import com.fag.domain.exceptions.TransactionException;
import com.fag.domain.mappers.TransactionMapper;
import com.fag.domain.mappers.UserMapper;
import com.fag.domain.repositories.ITransactionDataBaseRepository;
import com.fag.domain.repositories.ITransactionRepository;
import com.fag.infra.jakarta.mappers.JakartaTransactionMapper;
import com.fag.infra.jakarta.mappers.JakartaUserMapper;
import com.fag.infra.jakarta.model.JakartaTransaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JakartaTransactionRepository extends SimpleJpaRepository<JakartaTransaction, Long> implements ITransactionDataBaseRepository, ITransactionRepository {

    private final EntityManager em;

    @Autowired
    public JakartaTransactionRepository(EntityManager em) {
        super(JakartaTransaction.class, em);
        this.em = em;
    }

    /**
     * Persiste uma transação no banco de dados.
     *
     * @param bo O objeto TransactionBO a ser persistido.
     * @return Um objeto TransactionBO representando a transação persistida.
     */
    @Override
    public TransactionBO persist(TransactionBO bo) {
        JakartaTransaction entity = JakartaTransactionMapper.toEntity(bo);

        em.persist(entity);
        em.flush();

        return JakartaTransactionMapper.toDomain(entity);
    }

    /**
     * Busca uma transação pelo seu ID.
     *
     * @param id O ID da transação a ser encontrada.
     * @return Um objeto TransactionDTO representando a transação encontrada.
     * @throws TransactionException Se a transação não for encontrada, uma exceção
     *                              será lançada.
     */
    public TransactionDTO findTransactionById(Long id) {
        JakartaTransaction transaction = this.findById(id).orElse(null);

        if (transaction == null) {
            throw new TransactionException("Não existe um usuário cadastrado para este ID", 404);
        }

        return TransactionMapper.toDTO(JakartaTransactionMapper.toDomain(transaction));
    }

    /**
     * Lista todas as transações no banco de dados.
     *
     * @return Uma lista de objetos TransactionDTO representando todas as transações.
     */
    @Override
    public List<TransactionDTO> listAllTransactions() {
        List<JakartaTransaction> transactions = this.findAll();

        return transactions.stream()
                .map(jakartaTransaction -> TransactionMapper.toDTO(JakartaTransactionMapper.toDomain(jakartaTransaction)))
                .collect(Collectors.toList());
    }

    /**
     * Lista todas as transações associadas a um usuário.
     *
     * @param user O objeto UserDTO para o qual as transações estão associadas.
     * @return Uma lista de objetos TransactionDTO representando as transações
     * associadas ao usuário.
     */
    public List<TransactionDTO> listAllTransactionsByUser(UserDTO user) {
        TypedQuery<JakartaTransaction> query = em.createQuery("SELECT e FROM JakartaTransaction e WHERE e.sender = :sender OR e.receiver = :receiver", JakartaTransaction.class)
                .setParameter("sender", JakartaUserMapper.toEntity(UserMapper.toBO(user)))
                .setParameter("receiver", JakartaUserMapper.toEntity(UserMapper.toBO(user)));

        try {
            return query.getResultList().stream()
                    .map(jakartaTransaction -> TransactionMapper.toDTO(JakartaTransactionMapper.toDomain(jakartaTransaction)))
                    .collect(Collectors.toList());
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * Lista todas as transações em que um usuário é o remetente.
     *
     * @param sender O objeto UserDTO para o qual as transações de envio estão associadas.
     * @return Uma lista de objetos TransactionDTO representando as transações
     * de envio associadas ao usuário.
     */
    public List<TransactionDTO> listAllTransactionsBySender(UserDTO sender) {
        return listAllTransactionsByUserAndRole(sender, "sender");
    }

    /**
     * Lista todas as transações em que um usuário é o destinatário.
     *
     * @param receiver O objeto UserDTO para o qual as transações de recebimento
     *                 estão associadas.
     * @return Uma lista de objetos TransactionDTO representando as transações
     * de recebimento associadas ao usuário.
     */
    public List<TransactionDTO> listAllTransactionsByReceiver(UserDTO receiver) {
        return listAllTransactionsByUserAndRole(receiver, "receiver");
    }

    /**
     * Lista todas as transações em que um usuário é o remetente ou o destinatário.
     *
     * @param user O objeto UserDTO para o qual as transações estão associadas.
     * @param role A função do usuário na transação (remetente ou destinatário).
     * @return Uma lista de objetos TransactionDTO representando as transações
     * associadas ao usuário e função específica.
     */
    private List<TransactionDTO> listAllTransactionsByUserAndRole(UserDTO user, String role) {
        String queryStr = String.format("SELECT e FROM JakartaTransaction e WHERE e.%s = :user", role);
        TypedQuery<JakartaTransaction> query = em.createQuery(queryStr, JakartaTransaction.class)
                .setParameter("user", JakartaUserMapper.toEntity(UserMapper.toBO(user)));

        try {
            return query.getResultList().stream()
                    .map(jakartaTransaction -> TransactionMapper.toDTO(JakartaTransactionMapper.toDomain(jakartaTransaction)))
                    .collect(Collectors.toList());
        } catch (NoResultException e) {
            return null;
        }
    }

}
