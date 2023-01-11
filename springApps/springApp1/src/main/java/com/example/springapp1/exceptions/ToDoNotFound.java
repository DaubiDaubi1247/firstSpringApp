package com.example.springapp1.exceptions;

public class ToDoNotFound extends Exception{
    public ToDoNotFound(String message) {
        super(message);
    }
}
