package com.example.spring_program.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Table
@Getter
@Setter
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String email;
    private BigDecimal balance; // Баланс
    private LocalDateTime creationDate; // Дата создания

    public Account() {

    }

    public Account(Long id, String email, BigDecimal balance, LocalDateTime creationDate) {
        this.id = id;
        this.email = email;
        this.balance = balance;
        this.creationDate = creationDate;
    }

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> operations;

}
