package com.fag.infra.jakarta.repository;

import com.fag.domain.entities.UserBO;
import com.fag.domain.repositories.IUserDataBaseRepository;
import com.fag.infra.jakarta.mappers.JakartaUserMapper;
import com.fag.infra.jakarta.model.JakartaUser;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class JakartaUserRepository extends SimpleJpaRepository<JakartaUser, Long> implements IUserDataBaseRepository {

    private final EntityManager em;

    public JakartaUserRepository(EntityManager em) {
        super(JakartaUser.class, em);
        this.em = em;
    }

    @Override
    public UserBO persist(UserBO bo) {
        JakartaUser entity = JakartaUserMapper.toEntity(bo);

        em.persist(entity);
        em.flush();

        return JakartaUserMapper.toDomain(entity);
    }

}
