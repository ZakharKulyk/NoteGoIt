package com.example.todolist.exception;

public class NoSuchUserFound extends Exception{
    public NoSuchUserFound(String text){
        super(text);
    }
}
