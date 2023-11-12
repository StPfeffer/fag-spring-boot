package com.fag.domain.entities;

import com.fag.domain.enums.EnumUserType;

import java.math.BigDecimal;

public class UserBO {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String document;
    private final String email;
    private final String password;
    private final BigDecimal balance;
    private final EnumUserType userType;

    public UserBO(Long id, String firstName, String lastName, String document, String email, String password, BigDecimal balance, EnumUserType userType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public EnumUserType getUserType() {
        return userType;
    }

}
