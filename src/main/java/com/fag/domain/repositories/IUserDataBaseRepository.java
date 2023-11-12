package com.fag.domain.repositories;

import com.fag.domain.entities.UserBO;

public interface IUserDataBaseRepository {

    UserBO persist(UserBO bo);

}
