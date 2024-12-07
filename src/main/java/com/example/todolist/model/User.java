package com.example.todolist.model;


import jakarta.persistence.*;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    Integer userid;

    String password;
    @Column(name = "name")
    String username;

    @Column(name = "email")
    String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "NOTE_PROFILE",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "id"))
    List<Note>notes = new ArrayList<>();
}
