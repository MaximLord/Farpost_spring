package com.example.spring_program.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private BigDecimal operation; // Сумма операции
    private String description; // Описание операции
    private LocalDateTime dateOfExecution; // Дата выполнения

    public Transaction() {

    }

    public Transaction(Long id, BigDecimal operation, String description, LocalDateTime dateOfExecution) {
        this.id = id;
        this.operation = operation;
        this.description = description;
        this.dateOfExecution = dateOfExecution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getOperation() {
        return operation;
    }

    public void setOperation(BigDecimal operation) {
        this.operation = operation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateOfExecution() {
        return dateOfExecution;
    }

    public void setDateOfExecution(LocalDateTime dateOfExecution) {
        this.dateOfExecution = dateOfExecution;
    }
}
