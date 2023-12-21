package com.example.demo.LException;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LUserException extends RuntimeException {

    public LUserException(Long id) {
        super("User not found with id: " + id);
    }
}
