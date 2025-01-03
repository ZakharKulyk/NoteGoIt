package com.example.todolist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Note {
    @Id
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;


}
