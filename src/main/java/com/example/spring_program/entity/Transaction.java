package com.example.spring_program.entity;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;
@Table
@Getter
@Setter
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private BigDecimal operation; // Сумма операции
    private String description; // Тип операции
    private LocalDateTime dateOfExecution; // Дата выполнения

    public Transaction() {

    }

    public Transaction(Long id, BigDecimal operation, String description, LocalDateTime dateOfExecution) {
        this.id = id;
        this.operation = operation;
        this.description = description;
        this.dateOfExecution = dateOfExecution;
    }

    public enum OperationType {
        DEPOSIT, WITHDRAWAL // Внесение/Снятие
    }

    @Enumerated(EnumType.STRING)
    private OperationType type;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
