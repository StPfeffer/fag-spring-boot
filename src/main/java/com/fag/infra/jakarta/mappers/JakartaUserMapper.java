package com.fag.infra.jakarta.mappers;

import com.fag.domain.entities.UserBO;
import com.fag.infra.jakarta.model.JakartaUser;

public class JakartaUserMapper {

    public static JakartaUser toEntity(UserBO domain) {
        return new JakartaUser(
                domain.getId(),
                domain.getFirstName(),
                domain.getLastName(),
                domain.getDocument(),
                domain.getEmail(),
                domain.getPassword(),
                domain.getBalance(),
                domain.getUserType()
        );
    }

    public static UserBO toDomain(JakartaUser entity) {
        return new UserBO(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getDocument(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getBalance(),
                entity.getUserType()
        );
    }

}
