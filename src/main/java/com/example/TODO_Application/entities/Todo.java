package com.example.TODO_Application.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="todotable")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String taskContent;
    private String completionStatus;
}
