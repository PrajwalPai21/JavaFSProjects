package com.todo.todoapp.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


//Entity is to make it a database entity instead of a normal java class
@Entity // This is a combination of Getter and Setter
@Data public class Task {
    @Id
//    auto increment the ids using jpa
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String description;
    private boolean completed;
}
