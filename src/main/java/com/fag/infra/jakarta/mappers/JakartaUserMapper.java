package com.fag.infra.jakarta.mappers;

import com.fag.domain.entities.UserBO;
import com.fag.infra.jakarta.model.JakartaUser;

public class JakartaUserMapper {

    public static JakartaUser toEntity(UserBO domain) {
        return new JakartaUser(
                domain.id(),
                domain.firstName(),
                domain.lastName(),
                domain.document(),
                domain.email(),
                domain.password(),
                domain.balance(),
                domain.userType()
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
