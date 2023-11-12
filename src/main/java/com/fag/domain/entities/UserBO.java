package com.fag.domain.entities;

import com.fag.domain.enums.EnumUserType;

import java.math.BigDecimal;

public record UserBO(Long id, String firstName, String lastName, String document, String email, String password, BigDecimal balance, EnumUserType userType) {
}
