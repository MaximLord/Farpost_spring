package com.example.spring_program.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Float operation; // Сумма операции
    private String description; // Описание операции
    private LocalDateTime dateOfExecution; // Дата выполнения

    public Transaction() {

    }

    public Transaction(Long id, Float operation, String description, LocalDateTime dateOfExecution) {
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

    public Float getOperation() {
        return operation;
    }

    public void setOperation(Float operation) {
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
