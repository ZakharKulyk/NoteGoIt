package com.example.todolist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Note {
    @Id
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;
}
