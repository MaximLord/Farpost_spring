package com.example.spring_program.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private BigDecimal balance; // Баланс
    private LocalDateTime creationDate; // Дата создания

    public Account() {

    }

    public Account(Long id, BigDecimal balance, LocalDateTime creationDate) {
        this.id = id;
        this.balance = balance;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
