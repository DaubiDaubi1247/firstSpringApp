package com.example.springapp1.exceptions;

public class UserNotFound extends Exception{
    public UserNotFound(String message) {
        super(message);
    }
}
