package com.fag.infra.jakarta.mappers;

import com.fag.domain.entities.UserBO;
import com.fag.infra.jakarta.model.JakartaUser;

public class JakartaUserMapper {


    /**
     * Converte um objeto UserBO para uma entidade JakartaUser.
     *
     * @param domain O objeto UserBO a ser convertido.
     * @return Uma nova entidade JakartaUser convertida a partir do UserBO fornecido.
     */
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

    /**
     * Converte uma entidade JakartaUser para um objeto UserBO.
     *
     * @param entity A entidade JakartaUser a ser convertida.
     * @return Um novo objeto UserBO convertido a partir da entidade JakartaUser fornecida.
     */
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
